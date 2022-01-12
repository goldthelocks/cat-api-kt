package ph.goldthelocks.catapi.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ph.goldthelocks.catapi.client.CatApiClient
import ph.goldthelocks.catapi.dto.BreedResponse

@RestController
@RequestMapping("/v1/breeds")
class BreedController(val catApiClient: CatApiClient) {

    private val log = LoggerFactory.getLogger(BreedController::class.java)

    @GetMapping
    fun getBreeds(
        @RequestParam(required = false) page: Int?,
        @RequestParam(required = false) limit: Int?
    ): List<BreedResponse> {
        log.info("Received request to retrieve breeds")
        return catApiClient.getBreeds(page, limit).block() ?: emptyList()
    }

}