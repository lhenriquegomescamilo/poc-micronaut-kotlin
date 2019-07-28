package example.micronaut

import io.micronaut.runtime.Micronaut
import org.slf4j.LoggerFactory

object Application {
    private val log = LoggerFactory.getLogger(Application.javaClass)
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.micronaut")
                .mainClass(Application.javaClass)
                .start()
        log.info("The application is using ${Runtime.getRuntime().totalMemory() / 1024 / 1024} mb ")
    }
}