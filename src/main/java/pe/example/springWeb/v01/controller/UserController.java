package pe.example.springWeb.v01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pe.example.springWeb.v01.controller.dto.UserItem;
import pe.example.springWeb.v01.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserItem userItem) {
        userService.create(userItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Void> authenticate() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
