package com.saiful.restApi.controller;

import com.saiful.restApi.entity.Post;
import com.saiful.restApi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class Controller {
    @Autowired
    Service service;

    @PostMapping("/posts")
    public void save(@RequestBody Post post){
        System.out.println(post);
        service.save(post);
    }

    @PutMapping("/posts")
    public void update(@RequestBody Post post){
        service.save(post);
    }

    @GetMapping("/posts")
    List<Post> all() {
        return service.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/posts/{id}")
    public Post getById(@PathVariable("id") Long id){
       return service.getById(id);
    }
}
