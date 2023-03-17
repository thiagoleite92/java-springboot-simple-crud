package first_project.banco.controller.User;

import first_project.banco.dto.UserDto;
import first_project.banco.model.UserModel;
import first_project.banco.service.UserService;
import first_project.banco.util.ExceptionValidationHandler;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService _userService;

    @PostMapping
    public UserModel saveUser(@RequestBody @Valid UserDto userDto) {
        UserModel user = new UserModel();

        user.setName(userDto.name);
        user.setEmail(userDto.email);

        return this._userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return _userService.getUserById(id);
    }

    @GetMapping("/")
    public List<UserModel> getUsers() {
        return _userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        _userService.deleteUserById(id);

        return;
    }

    @PutMapping("/{id}")
    public UserModel updateUser(
        @PathVariable Long id,
        @RequestBody UserDto userDto
    ) {
        UserModel user = new UserModel();

        user.setName(userDto.name);
        user.setEmail(userDto.email);
        return _userService.updateUser(id, user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
        MethodArgumentNotValidException ex
    ) {
        return ExceptionValidationHandler.handleValidationExceptions(ex);
    }
}
