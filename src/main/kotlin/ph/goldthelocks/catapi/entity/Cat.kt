package ph.goldthelocks.catapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var catId: Long? = null

    @Column
    var name: String? = null

    @Column
    var age: Int? = null

    @Column
    var breed: String? = null

}