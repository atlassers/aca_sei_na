package it.euris.academy.cinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.cinema.data.dto.MovieDto;
import it.euris.academy.cinema.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "MoviesController")
@RestController
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping("/v1")
  public List<MovieDto> getAll() {
    return movieService.getAll();
  }

  @GetMapping("/v1/{id}")
  public MovieDto get(@PathVariable("id") Long id) {
    return movieService.get(id);
  }

  @PostMapping("/v1")
  public MovieDto add(@RequestBody MovieDto movieDto) {
    return movieService.add(movieDto);
  }

  @PutMapping("/v1")
  public MovieDto update(@RequestBody MovieDto movieDto) {
    return movieService.update(movieDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return movieService.delete(id);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @GetMapping("/v1/softDelete")
  public List<MovieDto> getAllSD() {
    return movieService.getAllSD();
  }

  @DeleteMapping("/v1/softDelete/{id}")
  public Boolean deleteSD(@PathVariable("id") Long id) {
    return movieService.deleteSD(id);
  }
}
