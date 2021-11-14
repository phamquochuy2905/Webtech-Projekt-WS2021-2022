package htw.berlin.webtech.Todoapp.service;

import htw.berlin.webtech.Todoapp.api.User;
import htw.berlin.webtech.Todoapp.api.UserCreateOrUpdateRequest;
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
        return users.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public User create(UserCreateOrUpdateRequest request) {
        var userEntity = new UserEntity(request.getFirstname(), request.getLastname(),
                request.getEmail(), request.getPassword());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);

    }

    public User update(Long id, UserCreateOrUpdateRequest request) {
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()){
            return null;
        }

        var userEntity = userEntityOptional.get();
        userEntity.setFirstname(request.getFirstname());
        userEntity.setLastname(request.getLastname());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());

        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public boolean deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }

    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmail(),
                userEntity.getPassword() );
    }



}
