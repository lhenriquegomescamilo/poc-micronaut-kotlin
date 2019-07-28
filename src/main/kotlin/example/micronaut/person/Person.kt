package example.micronaut.person

import com.fasterxml.jackson.annotation.JsonProperty

data class Person(
		@JsonProperty("id")
		val id: Long,
		@JsonProperty("name")
		val name: String
)
