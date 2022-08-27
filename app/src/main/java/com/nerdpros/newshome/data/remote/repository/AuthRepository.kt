package com.nerdpros.newshome.data.remote.repository

import com.nerdpros.newshome.data.remote.network.RetroClient
import com.nerdpros.newshome.data.remote.response.DefaultResponse
import com.nerdpros.newshome.data.remote.response.LoginResponse
import com.nerdpros.newshome.model.Login
import com.nerdpros.newshome.model.SignUp
import io.reactivex.Single

/**
 * @Author: Angatia Benson
 * @Date: 26/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class AuthRepository {
    private val api = RetroClient.getApi()

    fun login(_login: Login): Single<LoginResponse> = api.login(_login)

    fun signup(_signup: SignUp): Single<DefaultResponse> = api.signup(_signup)
}