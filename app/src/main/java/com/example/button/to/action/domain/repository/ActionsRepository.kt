package com.example.button.to.action.domain.repository

import com.example.button.to.action.domain.model.Action

interface ActionsRepository {

    suspend fun getActions(): List<Action>
}
