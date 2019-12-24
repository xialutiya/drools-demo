package xialu.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xialu.drools.service.PromoteEdieServcie;

import java.util.Map;

@Controller
@RequestMapping("/promotion")
public class ShopController {

    @Autowired
    private PromoteEdieServcie promoteEdieService;

    @RequestMapping("/greeting")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/shop")
    public String shop() {
        return "shopping";
    }

    @PostMapping("/ediePromote")
    @ResponseBody
    public void addPromote(String money, String rulename) {
       promoteEdieService.ediePromomteMap(money, rulename);
    }

    @PostMapping("/toShopping")
    @ResponseBody
    public Map<String, Object> toShopping(String money) {
        Map<String, Object> data = promoteEdieService.toShopping(money);
        return data;
    }


}
