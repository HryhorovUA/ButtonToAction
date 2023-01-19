package com.example.button.to.action.data.model

/**
 * Response example:
"type": "animation",
"enabled": true,
"priority": 10,
"valid_days": [0,1,3],
"cool_down": 86400000
 **/

data class ActionDto(
    val type: String,
    val enabled: Boolean,
    val priority: Int,
    val valid_days: List<Int>,
    val cool_down: Long,
)