package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.enums.RoomDenom;
import it.euris.academy.cinema.data.model.Room;
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
public class RoomDto implements Dto {

  private String idDto;
  private String roomDenomDto;
  private String numberOfSeatsDto;
  private String hasA3DProjectorDto;

  @Override
  public Room toModel() {
    return Room.builder()
        .id(idDto == null ? null : Long.valueOf(idDto))
        .roomDenom(RoomDenom.valueOf(roomDenomDto))
        .numberOfSeats(Integer.valueOf(numberOfSeatsDto))
        .hasA3DProjector(Boolean.valueOf(hasA3DProjectorDto))
        .isClosed(Boolean.FALSE)
        .build();
  }
}
