package th.go.rd.springbootlayout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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
    public String student(final ModelMap model) {
        final List<Student> listStd = stdService.findAll();
        model.addAttribute("listStd", listStd);
        return "backend/student";
    }

    @GetMapping(value = "/newstudent")
    public String newStudent(final ModelMap model) {
        final Student student = new Student();
        model.addAttribute("student", student);
        return "backend/NewStudent";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@Validated final Student student, final BindingResult result,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "/newstudent";
        } else {
            stdService.save(student);
            return "redirect:/student";
        }
    }

    @GetMapping(value = "/editstudent/id/{id}")
    public String editStudent(@PathVariable final int id, final ModelMap model) {
        final Student student = stdService.getOne(id);
        model.addAttribute("student", student);
        return "backend/editstudent";
    }

    @PostMapping(value = "/editsave")
    public ModelAndView editsave(@Validated @ModelAttribute("editedStudent") final Student p,
            final BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("has errors");
            return new ModelAndView("redirect:/student");
        } else {
            final Student std = stdService.getOne(p.getId());

            std.setFirstname(p.getFirstname());
            std.setLastname(p.getLastname());
            std.setEmail(p.getEmail());

            stdService.save(std);
            return new ModelAndView("redirect:/student");
        }

    }

    @GetMapping(value = "/deletestudent/{id}")
    public ModelAndView deleteStudent(@PathVariable final int id, final ModelMap model) {
        final Student student = stdService.getOne(id);
        stdService.delete(student);
        return new ModelAndView("redirect:/student");
    }

}