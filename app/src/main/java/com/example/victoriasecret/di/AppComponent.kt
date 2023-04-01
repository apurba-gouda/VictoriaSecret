package com.example.victoriasecret.di

import com.example.victoriasecret.data.repos.JobRepo
import com.example.victoriasecret.ui.repos.ExperimentationActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: ExperimentationActivity)
    fun provideRepo(): JobRepo
}