package example.micronaut.person


import io.reactiverse.pgclient.PgPoolOptions
import io.reactiverse.reactivex.pgclient.PgClient
import io.reactiverse.reactivex.pgclient.PgPool
import io.reactiverse.reactivex.pgclient.Tuple
import java.util.*
import javax.inject.Singleton

@Singleton
class PersonService() {

	private var client: PgPool

	init {
		client = PgClient.pool(PgPoolOptions()
				.setPort(5432)
				.setHost("localhost")
				.setDatabase("postgres")
				.setUser("postgres")
				.setPassword("postgres")
				.setMaxSize(5))
	}

	fun findAll(): List<Person> {
		val persons = LinkedList<Person>()
		val pgIterator = client.rxPreparedQuery("SELECT id, name FROM Persons").blockingGet().iterator()
		while (pgIterator.hasNext()) {
			val row = pgIterator.next()
			persons.push(Person(row.getLong("id"), row.getString("name")))
		}
		return persons
	}

	fun save(person: Person): Boolean {
		val querytToInsert = "INSERT INTO users (id, name) VALUES ($1, $2) ON CONFLICT (id) DO UPDATE SET name = $3"
		client.preparedQuery(querytToInsert, Tuple.of(person.id, person.name, person.name)) { }
		return true
	}

}
