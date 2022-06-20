package ph.com.globe.model.profile.response_models

import com.squareup.moshi.JsonClass


// request params
data class GetGomoUserParams(
    val id: String,
    val other: String? = null
)

fun GetGomoUserParams.toQueryMap(): Map<String, String> =
    mapOf(
        "KEY_P1" to (id ?:" "),
        "KEY_P2" to (other ?:" "),
    )

// direct Response from net
@JsonClass(generateAdapter = true)
data class GetGomoUserResponse(
    val result: GetGomoUserResult
)

@JsonClass(generateAdapter = true)
data class GetGomoUserResult(
    val name: String? = null,
    val sex: String? = null,
    val password: String? = null,
    val gomoNumber: String,
    val phoneNumber: String? = null,
)
