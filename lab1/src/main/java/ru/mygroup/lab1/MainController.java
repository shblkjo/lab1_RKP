package ru.mygroup.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
//    @GetMapping("/")
//    public String home(){
//        return "main";
//    }
    @GetMapping("main")
    public String home(Model model){
        model.addAttribute("title", "Главная страница");
        model.addAttribute("data", "Лабораторная работа N1");
        model.addAttribute("content",
                "Знакомство с Spring Framework");
        return "main";
    }
    @GetMapping("/about")
    public String about(@RequestParam(name="name", required = false,
            defaultValue = "Афанасьева Д.В.") String name, Model model) {
        model.addAttribute("title", "Страница автора");
        model.addAttribute("author", name);
        return "about";
    }

    @GetMapping("/form")
    public String mainForm(Model model){
        model.addAttribute("student", new Student());
        return "main-form";
    }

    @PostMapping("/form")
    public String mainForm(@ModelAttribute Student student, Model model){
        String year = String.valueOf(student.getAdmissionYear());
        String lastTwoDigits = year.substring(year.length() - 2);

        student.setGroup("ПИНз-1" + lastTwoDigits);
        student.setLogin("student-pinz1" + lastTwoDigits + "-" + student.getId());

        model.addAttribute("student", student);

        return "result";
    }
}
