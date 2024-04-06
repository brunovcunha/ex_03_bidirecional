package com.iftm.bruno.ex_03_bidirecional.repository;

import org.springframework.data.repository.CrudRepository;

import com.iftm.bruno.ex_03_bidirecional.entities.PostComments;

public interface PostCommentsRepository extends CrudRepository<PostComments, Long>{
    
}
