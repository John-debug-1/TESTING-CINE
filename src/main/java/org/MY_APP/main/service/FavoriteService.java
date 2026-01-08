package org.MY_APP.main.service;

import org.MY_APP.main.model.*;
import org.MY_APP.main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private FavoriteTvRepository favoriteTvRepository;
    @Autowired
    private FavoriteActorRepository favoriteActorRepository;
    @Autowired
    private FavoriteDirectorRepository favoriteDirectorRepository;
    @Autowired
    private UserRepository userRepository;

    public void addFavorite(User user, int movieId, String title, String posterPath) {
        if (favoriteRepository.existsByUserAndMovieId(user, movieId)) return;
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setMovieId(movieId);
        favorite.setTitle(title);
        favorite.setPosterPath(posterPath);
        favoriteRepository.save(favorite);
    }

    public void removeFavorite(User user, int movieId) {
        favoriteRepository.findByUserAndMovieId(user, movieId).ifPresent(favoriteRepository::delete);
    }

    public List<Favorite> getUserFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }

    public void addFavoriteActor(User user, int actorId, String name, String profilePath) {
        if (favoriteActorRepository.existsByUserAndActorId(user, actorId)) return;
        FavoriteActor actor = new FavoriteActor();
        actor.setUser(user);
        actor.setActorId(actorId);
        actor.setName(name);
        actor.setProfilePath(profilePath);
        favoriteActorRepository.save(actor);
    }

    public void removeFavoriteActor(User user, int actorId) {
        favoriteActorRepository.findByUserAndActorId(user, actorId).ifPresent(favoriteActorRepository::delete);
    }
}