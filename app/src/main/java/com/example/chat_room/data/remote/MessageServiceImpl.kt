package com.example.chat_room.data.remote

import com.example.chat_room.data.remote.dto.MessageDto
import com.example.chat_room.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessage(): List<Message> {
        return try {
            client.get {
                url(MessageService.EndPoints.GetAllMessages.url)
            }.body<List<MessageDto>>()
                .map { it.toMessage() }

        } catch (e: Exception) {
            emptyList()
        }
    }
}