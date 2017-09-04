package com.java.minigames.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.minigames.entities.Tennis;

@Repository
public interface TennisRepository extends CrudRepository<Tennis, Long> {

}
