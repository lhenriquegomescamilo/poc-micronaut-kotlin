package example.micronaut.person

import com.fasterxml.jackson.annotation.JsonProperty

data class Person(
		@JsonProperty("id")
		var id: String?,
		@JsonProperty("name")
		var name: String
)
