package it.euris.academy.cinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.cinema.data.dto.RoomDto;
import it.euris.academy.cinema.service.RoomService;
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

@Api(value = "RoomsController")
@RestController
@RequestMapping("/rooms")
public class RoomController {

  @Autowired
  RoomService roomService;

  @GetMapping("/v1")
  public List<RoomDto> getAll() {
    return roomService.getAll();
  }

  @GetMapping("/v1/{id}")
  public RoomDto get(@PathVariable("id") Long id) {
    return roomService.get(id);
  }

  @PostMapping("/v1")
  public RoomDto add(@RequestBody RoomDto roomDto) {
    return roomService.add(roomDto);
  }

  @PutMapping("/v1")
  public RoomDto update(@RequestBody RoomDto roomDto) {
    return roomService.update(roomDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return roomService.delete(id);
  }
}
