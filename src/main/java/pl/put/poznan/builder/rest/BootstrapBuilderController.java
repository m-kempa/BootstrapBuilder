package pl.put.poznan.builder.rest;

import pl.put.poznan.builder.logic.BootstrapBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BootstrapBuilderController {

    @GetMapping("/bootstrap")
    public String greetingForm(Model model) {
        model.addAttribute("starting_page", new BootstrapBuilder());
        return "starting_page";
    }

    @PostMapping("/bootstrap")
    public String greetingSubmit(@ModelAttribute BootstrapBuilder bootstrapBuilderInstance) {
        return "generated_page";
    }

}


