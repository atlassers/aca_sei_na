package it.euris.academy.cinema.repository;

import it.euris.academy.cinema.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
  @Transactional
  @Modifying
  @Query(value =
          "UPDATE movies\n"
            + "SET soft_delete_flag = TRUE\n"
              + "WHERE id = :id",
                nativeQuery = true)
  void setDeletedFlagToTrue(@Param("id") Long id);
}
