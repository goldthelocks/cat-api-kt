package ph.goldthelocks.catapi.client

import net.logstash.logback.argument.StructuredArguments.kv
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ph.goldthelocks.catapi.dto.BreedResponse
import reactor.core.publisher.Mono

@Component
class CatApiClient(val catApiWebClient: WebClient, val properties: CatApiProperties) {

    private val log = LoggerFactory.getLogger(CatApiClient::class.java)

    fun getBreeds(page: Int?, limit: Int?): Mono<List<BreedResponse>> {
        log.info("Retrieving breeds. {} {}", kv("page", page), kv("limit", limit))

        try {
            return catApiWebClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .path("/breeds")
                        .queryParamIfPresent("page", page)
                        .queryParamIfPresent("limit", limit)
                        .build()
                }
                .header("x-api-key", properties.apiKey)
                .retrieve()
                .bodyToMono(object : ParameterizedTypeReference<List<BreedResponse>>() {})
        } catch (ex: Exception) {
            log.info("Failed to retrieve breeds", ex)
            throw ex
        }
    }
}