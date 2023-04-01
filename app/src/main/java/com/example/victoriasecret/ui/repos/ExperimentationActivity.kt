package com.example.victoriasecret.ui.repos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.victoriasecret.MyApplication
import com.example.victoriasecret.data.model.Status
import com.example.victoriasecret.data.repos.JobRepo
import com.example.victoriasecret.databinding.ActivityExperimentationBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExperimentationActivity : AppCompatActivity() {
    @Inject
    lateinit var jobRepo: JobRepo

    private val vb by lazy {
        ActivityExperimentationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.appComponent.inject(this)

        setContentView(vb.root)

        lifecycleScope.launch {
            RefreshRepoHandler().invoke()
            launch { InitValueStreamHandler().invoke() }
            launch { InitStatusStreamHandler().invoke() }
        }
    }

    inner class RefreshRepoHandler {

        suspend operator fun invoke() {
            refreshRepo()
        }

        private suspend fun refreshRepo() {
            try {
                if (jobRepo.lastStatus != Status.ERROR) jobRepo.refresh()
            } catch (e: Exception) {
                println("Repo Exception Are: ${e.message}")
            }
        }
    }

    inner class InitValueStreamHandler {

        suspend operator fun invoke() {
            handleValuesStream()
        }

        private suspend fun handleValuesStream() {
            jobRepo.values
                .collect { println("Repo Values Are: $it") }
        }
    }

    inner class InitStatusStreamHandler {

        suspend operator fun invoke() {
            handleStatusStream()
        }

        private suspend fun handleStatusStream() {
            jobRepo.statusStream
                .collect { println("Repo Stream Are: $it") }
        }
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            jobRepo.refresh()
        }
    }
}