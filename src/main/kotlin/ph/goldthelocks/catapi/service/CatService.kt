package ph.goldthelocks.catapi.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ph.goldthelocks.catapi.dto.CatRequest
import ph.goldthelocks.catapi.entity.Cat
import ph.goldthelocks.catapi.repository.CatRepository

@Service
class CatService(val catRepository: CatRepository) {

    private val log = LoggerFactory.getLogger(CatService::class.java)

    fun getCats(): List<Cat> {
        log.info("Retrieving cats.")
        return catRepository.findAll()
    }

    fun save(catRequest: CatRequest): Long? {
        log.info("Creating new cat.")
        val cat = Cat()
        cat.name = catRequest.name
        cat.breed = catRequest.breed
        cat.age = catRequest.age

        return catRepository.save(cat).catId
    }

}