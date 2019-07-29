package example.micronaut.person
import java.util.*
import javax.inject.Singleton

@Singleton
class PersonService() {
	private val list = LinkedList<Person>()

	fun findAll(): LinkedList<Person> = list

	fun save(person: Person): Boolean {
		if (list.size < 3) {
			person.id = UUID.randomUUID().toString()
			list.push(person)
			return true
		}
		return false
	}

	fun cleanList() {
		while (list.iterator().hasNext()) list.pop()
	}

}
