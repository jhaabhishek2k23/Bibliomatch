package com.backend.bibliomatch.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.bibliomatch.entities.Book;
import com.backend.bibliomatch.entities.Favourite;
import com.backend.bibliomatch.entities.User;
import com.backend.bibliomatch.repositories.BookRepository;
import com.backend.bibliomatch.repositories.FavouriteRepository;
import com.backend.bibliomatch.repositories.UserRepository;

import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Favourite addFavourite(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        if (user != null && book != null) {
            Favourite favourite = new Favourite();
            favourite.setUser(user);
            favourite.setBook(book);
            return favouriteRepository.save(favourite);
        }
        return null;
    }

    @Override
    public void removeFavourite(Long favouriteId) {
        favouriteRepository.deleteById(favouriteId);
    }

    @Override
    public List<Favourite> getFavouritesByUserId(Long userId) {
        return favouriteRepository.findByUserId(userId);
    }
}