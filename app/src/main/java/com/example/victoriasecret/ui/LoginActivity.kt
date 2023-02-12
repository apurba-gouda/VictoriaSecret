package com.example.victoriasecret.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.victoriasecret.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LogInViewModel
    private lateinit var logInViewModelFactory: LoginViewModelFactory
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logInViewModelFactory = LoginViewModelFactory()
        loginViewModel = ViewModelProviders.of(this, logInViewModelFactory)[LogInViewModel::class.java]
    }

}
