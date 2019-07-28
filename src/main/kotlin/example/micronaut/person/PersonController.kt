package example.micronaut.person

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
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
        val persons = personService.findAll()
        return HttpResponse.ok(persons)
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun save(@Body person: Person) = if (personService.save(person)) HttpStatus.OK else HttpStatus.BAD_GATEWAY
}