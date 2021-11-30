package repo

import model.Channel
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatChannelRepo :ReactiveMongoRepository<Channel,String> {
}