package com.jojo.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/snacks")
public class SnackController {
    private static List<String> snackList = new ArrayList<>();

    static {
        snackList.add("strawberry");
        snackList.add("chocolate");
        snackList.add("jelly");
    }

    @GetMapping
    public String getSnacks(Model model) {
        model.addAttribute("snacks", snackList);
        return "snacks";
    }

    @DeleteMapping("/{snack}")
    public String eatSnack(@PathVariable String snack) {
        snackList.remove(snack);
        return "redirect:";
    }
}
