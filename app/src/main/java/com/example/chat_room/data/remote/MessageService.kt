package com.example.chat_room.data.remote

import com.example.chat_room.domain.model.Message

interface MessageService {

    suspend fun getAllMessage(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.1.40:8080"
    }

    sealed class EndPoints(val url: String){
        object GetAllMessages: EndPoints("$BASE_URL/messages")
    }
}