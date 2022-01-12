package ph.goldthelocks.catapi.client

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "catapi")
data class CatApiProperties(
    val url: String,
    val apiKey: String
)