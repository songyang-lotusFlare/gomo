package ph.com.globe.data.db.profile_info

import androidx.room.Entity
import androidx.room.PrimaryKey
import ph.com.globe.model.profile.domain_models.GomoUser
import ph.com.globe.model.profile.response_models.GetGomoUserResult

@Entity(tableName = GomoUserEntity.TABLE_NAME)
data class GomoUserEntity(
    val name: String?,
    val sex: String?,
    val password: String?,
    @PrimaryKey(autoGenerate = false)
    val gomoNumber: String,
    val phoneNumber: String?
) {
    companion object {
        const val TABLE_NAME = "gomo_user"
    }
}

//convert network response to db entity
fun GetGomoUserResult.toUserEntity() =
    GomoUserEntity(
        name,
        sex,
        password,
        gomoNumber,
        phoneNumber
    )

//convert db entity to domain object
fun GomoUserEntity.toUserDomain() =
    GomoUser(
        name,
        sex,
        password,
        gomoNumber,
        phoneNumber
    )
