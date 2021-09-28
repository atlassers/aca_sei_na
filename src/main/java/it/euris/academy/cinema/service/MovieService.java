package it.euris.academy.cinema.service;

import it.euris.academy.cinema.data.dto.MovieDto;
import java.util.List;

public interface MovieService {

  List<MovieDto> getAll();

  MovieDto get(Long id);

  MovieDto add(MovieDto movieDto);

  MovieDto update(MovieDto movieDto);

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////

  List<MovieDto> getAllSD();

  Boolean deleteSD(Long id);
}
