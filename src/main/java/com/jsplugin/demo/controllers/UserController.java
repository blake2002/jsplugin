package com.jsplugin.demo.controllers;

import com.jsplugin.demo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @RequestMapping(value = "/usernames/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Result getUserNames(@PathVariable("name") String name)
    {
        return new Result("1",name);
    }
}
