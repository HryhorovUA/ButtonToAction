package com.example.button.to.action.data.repository

import com.example.button.to.action.data.mapper.toDomain
import com.example.button.to.action.data.retrofit.ActionsService
import com.example.button.to.action.domain.model.Action
import com.example.button.to.action.domain.repository.ActionsRepository
import retrofit2.await

class ActionsRepositoryImpl(private val actionsService: ActionsService) : ActionsRepository {

    override suspend fun getActions(): List<Action> {
        return actionsService.getActions().await().toDomain()
    }
}