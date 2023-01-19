package com.example.button.to.action.data.retrofit

import com.example.button.to.action.data.model.ActionDto
import retrofit2.Call
import retrofit2.http.GET

interface ActionsService {

    @GET("/androidexam/butto_to_action_config.json")
    fun getActions(): Call<List<ActionDto>>
}