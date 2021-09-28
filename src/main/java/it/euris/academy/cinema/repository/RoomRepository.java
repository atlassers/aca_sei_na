package it.euris.academy.cinema.repository;

import it.euris.academy.cinema.data.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
