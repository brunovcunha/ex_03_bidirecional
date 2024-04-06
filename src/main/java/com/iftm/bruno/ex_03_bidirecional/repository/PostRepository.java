package com.iftm.bruno.ex_03_bidirecional.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iftm.bruno.ex_03_bidirecional.entities.Post;
import com.iftm.bruno.ex_03_bidirecional.entities.PostComments;

public interface PostRepository extends CrudRepository<Post, Long>{
    Optional<PostComments> findCommentById(Long id);
    
    @Query("SELECT c FROM Post p JOIN p.comments c WHERE p.id = :postId")
    List<PostComments> findAllCommentsByPostId(Long postId);
}
