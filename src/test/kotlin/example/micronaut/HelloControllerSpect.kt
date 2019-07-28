package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object HelloControllerSpect : Spek({
    describe("Hello Controller Suite") {
        val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(embeddedServer.url)

        it("test /hello responds hello world") {
            val response = client.toBlocking().retrieve("/hello")
            assertEquals(response, "Hello World")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})