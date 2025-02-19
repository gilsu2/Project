package com.dw.driverapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/driverapp/index.html")
    public String index(){return "forward:/index.html";}

    @GetMapping("/driverapp/oneNormal.html")
    public String oneNormal(){return "forward:/oneNormal.html";}

    @GetMapping("/driverapp/oneBig.html")
    public String oneBig(){return "forward:/oneBig.html";}

    @GetMapping("/driverapp/twoNormal.html")
    public String twoNormal(){return "forward:/twoNormal.html";}

    @GetMapping("/driverapp/twoSmall.html")
    public String twoSmall(){return "forward:/twoSmall.html";}

    @GetMapping("/driverapp/login.html")
    public String login(){return "forward:/login.html";}

    @GetMapping("/driverapp/QNA.html")
    public String QNA(){return "forward:/QNA.html";}
}

