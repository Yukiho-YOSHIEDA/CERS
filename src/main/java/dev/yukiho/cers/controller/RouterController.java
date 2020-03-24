package dev.yukiho.cers.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController implements ErrorController {

    private final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String getIndex() {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
