package it.euris.academy.cinema.filler;

import it.euris.academy.cinema.data.enums.MovieGenre;
import it.euris.academy.cinema.data.enums.RatingType;
import it.euris.academy.cinema.data.model.Movie;
import it.euris.academy.cinema.repository.MovieRepository;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieFiller {

  @Autowired
  MovieRepository movieRepository;

  @Test
  void fillMovies() {
    Optional<Movie> movieExists = movieRepository.findById(1L);

    if(movieExists.isPresent())
      return;

    for(int i = 0; i < 25; i++) {
      int minL = 80;
      int maxL = 140;
      int minR = 0;
      int maxR = 4;
      int minG = 0;
      int maxG = 6;
      int randomNumL = ThreadLocalRandom.current().nextInt(minL, maxL + 1);
      int randomNumR = ThreadLocalRandom.current().nextInt(minR, maxR + 1);
      int randomNumG = ThreadLocalRandom.current().nextInt(minG, maxG + 1);

      Movie movie = new Movie();
      movie.setTitle("title"+i);
      movie.setDescription("descr"+i);
      movie.setRunningTime(randomNumL);
      movie.setRatingType(RatingType.values()[randomNumR]);
      movie.setGenre(MovieGenre.values()[randomNumG]);
      movie.setIs3D(Boolean.FALSE);

      movieRepository.save(movie);
    }
  }
}
