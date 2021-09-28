package it.euris.academy.cinema.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.MovieDto;
import it.euris.academy.cinema.data.enums.MovieGenre;
import it.euris.academy.cinema.data.enums.RatingType;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movies")
@Entity
@FilterDef(name = "deletedMovieFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
public class Movie implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "running_time")
  private Integer runningTime;  //running time in minutes

  @Column(name = "genre")
  private MovieGenre genre;

  @Column(name = "rating_type")
  private RatingType ratingType;

  @Column(name = "3D_movie")
  private Boolean is3D;

  @Column(name = "soft_delete_flag")
  @JsonIgnore
  private Boolean softDeleted = Boolean.FALSE;

  @OneToMany(mappedBy = "movies")
  Set<ProjectionPlanner> dateTimes;

  public Movie(String movieId) {
    if(movieId != null) {
      this.id = Long.parseLong(movieId);
    }
  }

  @Override
  public MovieDto toDto() {
    return MovieDto.builder()
        .idDto(String.valueOf(id))
        .titleDto(title)
        .descriptionDto(description)
        .runningTimeDto(String.valueOf(runningTime))
        .genreDto(String.valueOf(genre))
        .ratingTypeDto(String.valueOf(ratingType))
        .is3DDto(String.valueOf(is3D))
        .build();
  }
}
