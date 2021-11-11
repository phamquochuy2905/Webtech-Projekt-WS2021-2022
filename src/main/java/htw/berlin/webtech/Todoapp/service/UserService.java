package htw.berlin.webtech.Todoapp.service;

import htw.berlin.webtech.Todoapp.api.User;
import htw.berlin.webtech.Todoapp.persistence.UserEntity;
import htw.berlin.webtech.Todoapp.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {

        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(userEntity -> new User(
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmail(),
                userEntity.getPassword()
        )).collect(Collectors.toList());
    }


}
