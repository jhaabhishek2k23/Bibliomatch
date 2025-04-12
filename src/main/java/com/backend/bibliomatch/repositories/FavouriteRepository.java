package com.backend.bibliomatch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bibliomatch.entities.Favourite;



public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
     List<Favourite> findByUserId(Long userId);
}