package ph.goldthelocks.catapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<CatApiKtApplication>(*args)
}

@SpringBootApplication
@ConfigurationPropertiesScan
class CatApiKtApplication