package ru.rushydro.vniig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nikolay on 06.09.15.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {
    
    @RequestMapping(path = "/")
    public String indexPage() {
        return "index";
    }
}
