package it.euris.academy.cinema.service.impl;

import it.euris.academy.cinema.data.dto.MovieDto;
import it.euris.academy.cinema.data.model.Movie;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.MovieRepository;
import it.euris.academy.cinema.service.MovieService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<MovieDto> getAll() {
    return movieRepository.findAll()
        .stream().map(movie -> movie.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public MovieDto get(Long id) {
    Optional<Movie> findById = movieRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public MovieDto add(MovieDto movieDto) {
    if(movieDto.getIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return movieRepository.save(movieDto.toModel()).toDto();
  }

  @Override
  public MovieDto update(MovieDto movieDto) {
    if(movieDto.getIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return movieRepository.save(movieDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    movieRepository.deleteById(id);
    Optional<Movie> deletedMovie = movieRepository.findById(id);
    if(deletedMovie.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public List<MovieDto> getAllSD() {
    return movieRepository.findAll().stream()
        .filter(movie -> !movie.getSoftDeleted())
        .map(notDeletedMovies -> notDeletedMovies.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public Boolean deleteSD(Long id) {
    movieRepository.setDeletedFlagToTrue(id);
    return Boolean.TRUE;
  }
}
