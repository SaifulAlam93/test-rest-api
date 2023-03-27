package com.saiful.restApi.service;


import com.saiful.restApi.entity.Post;
import com.saiful.restApi.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    PostRepo postRepo;


    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public void save(Post postNew) {
        if (postNew.getId()!= null){
            postRepo.findById(postNew.getId())
                    .map(old -> {
                        old.setTitle(postNew.getTitle());
                        old.setBody(postNew.getBody());
                        return postRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return postRepo.save(postNew);
                    });
        }else {
            postRepo.save(postNew);
        }
    }

    public Post getById(Long id) {
       return postRepo.findById(id).orElse(new Post());
    }

    public void delete(Long id) {
         postRepo.deleteById(id);
    }

}
