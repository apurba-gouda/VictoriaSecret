package com.example.victoriasecret.di

import android.content.Context
import com.example.victoriasecret.MyApplication
import com.example.victoriasecret.data.repos.JobRepo
import com.example.victoriasecret.data.repos.JobRepoImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule(
    private val appContext: MyApplication,
) {
    @Singleton
    fun provideAppContextContext(): Context = appContext.applicationContext

    @Singleton
    @Binds
    internal abstract fun provideRepo(jobRepoImpl: JobRepoImpl): JobRepo
}