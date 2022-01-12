package ph.goldthelocks.catapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BreedResponse(
    var id: String = "",
    var name: String = "",
    var temperament: String = "",

    @JsonProperty("life_span")
    var lifeSpan: String = "",

    )