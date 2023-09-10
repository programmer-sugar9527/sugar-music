package music.kamilaself.top.sugar_music.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api"))
public class BaseController {

    @RequestMapping("/test")
    public String hello() {
        return  "hello";
    }

}
