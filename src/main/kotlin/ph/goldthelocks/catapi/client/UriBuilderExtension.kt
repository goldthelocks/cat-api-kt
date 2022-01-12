package ph.goldthelocks.catapi.client

import org.springframework.web.util.UriBuilder

fun UriBuilder.queryParamIfPresent(param: String, value: Any?): UriBuilder {
    return value?.let { this.queryParam(param, value) } ?: this
}