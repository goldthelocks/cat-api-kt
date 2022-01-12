package ph.goldthelocks.catapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ph.goldthelocks.catapi.entity.Cat

@Repository
interface CatRepository : JpaRepository<Cat, Long> {
}