package com.example.chat_room.data.remote.dto

import com.example.chat_room.domain.model.Message
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.util.Date

@Serializable
data class MessageDto(
    val text: String,
    val userName: String,
    val timeStamp: Long,
    val id: String
) {
    fun toMessage(): Message {
        val date = Date(timeStamp)
        val formatedDate = DateFormat
            .getDateInstance(DateFormat.DEFAULT)
            .format(date)
        return Message(
            formatedTime = formatedDate,
            userName = userName,
            text = text
        )
    }
}
