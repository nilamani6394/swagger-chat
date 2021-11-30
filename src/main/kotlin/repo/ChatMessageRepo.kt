package repo

import model.Message
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import reactor.core.publisher.Flux


interface ChatMessageRepo : ReactiveMongoRepository<Message,String> {
    @Tailable
    fun findWithTailableCursorByChannelId(channelId: String): Flux<Message>
}