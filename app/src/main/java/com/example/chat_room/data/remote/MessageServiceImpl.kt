package com.example.chat_room.data.remote

import com.example.chat_room.data.remote.dto.MessageDto
import com.example.chat_room.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MessageServiceImpl(
    private val client: HttpClient
): MessageService{

    override suspend fun getAllMessage(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.EndPoints.GetAllMessages.url)
        }catch (e: Exception){
            emptyList()
        }
    }
}