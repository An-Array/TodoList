package com.daike.basictodo

import android.app.Application
import androidx.room.Room
import com.daike.basictodo.database.TodoDatabase
import com.daike.basictodo.repositories.TodoRepo
import com.daike.basictodo.repositories.TodoRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp:Application()   {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module{
                single{
                    Room
                        .databaseBuilder(this@KoinApp, TodoDatabase::class.java, "db")
                        .build()
                }
                single {
                    TodoRepoImpl(database = get())
                } bind TodoRepo::class
            })
        }
    }
}