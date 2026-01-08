package org.MY_APP.main.repository;

import org.MY_APP.main.model.FavoriteDirector;
import org.MY_APP.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteDirectorRepository extends JpaRepository<FavoriteDirector, Long> {

    // ⛔ ΜΗΝ ΤΟ ΠΕΙΡΑΞΕΙΣ
    boolean existsByUserAndDirectorId(User user, int directorId);

    // ⛔ ΜΗΝ ΤΟ ΠΕΙΡΑΞΕΙΣ
    Optional<FavoriteDirector> findByUserAndDirectorId(User user, int directorId);

    // ✅ ΑΥΤΟ ΠΡΟΣΘΕΤΟΥΜΕ για το profile
    List<FavoriteDirector> findByUser(User user);
}
