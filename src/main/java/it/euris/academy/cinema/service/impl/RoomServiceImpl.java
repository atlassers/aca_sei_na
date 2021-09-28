package it.euris.academy.cinema.service.impl;

import it.euris.academy.cinema.data.dto.RoomDto;
import it.euris.academy.cinema.data.model.Room;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.RoomRepository;
import it.euris.academy.cinema.service.RoomService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  RoomRepository roomRepository;

  @Override
  public List<RoomDto> getAll() {
    return roomRepository.findAll()
        .stream().map(room -> room.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public RoomDto get(Long id) {
    Optional<Room> findById = roomRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public RoomDto add(RoomDto roomDto) {
    if(roomDto.getIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return roomRepository.save(roomDto.toModel()).toDto();
  }

  @Override
  public RoomDto update(RoomDto roomDto) {
    if(roomDto.getIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return roomRepository.save(roomDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    roomRepository.deleteById(id);
    Optional<Room> deletedRoom = roomRepository.findById(id);
    if(deletedRoom.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
