package com.example.chat_room.presentation.chat

import com.example.chat_room.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
