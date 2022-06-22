package ph.com.globe.model.profile.domin_models

//assume wo need serial type

data class GomoUserModel(
    val name: String? = null,
    val sex: String? = null,
    val password: String? = null,
    val gomoNumber: String,
    val phoneNumber: String? = null,
)
