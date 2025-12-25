package com.boudaa.user_service.controllers;


import com.boudaa.user_service.bo.User;
import com.boudaa.user_service.dto.UserDto;
import com.boudaa.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> finUserById(@PathVariable("id") long idUser) {

        //On appel le service métier pour chercher l'utilisateur par ID
        User user = userService.findUserById(idUser);

        //Si introuvable on retourne http code not found
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        //Créer un DTO
        UserDto userDto = new UserDto();

        //Copier les données vers le DTO
        userDto.setIdUser(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        //Retourner la réponse sous forme d'un TDO
        
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        //Créer un User (enity)
        User user = new User();

        //Copier les données recu sous forme de DTO vers un entité
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

       return ResponseEntity.ok(userService.createUser(user));
    }
}
