package com.nerdpros.newshome.data.local.repo

import androidx.lifecycle.LiveData
import com.nerdpros.newshome.data.local.AppDatabase
import com.nerdpros.newshome.data.local.dao.UserDAO
import com.nerdpros.newshome.data.local.entity.UserEntity

/**
 * @Author: Angatia Benson
 * @Date: 26/08/2022
 * Copyright (c) 2022 Bantechnis
 */
class UserRepository {
    private var userDAO: UserDAO

    init {
        val appDatabase = AppDatabase.getInstance()
        userDAO = appDatabase.userDao()
    }

    suspend fun saveUser(userEntity: UserEntity) = userDAO.saveUser(userEntity)

    fun updateUser(userEntity: UserEntity) = userDAO.updateUser(userEntity)

    fun removeUser(userEntity: UserEntity) = userDAO.removeUser(userEntity)

    fun getUser(): LiveData<UserEntity> = userDAO.getUser()
}