package com.example.button.to.action.domain.model

enum class ActionType(val raw: String) {
    ANIMATION("animation"),
    TOAST("toast"),
    CALL("call"),
    NOTIFICATION("notification");

    companion object {

        fun from(raw: String): ActionType? = values().find { it.raw == raw }
    }
}
