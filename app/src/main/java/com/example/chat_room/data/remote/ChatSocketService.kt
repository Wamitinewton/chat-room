package com.example.chat_room.data.remote

import com.example.chat_room.domain.model.Message
import com.example.chat_room.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        userName:String
    ): Resource<Unit>

    suspend fun sendMessage(message:String)

    fun observeMessage(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://192.168.1.40:8080"
    }

    sealed class EndPoints(val url: String){
        object ChatSocket: EndPoints("$BASE_URL/chat-socket")
    }
}