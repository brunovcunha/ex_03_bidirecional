package com.iftm.bruno.ex_03_bidirecional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iftm.bruno.ex_03_bidirecional.entities.Post;
import com.iftm.bruno.ex_03_bidirecional.entities.PostComments;
import com.iftm.bruno.ex_03_bidirecional.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<PostComments> getComments(Long postId) {
        return repository.findAllCommentsByPostId(postId);
    }

    public Post addComments(Long postId, PostComments comment) {
        Post post = repository.findById(postId).orElse(null);

        if (post == null) {
            throw new RuntimeException("Post não encontrado com o ID: " + postId);
        }

        post.getComments().add(comment);
        comment.setPost(post);

        return repository.save(post);
    }

    public Post removeComments(Long commentId) {
        PostComments comment = repository.findCommentById(commentId).orElse(null);

        if (comment == null) {
            throw new RuntimeException("Comentário não encontrado com o ID: " + commentId);
        }

        Post post = comment.getPost();
        post.getComments().remove(comment);

        return repository.save(post);
    }

    public Post createPost(Post post) {
        return repository.save(post);
    }
}

