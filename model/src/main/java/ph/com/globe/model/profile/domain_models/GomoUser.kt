package ph.com.globe.model.profile.domain_models

//Entity classes required by app layer
data class GomoUser(
    val name: String? = null,
    val sex: String? = null,
    val password: String? = null,
    val gomoNumber: String,
    val phoneNumber: String? = null,
)
