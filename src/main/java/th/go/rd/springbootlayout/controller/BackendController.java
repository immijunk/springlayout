package th.go.rd.springbootlayout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import th.go.rd.springbootlayout.Service.StudentService;
import th.go.rd.springbootlayout.model.Student;

@Controller
public class BackendController {

    @Autowired
    private StudentService stdService;

    // Dashboard
    @GetMapping(value = "/dashboard")
    public String dashboard() {
        return "backend/dashboard";
    }

    @GetMapping(value = "/student")
    public String student() {
        return "backend/student";
    }

    @GetMapping(value = "/newstudent")
    public String newStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "backend/NewStudent";
    }

    @PostMapping("/savestudent")
    public String saveStudent(
        @Validated Student student,
        BindingResult result,
        RedirectAttributes redirectAttributes){
            if(result.hasErrors()){
                return "/newstudent";
            }else{
                stdService.save(student);
                return "redirect:/student";
            }
    }

}