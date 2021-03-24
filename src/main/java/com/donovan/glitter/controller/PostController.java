package com.donovan.glitter.controller;

import com.donovan.glitter.dao.PostDao;
import com.donovan.glitter.domain.Post;
import com.donovan.glitter.generated.tables.records.PostRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostDao postDao;

    @GetMapping
    List<Post> getPosts(){
        return postDao.getPosts();
    }

    @PostMapping
    Post createPost(@RequestBody Post p){
        return postDao.createPost(p);
    }


}
