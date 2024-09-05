package com.example.chat_room.data.remote

import com.example.chat_room.domain.model.Message
import com.example.chat_room.util.Resource
import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class ChatSocketServiceImpl(
    private val client: HttpClient
) : ChatSocketService {
    private var socket: WebSocketSession? = null
    override suspend fun initSession(userName: String): Resource<Unit> {
        return try {
            socket = client.webSocketSession {
                url("${ChatSocketService.EndPoints.ChatSocket.url}?username=$userName")
            }
            if (socket?.isActive == true){
                Resource.Success(Unit)
            } else Resource.Error("couldn't establish a connection")
        } catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.localizedMessage ?: "Unknown error!")
        }
    }

    override suspend fun sendMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun observeMessage(): Flow<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun closeSession() {
        TODO("Not yet implemented")
    }
}