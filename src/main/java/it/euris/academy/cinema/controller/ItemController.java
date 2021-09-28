package it.euris.academy.cinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.cinema.data.dto.ItemDto;
import it.euris.academy.cinema.service.ItemService;
import java.text.ParseException;
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

@Api(value = "ItemsController")
@RestController
@RequestMapping("/items")
public class ItemController {
  
  @Autowired
  ItemService itemService;

  @GetMapping("/v1")
  public List<ItemDto> getAll() {
    return itemService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ItemDto get(@PathVariable("id") Long id) {
    return itemService.get(id);
  }

  @PostMapping("/v1")
  public ItemDto add(@RequestBody ItemDto itemDto) throws ParseException {
    return itemService.add(itemDto);
  }

  @PutMapping("/v1")
  public ItemDto update(@RequestBody ItemDto itemDto) throws ParseException {
    return itemService.update(itemDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return itemService.delete(id);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
