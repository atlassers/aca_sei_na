package it.euris.academy.cinema.service;

import it.euris.academy.cinema.data.dto.RoomDto;
import java.util.List;

public interface RoomService {

  List<RoomDto> getAll();

  RoomDto get(Long id);

  RoomDto add(RoomDto roomDto);

  RoomDto update(RoomDto roomDto);

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
