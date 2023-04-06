package com.xfactor.openlibrary.controllers;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@RestController("helloController")
public class Hello { 

    @GetMapping("/hello")
    public String hello(@RequestParam String name,@RequestParam int number,@RequestParam char m) {
        return "Hello" + name + "!!" + number + "!!" + m;
    }
    @GetMapping("/hi/{name}/{collegename}/{n}/{collegemarks}")
    public String sayhi(@PathVariable String name,@PathVariable String collegename,@PathVariable char n,@PathVariable int collegemarks) {
        return "Hi" + name + "!!" + collegename + n + collegemarks;
        
    }
    @GetMapping("/mixed/{name}/{collegename}/{n}/{collegemarks}")
    public String mixed(@PathVariable String name,@PathVariable String collegename,@PathVariable char n,@PathVariable int collegemarks,@RequestParam String title) {
        return "Hi" + name + "!!" + collegename + n +  collegemarks + title;
    }
    @GetMapping("/hii/{name}/{age}")
    public HashMap<String,String> sayhii(@PathVariable String name,@PathVariable int age) {
        HashMap<String,String> vv = new HashMap<>();
        vv.put("name",name);
        vv.put("age",String.valueOf(age));
        return vv;
    }

}
