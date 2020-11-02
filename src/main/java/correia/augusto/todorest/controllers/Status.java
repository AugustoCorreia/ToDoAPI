package correia.augusto.todorest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Status {
    @GetMapping(path = "/on")
    public String status(){
        return "online";
    }
}
