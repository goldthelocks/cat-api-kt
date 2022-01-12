package ph.goldthelocks.catapi.controller

import net.logstash.logback.argument.StructuredArguments.kv
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ph.goldthelocks.catapi.dto.CatRequest
import ph.goldthelocks.catapi.entity.Cat
import ph.goldthelocks.catapi.service.CatService

@RestController
@RequestMapping("/v1/cats")
class CatController(val catService: CatService) {

    private val log = LoggerFactory.getLogger(CatController::class.java)

    @GetMapping
    fun get(): List<Cat> {
        log.info("Received request to retrieve cats.")
        return catService.getCats()
    }

    @PostMapping
    fun save(@RequestBody catRequest: CatRequest): Long {
        log.info(
            "Received request to save cats. {}",
            kv("cat", catRequest)
        )

        return catService.save(catRequest) ?: 0L
    }

}