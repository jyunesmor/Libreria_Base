package Egg.Libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class PortalControlador {

    @Controller
    @RequestMapping("/")
    public class EditorialControlador {

        @GetMapping("/principal")
        public String index() {
            return "form_index.html";
        }

    }
}
