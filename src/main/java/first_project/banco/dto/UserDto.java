package first_project.banco.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @Size(
        min = 3,
        max = 30,
        message = "Nome precisa ter entre 3 e 30 caracteres"
    )
    public String name;

    @Email(message = "Forneça um email válido")
    @NotBlank(message = "Email tem que ser provido")
    public String email;
}
