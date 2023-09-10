package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class BaseController {

    @RequestMapping("/test")
    public String hello() {
        return  "hello";
    }

}
