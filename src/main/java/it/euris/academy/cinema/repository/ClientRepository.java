package it.euris.academy.cinema.repository;

import it.euris.academy.cinema.data.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client,Long> {
  @Transactional
  @Modifying
  @Query(value =
          "INSERT INTO projection_clients (client_id, date_time, movie_id, room_id)\n"
            + "VALUES ('6', '2020-10-10 14:45:00.000000', '1', '1')",
              nativeQuery = true)
  void insertClientIntoProjection();

  @Query(value =
          "SELECT c.birth_date AS birth_date, "
              + " c.name AS name, c.surname AS surname, "
                + "TIMESTAMPDIFF(YEAR, c.birth_date, CURDATE()) AS age FROM clients c\n"
                  + "HAVING age < 30", nativeQuery = true)
  void listClientsYoungerThan30();
}
