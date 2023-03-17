package first_project.banco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/health")
    public String index() {
        return "Hello From API";
    }
}
