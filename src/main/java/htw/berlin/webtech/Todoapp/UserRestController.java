package htw.berlin.webtech.Todoapp;

import htw.berlin.webtech.Todoapp.api.User;
import htw.berlin.webtech.Todoapp.persistence.UserRepository;
import htw.berlin.webtech.Todoapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

   private final UserService userService;

   public UserRestController(UserService userService) {
       this.userService = userService;
   }

    @GetMapping(path = "/api/v1/users" )
    public ResponseEntity<List<User>> fetchUser() {
      return ResponseEntity.ok(userService.findAll());
    }
}
