package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventcategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping("")
    public String displayAllEventCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll()); // will take all evt catgrs and put in templ to be displayed
        return "eventcategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Categories");
        model.addAttribute("category", new EventCategory());
        return "eventcategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute("category") @Valid EventCategory newCategory,
                                                 Errors errors, Model model){
        if (errors.hasErrors()) {
            //model.addAttribute("title", "Create Categories");
            model.addAttribute("category", newCategory);
            return "eventcategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:";
    }

}




