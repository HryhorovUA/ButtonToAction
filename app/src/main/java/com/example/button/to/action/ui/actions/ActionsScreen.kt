package com.example.button.to.action.ui.actions

import android.content.Intent
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import com.example.button.to.action.common.NotificationUtil
import com.example.button.to.action.domain.model.ActionType
import com.example.button.to.action.ui.compose.ProgressBar
import com.example.button.to.action.ui.state.ActionsState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun ActionsScreen() {
    val viewModel = getViewModel<ActionsViewModel>()
    val buttonRotation = remember { Animatable(0f) }
    DefaultPage(viewModel::performAction, buttonRotation.value)
    Render(viewModel, buttonRotation)
}

@Composable
private fun Render(
    viewModel: ActionsViewModel,
    buttonRotation: Animatable<Float, AnimationVector1D>,
) {
    when (val state = viewModel.actionsScreenStateFlow.collectAsState().value) {
        is ActionsState.NoActions -> {
            // Nothing
        }
        is ActionsState.Error -> {
            Error(state.errorMessage)
        }
        is ActionsState.PerformAction -> {
            Action(state.actionType, buttonRotation)
        }
        is ActionsState.Loading -> {
            ProgressBar()
        }
    }
}

@Composable
private fun DefaultPage(
    performAction: () -> Unit,
    rotation: Float,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            modifier = Modifier
                .align(Alignment.Center)
                .rotate(rotation),
            onClick = { performAction() }
        ) {
            Text(text = "Action!")
        }
    }
}

@Composable
private fun Action(actionType: ActionType, buttonRotation: Animatable<Float, AnimationVector1D>) {
    when (actionType) {
        ActionType.TOAST -> {
            Toast.makeText(LocalContext.current, "Action is Toast!", Toast.LENGTH_LONG).show()
        }
        ActionType.ANIMATION -> {
            val coroutineScope = rememberCoroutineScope()
            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    val rotation = if (buttonRotation.value == 0f) 360f else 0f
                    buttonRotation.animateTo(rotation)
                }
            }
        }
        ActionType.CALL -> {
            // TODO("Intent should navigate to separate contacts screen or handle contact selection")
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            LocalContext.current.startActivity(intent)
        }
        ActionType.NOTIFICATION -> {
            // TODO("Intent should navigate to separate contacts screen or handle contact selection")
            NotificationUtil.showNotification(
                LocalContext.current,
                Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            )
        }
    }
}

@Composable
private fun Error(errorMessage: String) {
    Log.e("ActionsScreen", errorMessage)
}