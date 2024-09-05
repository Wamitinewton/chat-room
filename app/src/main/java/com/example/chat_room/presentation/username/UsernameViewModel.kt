package com.example.chat_room.presentation.username

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsernameViewModel @Inject constructor() : ViewModel() {

    private val _userNameText = mutableStateOf("")
    val usernameText: State<String> = _userNameText

    private val _onJoinChat = MutableSharedFlow<String>()
    val onJoin = _onJoinChat.asSharedFlow()

    fun onUsernameChange(username: String) {
        _userNameText.value = username
    }

    fun onClickJoin() {
        viewModelScope.launch {
            _onJoinChat.emit(usernameText.value)
        }
    }
}