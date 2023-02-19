package com.spring.test.web;

import com.spring.pj1.hkh.dto.HelloDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/dto/hello")
    public HelloDto helloDto(Model model, @RequestParam("name") String name, @RequestParam("amt") int amt) {
        HelloDto tdto = new HelloDto(name, amt);

        model.addAttribute("tdto", tdto);

        return tdto;//"dtohello";
    }
}
