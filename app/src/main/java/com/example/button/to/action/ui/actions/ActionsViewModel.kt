package com.example.button.to.action.ui.actions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.button.to.action.common.DateUtil
import com.example.button.to.action.domain.repository.ActionsRepository
import com.example.button.to.action.ui.state.ActionsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ActionsViewModel(private val actionsRepository: ActionsRepository) : ViewModel() {

    private val _actionsScreenStateFlow = MutableStateFlow<ActionsState>(ActionsState.NoActions)
    var actionsScreenStateFlow = _actionsScreenStateFlow.asStateFlow()

    fun performAction() {
        viewModelScope.launch {
            try {
                _actionsScreenStateFlow.value = ActionsState.Loading
                val currentWeekDay = DateUtil.currentWeekDay()
                val chosenAction = actionsRepository.getActions()
                    .filter { it.enabled }
                    .filter { it.validDays.contains(currentWeekDay) }
                    // TODO("Filter by cool down")
                    .maxBy { it.priority }

                if (chosenAction.type == null) {
                    _actionsScreenStateFlow.value = ActionsState.Error("Unsupported Action")
                    return@launch
                }
                _actionsScreenStateFlow.value = ActionsState.PerformAction(chosenAction.type)
            } catch (error: Exception) {
                _actionsScreenStateFlow.value = ActionsState.Error(error.toString())
            }
        }
    }
}