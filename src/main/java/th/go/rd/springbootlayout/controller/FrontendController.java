package th.go.rd.springbootlayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping(value="/")
    public String index(){
        return "frontend/index";
    }

    @GetMapping(value="/about")
    public String about(){
        return "frontend/about";
    }

    @GetMapping(value="/service")
    public String service(){
        return "frontend/service";
    }

    @GetMapping(value="/contact")
    public String contact(){
        return "frontend/contact";
    }

    @GetMapping(value="/register")
    public String register(){
        return "frontend/register";
    }

    @GetMapping(value="/login")
    public String login(){
        return "frontend/login";
    }
}