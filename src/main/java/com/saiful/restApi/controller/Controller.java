package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.PostDTO;
import com.saiful.restApi.entity.Post;
import com.saiful.restApi.repository.PostRepo;
import com.saiful.restApi.service.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class Controller {
    @Autowired
    Service service;

//    @PostMapping("/posts")
//    public void saveV1(@RequestBody Post post){
//        service.save(post);
//    }

    @PostMapping("/posts")
    public void saveV2(@RequestBody PostDTO postDTO){
        if (postDTO != null){
            Post post = new Post();
            BeanUtils.copyProperties(postDTO, post);
            service.save(post);
        }
    }

//    @PutMapping("/posts")
//    public void updateV1( @RequestBody Post post){
//        service.save(post);
//    }

    @PutMapping("/posts")
    public void updateV2( @RequestBody PostDTO postDTO){
        if (postDTO != null){
            Post post = new Post();
            BeanUtils.copyProperties(postDTO, post);
            service.save(post);
        }
    }


//    @GetMapping("/posts")
//    List<Post> allV1() {
//        List<Post> posts = service.findAll();
//        return posts;
//    }
@Autowired
PostRepo postRepo;
    @GetMapping("/posts")
    List<PostDTO> allV2(@RequestParam(value = "date", required = false) String date) {
//        List<Post> posts = service.findAll();
//        List<Post> posts = postRepo.findAllByActive();
        List<Post> posts;
        if (date!=null){
            posts = postRepo.findAllByCreatedAt(date);
        }else {
            posts = postRepo.findAllByBody("ABCD ----");
        }
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post:posts
        ) {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }




//    @GetMapping("/posts/{id}")
//    public Post getByIdV1(@PathVariable("id") Long id){
//        Post post;
//        post = service.getById(id);
//        return post;
//    }


//    @GetMapping("/postsDto/{id}")
//    public PostDTO getByIdV2(@PathVariable("id") Long id){
//        Post post;
//        post = service.getById(id);
//        if (post.getId() != null){
//            PostDTO postDTO = new PostDTO();
//            BeanUtils.copyProperties(post, postDTO);
//            return postDTO;
//        }
//        return null;
//    }


    @GetMapping("/posts/{id}")
    public ResponseEntity getByIdV3(@PathVariable("id") Long id){
        Post post;
        post = service.getById(id);
        if (post.getId() != null){
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            return ResponseEntity.status(HttpStatus.OK).body(postDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
