package it.euris.academy.cinema.filler;

import it.euris.academy.cinema.data.enums.RoomDenom;
import it.euris.academy.cinema.data.model.Room;
import it.euris.academy.cinema.repository.RoomRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomFiller {

  @Autowired
  private RoomRepository roomRepository;

  @Test
  void fillRooms(){
    Optional<Room> roomExists = roomRepository.findById(1L);

    if(roomExists.isPresent())
      return;

    for(int i = 0; i < 10; i++){
      Room room = new Room();
      room.setRoomDenom(RoomDenom.values()[i]);
      room.setNumberOfSeats(240);
      room.setHasA3DProjector(Boolean.FALSE);

      roomRepository.save(room);
    }
  }
}
