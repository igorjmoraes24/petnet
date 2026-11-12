package com.petnet.petnet.controller;

import com.petnet.petnet.model.User;
import com.petnet.petnet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.showAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        User user = userService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User novoUser = userService.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userAtualizado = userService.updateUser(id, user);
        return ResponseEntity.ok(userAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteuUer(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
