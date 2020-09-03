package th.go.rd.springbootlayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackendController {

    //Dashboard
    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "backend/dashboard";
    }

    @GetMapping(value = "/student")
    public String student(){
        return "backend/student";
    }

    @GetMapping(value = "/addstudent")
    public String addstudent(){
        return "backend/NewStudent";
    }

}