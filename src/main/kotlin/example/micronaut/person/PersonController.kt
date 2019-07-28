package example.micronaut.person

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject

@Controller("/persons")
class PersonController(
        private val logger: Logger? = LoggerFactory.getLogger(PersonController::class.java)
) {
    @Inject
    lateinit var personService: PersonService


    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun persons(): MutableHttpResponse<List<Person>>? {
        logger?.info("Getting all persons")
        val persons = personService.findAllPersons()
        return HttpResponse.ok(persons)
    }
}