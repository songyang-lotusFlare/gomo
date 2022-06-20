package com.song.data.db.profile_info

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.song.model.profile.domin_models.GomoUserModel
import com.song.model.profile.response_models.GetGomoUserResult

@Entity(tableName = GomoUserEntity.TABLE_NAME)
data class GomoUserEntity (

    val name: String?,
    val sex: String?,
    val password: String?,
    @PrimaryKey(autoGenerate = false)
    val gomoNumber: String?,
    val phoneNumber: String?){
    companion object {
        const val TABLE_NAME = "gomo_user"
    }

    fun clone(): GomoUserEntity {
        return this.copy()
    }
}

fun GetGomoUserResult.toEntity() =
    GomoUserEntity(
        name,
        sex,
        password,
        gomoNumber,
        phoneNumber
    )

//
fun GomoUserEntity.toDomain() =
    GomoUserModel(
        name,
        sex,
        password,
        gomoNumber,
        phoneNumber
    )