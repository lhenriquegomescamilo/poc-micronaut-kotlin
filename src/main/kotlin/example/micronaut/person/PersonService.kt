package example.micronaut.person


import io.reactiverse.pgclient.PgPoolOptions
import io.reactiverse.reactivex.pgclient.PgClient
import io.reactiverse.reactivex.pgclient.PgPool
import java.util.*
import javax.inject.Singleton

@Singleton
class PersonService(
		private val client: PgPool = PgClient.pool(PgPoolOptions()
				.setPort(5432)
				.setHost("localhost")
				.setDatabase("postgres")
				.setUser("postgres")
				.setPassword("postgres")
				.setMaxSize(5))

) {

	fun findAllPersons(): List<Person> {
		val persons = LinkedList<Person>()
		val pgIterator = client.rxPreparedQuery("SELECT id, name FROM Persons").blockingGet().iterator()
		while (pgIterator.hasNext()) {
			val row = pgIterator.next()
			persons.push(Person(row.getLong("id"), row.getString("name")))
		}
		return persons
	}

}
