package com.nerdpros.newshome.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * @Author: Angatia Benson
 * @Date: 26/08/2022
 * Copyright (c) 2022 Bantechnis
 */

data class DefaultResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String
)

data class LoginResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("user") val user: UserModelResponse
)

data class UserModelResponse(
    @SerializedName("id") val id :String,
    @SerializedName("email")  val email:String,
    @SerializedName("name") val name:String,
    @SerializedName("session_token") val sessionToken:String
)
