package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.enums.MovieGenre;
import it.euris.academy.cinema.data.enums.RatingType;
import it.euris.academy.cinema.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto implements Dto {

  private String idDto;
  private String titleDto;
  private String descriptionDto;
  private String runningTimeDto;
  private String genreDto;
  private String ratingTypeDto;
  private String is3DDto;

  @Override
  public Movie toModel() {
    return Movie.builder()
        .id(idDto == null ? null : Long.valueOf(idDto))
        .title(titleDto)
        .description(descriptionDto)
        .runningTime(Integer.valueOf(runningTimeDto))
        .genre(MovieGenre.valueOf(genreDto))
        .ratingType(RatingType.valueOf(ratingTypeDto))
        .is3D(Boolean.valueOf(is3DDto))
        .softDeleted(Boolean.FALSE)
        .build();
  }
}
