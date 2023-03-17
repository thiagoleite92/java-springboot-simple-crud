package first_project.banco.service;

import first_project.banco.model.UserModel;
import first_project.banco.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel saveUser(UserModel user) {
        System.out.println("chegou no service");
        return userRepository.save(user);
    }

    public UserModel getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new EntityNotFoundException(
                "Usuário não encontrado com ID: " + id
            );
        }
        return user.get();
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        return;
    }

    public UserModel updateUser(Long id, UserModel user) {
        Optional<UserModel> userFound = userRepository.findById(id);
        if (!userFound.isPresent()) {
            throw new EntityNotFoundException(
                "Usuário não encontrado com ID: " + id
            );
        }
        userFound.get().setName(user.getName());
        userFound.get().setEmail(user.getEmail());
        return userRepository.save(userFound.get());
    }
}
