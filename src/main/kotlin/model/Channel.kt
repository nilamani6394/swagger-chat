package model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "channels")
class Channel {
    @Id
    var id: String = ""
    var firstUser: String = ""
    var secondUser: String = ""

    constructor() {}
    constructor(firstUser: String, secondUser: String) : super() {
        this.firstUser = firstUser
        this.secondUser = secondUser
    }
}
