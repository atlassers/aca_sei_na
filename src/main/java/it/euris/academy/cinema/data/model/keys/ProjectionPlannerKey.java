package it.euris.academy.cinema.data.model.keys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ProjectionPlannerKey implements Serializable {

  @Column(name = "movie_id")
  private Long movieId;

  @Column(name = "room_id")
  private Long roomId;

  @Column(name = "date_time_of_projection")
  private Date dateTime;
}
