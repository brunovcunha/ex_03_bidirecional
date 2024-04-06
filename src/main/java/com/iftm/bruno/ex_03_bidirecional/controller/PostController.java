package com.iftm.bruno.ex_03_bidirecional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iftm.bruno.ex_03_bidirecional.entities.Post;
import com.iftm.bruno.ex_03_bidirecional.entities.PostComments;
import com.iftm.bruno.ex_03_bidirecional.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<PostComments>> getComments(@PathVariable Long postId) {
        List<PostComments> comments = postService.getComments(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Post> addCommentToPost(@PathVariable Long postId, @RequestBody PostComments comment) {
        Post updatedPost = postService.addComments(postId, comment);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Post> removeCommentFromPost(@PathVariable Long commentId) {
        Post updatedPost = postService.removeComments(commentId);
        return ResponseEntity.ok(updatedPost);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }
}
