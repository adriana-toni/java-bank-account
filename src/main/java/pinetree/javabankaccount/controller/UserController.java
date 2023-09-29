package pinetree.javabankaccount.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pinetree.javabankaccount.domain.model.User;
import pinetree.javabankaccount.dtos.UserDto;
import pinetree.javabankaccount.service.UserService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    // Injeção de dependência via construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        var user = userService.findById(id);

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto UserToCreateDto) {

        User user = new User();
        BeanUtils.copyProperties(UserToCreateDto, user);

        var userCreated = userService.create(user);

        UserDto userCreatedDto = new UserDto();
        BeanUtils.copyProperties(userCreated, userCreatedDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreatedDto);
    }

}
