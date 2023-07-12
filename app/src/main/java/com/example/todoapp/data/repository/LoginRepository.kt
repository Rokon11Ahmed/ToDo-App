package com.example.todoapp.data.repository

import com.example.todoapp.data.entity.network.LoginResponseModel
import com.example.todoapp.utils.Resource

interface LoginRepository {
    suspend fun login(email: String, password: String): Resource<LoginResponseModel>
}