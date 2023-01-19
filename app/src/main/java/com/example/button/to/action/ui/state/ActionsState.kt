package com.example.button.to.action.ui.state

import com.example.button.to.action.domain.model.ActionType

sealed class ActionsState {
    object NoActions : ActionsState()
    object Loading : ActionsState()
    data class Error(val errorMessage: String) : ActionsState()
    data class PerformAction(val actionType: ActionType) : ActionsState()
}