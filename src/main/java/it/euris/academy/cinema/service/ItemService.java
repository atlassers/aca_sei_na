package it.euris.academy.cinema.service;

import it.euris.academy.cinema.data.dto.ItemDto;
import java.text.ParseException;
import java.util.List;

public interface ItemService {

  List<ItemDto> getAll();

  ItemDto get(Long id);

  ItemDto add(ItemDto itemDto) throws ParseException;

  ItemDto update(ItemDto itemDto) throws ParseException;

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
