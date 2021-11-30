package controller

import model.Channel
import model.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import repo.ChatChannelRepo
import repo.ChatMessageRepo

@RestController
class ChatMessageController {
    @Autowired
    private lateinit var chatChannelRepo: ChatChannelRepo

    @Autowired
    private lateinit var chatMessageRepo: ChatMessageRepo
    @PostMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    fun postChat( @RequestBody chatMessage: Message) {
        //chatMessageRepo.save(chatMessage).subscribe();
        chatMessageRepo.insert(chatMessage).subscribe()
    }

    @PostMapping("/channels")
    fun createChannel( @RequestBody channel: Channel): Mono<Channel> {
        return chatChannelRepo.save<Channel>(channel)
    }
    @GetMapping(value = ["/chats/stream"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamMessages(@RequestParam channelId: String?): Flux<Message> {
        return chatMessageRepo.findWithTailableCursorByChannelId(channelId!!)
    }
}
