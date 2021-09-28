package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.Movie;
import it.euris.academy.cinema.data.model.ProjectionPlanner;
import it.euris.academy.cinema.data.model.Room;
import it.euris.academy.cinema.data.model.keys.ProjectionPlannerKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectionPlannerDto implements Dto {

  private String movieIdDto;
  private String roomIdDto;
  private String dateTimeDto;

  @Override
  public ProjectionPlanner toModel() throws ParseException {
    return ProjectionPlanner.builder()
        .dateTime(new SimpleDateFormat("yyyy-MM-dd | HH:mm").parse(dateTimeDto))
        .movies(new Movie(movieIdDto))
        .rooms(new Room(roomIdDto))
        .id(new ProjectionPlannerKey(Long.parseLong(movieIdDto), Long.parseLong(roomIdDto),
            new SimpleDateFormat("yyyy-MM-dd | HH:mm").parse(dateTimeDto)))
        .build();
  }
}
