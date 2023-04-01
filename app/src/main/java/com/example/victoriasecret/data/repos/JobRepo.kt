package com.example.victoriasecret.data.repos

import com.example.victoriasecret.data.CompositeRepo
import com.example.victoriasecret.data.Repo
import com.example.victoriasecret.data.model.Job
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

interface JobRepo : Repo<Job>{
    suspend fun refresh()
}

@Singleton
class JobRepoImpl
@Inject
constructor() : CompositeRepo<Job>(), JobRepo {
    override suspend fun refresh() {
        update { getJobData() }
    }

    private fun getJobData() = Job(
        "Software Engineer",
        "SDE-1",
        UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
    )
}