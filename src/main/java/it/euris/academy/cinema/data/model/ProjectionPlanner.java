package it.euris.academy.cinema.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.ProjectionPlannerDto;
import it.euris.academy.cinema.data.model.keys.ProjectionPlannerKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "projections_planner")
@Entity
public class ProjectionPlanner implements Model {

  @EmbeddedId
  private ProjectionPlannerKey id;

  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id")
  @JsonIgnore
  private Movie movies;

  @ManyToOne
  @MapsId("roomId")
  @JoinColumn(name = "room_id")
  @JsonIgnore
  private Room rooms;

  @MapsId("dateTimeOfProjection")
  @JoinColumn(name = "date_time_of_projection")
  private Date dateTime;

  @ManyToMany(mappedBy = "projections")
  Set<Client> clients;

  @Override
  public ProjectionPlannerDto toDto() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd | HH:mm");
    return ProjectionPlannerDto.builder()
        .movieIdDto(String.valueOf(id.getMovieId()))
        .roomIdDto(String.valueOf(id.getRoomId()))
        .dateTimeDto(dateFormat.format(id.getDateTime()))
        .build();
  }
}
