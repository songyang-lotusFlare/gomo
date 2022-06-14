package com.song.gomo.data.model.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.song.gomo.utils.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


data class UserPreferences(

    val type : String = "",
    val role : String = "",
    val email : String = "",
    val password : String = "",
    val version : String = "",

    val gomoNumber : String,
    val phoneNumber : String
)

data class TokenPreferences(
    val refreshAuthorization : String,
    val idAuthorization : String
)

val Context.dataStore by preferencesDataStore(
    name = DATASTORE_NAME
)

@Singleton
class PreferencesDataStore @Inject constructor(@ApplicationContext appContext: Context) {

    private val dataStore = appContext.dataStore

    private object PreferencesKeys {

        val ID_TOKEN_KEY = stringPreferencesKey(ID_AUTHORIZATION_TOKEN)
        val REFRESH_TOKEN_KEY = stringPreferencesKey(REFRESH_AUTHORIZATION_TOKEN)

        val GOMO_NUMBER_KEY = stringPreferencesKey(GOMO_NUMBER)
        val PHONE_NUMBER_KEY = stringPreferencesKey(PHONE_NUMBER)
    }

    private val tokenPreferencesFlow : Flow<TokenPreferences> = dataStore.data
        .catch { exception ->
            throw exception
        }.map {
            mapTokenPreferences(it)
        }

    private val userPreferencesFlow : Flow<UserPreferences> = dataStore.data
        .catch { exception ->
            throw exception
        }.map {
            mapUserPreferences(it)
        }

    suspend fun getIdAuthorization() : String{
        return tokenPreferencesFlow.first().idAuthorization
    }

    suspend fun getRefreshAuthorization() : String{
        return tokenPreferencesFlow.first().refreshAuthorization
    }

    suspend fun updateTokenPreferences(tokenPreferences : TokenPreferences) {
        dataStore.edit {
            it[PreferencesKeys.ID_TOKEN_KEY] = tokenPreferences.idAuthorization
            it[PreferencesKeys.REFRESH_TOKEN_KEY] = tokenPreferences.refreshAuthorization
        }
    }

    suspend fun updateRefreshToken(refreshToken : String) {
        dataStore.edit {
            it[PreferencesKeys.REFRESH_TOKEN_KEY] = refreshToken
        }
    }

    suspend fun updateIdToken(idToken : String) {
        dataStore.edit {
            it[PreferencesKeys.ID_TOKEN_KEY] = idToken
        }
    }

    private fun mapTokenPreferences(it: Preferences) : TokenPreferences{
        val idAuthorization = it[PreferencesKeys.ID_TOKEN_KEY] ?: ""
        val refreshAuthorization = it[PreferencesKeys.REFRESH_TOKEN_KEY] ?: ""
        return TokenPreferences(idAuthorization, refreshAuthorization)
    }

    suspend fun getGomoNumber() : String{
        return userPreferencesFlow.first().gomoNumber
    }

    suspend fun getPhoneNumber() : String{
        return userPreferencesFlow.first().phoneNumber
    }

    suspend fun updateUserPreferences(userPreferences: UserPreferences) {
        dataStore.edit {
            it[PreferencesKeys.GOMO_NUMBER_KEY] = userPreferences.gomoNumber
            it[PreferencesKeys.PHONE_NUMBER_KEY] = userPreferences.phoneNumber
        }
    }

    suspend fun updateGomoNumber(gomoNumber: String) {
        dataStore.edit {
            it[PreferencesKeys.GOMO_NUMBER_KEY] = gomoNumber
        }
    }

    suspend fun updatePhoneNumber(phoneNumber: String) {
        dataStore.edit {
            it[PreferencesKeys.PHONE_NUMBER_KEY] = phoneNumber
        }
    }
    private fun mapUserPreferences(it: Preferences) : UserPreferences{
        val gomoNumber = it[PreferencesKeys.GOMO_NUMBER_KEY] ?: ""
        val phoneNumber = it[PreferencesKeys.PHONE_NUMBER_KEY] ?: ""
        return UserPreferences(gomoNumber = gomoNumber, phoneNumber = phoneNumber)
    }

}