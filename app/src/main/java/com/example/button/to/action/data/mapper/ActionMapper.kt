package com.example.button.to.action.data.mapper

import com.example.button.to.action.data.model.ActionDto
import com.example.button.to.action.domain.model.Action
import com.example.button.to.action.domain.model.ActionType

fun List<ActionDto>.toDomain(): List<Action> = map { it.toDomain() }

fun ActionDto.toDomain() = Action(
    type = ActionType.from(this.type),
    enabled = enabled,
    priority = priority,
    validDays = valid_days,
    coolDownMs = cool_down,
)
