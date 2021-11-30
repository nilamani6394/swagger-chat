package model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "messages")
class Message {
    var message: String = ""
    var sender: String = ""
    var sendee: String = ""
    var channelId: String = ""

    constructor(message: String, sender: String, sendee: String, channelId: String) {
        this.message = message
        this.sender = sender
        this.sendee = sendee
        this.channelId = channelId
    }

    constructor() {}
}
