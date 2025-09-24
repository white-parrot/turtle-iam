package rt.turtleIam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiHealthController {

    @RequestMapping("/private/health")
    public String test(){
        return "up";
    }
}
