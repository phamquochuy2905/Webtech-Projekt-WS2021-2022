package htw.berlin.webtech.Todoapp;

import htw.berlin.webtech.Todoapp.api.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private List<User> users;

    public UserRestController() {
        users = new ArrayList<>();
        users.add(new User(1,"Huy", "Pham", "phamquochuy2905@gmail.com"," "));
        users.add(new User(2, "Ronaldo", "Cristiano","cr7@gmail.com", " "));
    }

    @GetMapping(path = "/api/v1/users" )
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> fetchUser() {
        return users;
    }
}
