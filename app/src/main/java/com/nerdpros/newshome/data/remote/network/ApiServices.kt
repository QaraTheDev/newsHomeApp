package com.nerdpros.newshome.data.remote.network

import com.nerdpros.newshome.data.remote.response.DefaultResponse
import com.nerdpros.newshome.data.remote.response.LoginResponse
import com.nerdpros.newshome.model.Login
import com.nerdpros.newshome.model.SignUp
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: Angatia Benson
 * @Date: 25/08/2022
 * Copyright (c) 2022 Bantechnis
 */
interface ApiServices {
    @POST("login")
    fun login(@Body _login: Login): Single<LoginResponse>

    @POST("signup")
    fun signup(@Body _signup: SignUp): Single<DefaultResponse>
}