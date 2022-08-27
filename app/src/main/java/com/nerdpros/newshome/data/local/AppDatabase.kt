package com.nerdpros.newshome.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nerdpros.newshome.App
import com.nerdpros.newshome.data.local.dao.UserDAO
import com.nerdpros.newshome.data.local.entity.UserEntity

/**
 * @Author: Angatia Benson
 * @Date: 26/08/2022
 * Copyright (c) 2022 Bantechnis
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {
        private var mAppDatabase: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (mAppDatabase == null) {
                synchronized(AppDatabase::class) {
                    mAppDatabase = Room.databaseBuilder(
                        App.application.applicationContext,
                        AppDatabase::class.java, "newshome"
                    ).build()
                }
            }
            return mAppDatabase!!
        }
    }

}