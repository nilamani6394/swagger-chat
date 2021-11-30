package controller

import model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import repo.UserRepository

@RestController
class UserController {
    @Autowired
    private lateinit var userRepo:UserRepository

    @PostMapping("/users")
    fun saveUser(@RequestBody user: User): Mono<User> {
        return userRepo.save(user)
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: String): Mono<ResponseEntity<User>> {
        return userRepo.findById(id).map { savedUser -> ResponseEntity.ok(savedUser) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}
