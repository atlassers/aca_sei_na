package it.euris.academy.cinema.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.RoomDto;
import it.euris.academy.cinema.data.enums.RoomDenom;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
@FilterDef(name = "closedRoomFilter", parameters = @ParamDef(name = "isClosed", type = "boolean"))
public class Room implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "room_name")
  private RoomDenom roomDenom;

  @Column(name = "seats")
  private Integer numberOfSeats;

  @Column(name = "available_3D_projector")
  private Boolean hasA3DProjector;

  @Column(name = "is_closed")
  @JsonIgnore
  private Boolean isClosed;

  @OneToMany(mappedBy = "rooms")
  Set<ProjectionPlanner> dateTimes;

  public Room(String roomId) {
    if(roomId != null) {
      this.id = Long.parseLong(roomId);
    }
  }

  @Override
  public RoomDto toDto() {
    return RoomDto.builder()
        .idDto(String.valueOf(id))
        .roomDenomDto(String.valueOf(roomDenom))
        .numberOfSeatsDto(String.valueOf(numberOfSeats))
        .hasA3DProjectorDto(String.valueOf(hasA3DProjector))
        .build();
  }
}
