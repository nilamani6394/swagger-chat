package model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
class User{
  @Id
  var id: String =""
  var userName: String =""

  constructor(userName: String) {
   this.userName = userName
  }

  constructor() {}

 }

