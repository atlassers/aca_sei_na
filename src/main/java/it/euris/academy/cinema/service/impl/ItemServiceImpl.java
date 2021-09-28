package it.euris.academy.cinema.service.impl;

import it.euris.academy.cinema.data.dto.ItemDto;
import it.euris.academy.cinema.data.model.Item;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.ItemRepository;
import it.euris.academy.cinema.service.ItemService;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  ItemRepository itemRepository;

  @Override
  public List<ItemDto> getAll() {
    return itemRepository.findAll()
        .stream().map(item -> item.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ItemDto get(Long id) {
    Optional<Item> findById = itemRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public ItemDto add(ItemDto itemDto) throws ParseException {
    if(itemDto.getIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return itemRepository.save(itemDto.toModel()).toDto();
  }

  @Override
  public ItemDto update(ItemDto itemDto) throws ParseException {
    if(itemDto.getIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return itemRepository.save(itemDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    itemRepository.deleteById(id);
    Optional<Item> deletedItem = itemRepository.findById(id);
    if(deletedItem.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
