package com.backend.bibliomatch.services;

import java.util.List;

import com.backend.bibliomatch.entities.Favourite;


public interface FavouriteService{
    Favourite addFavourite(Long userId, Long bookId);
    void removeFavourite(Long favouriteId);
    List<Favourite> getFavouritesByUserId(Long userId);
}