package it.euris.academy.cinema.repository;

import it.euris.academy.cinema.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
