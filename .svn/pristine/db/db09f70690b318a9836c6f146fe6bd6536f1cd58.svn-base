package gefp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home.html")
    public String index(ModelMap model)
    {
    	model.put("username", "krishna");
        return "home";
    }

}