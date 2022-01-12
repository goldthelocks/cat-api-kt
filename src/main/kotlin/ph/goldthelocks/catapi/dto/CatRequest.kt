package ph.goldthelocks.catapi.dto

data class CatRequest(
    var name: String,
    var age: Int,
    var breed: String
)