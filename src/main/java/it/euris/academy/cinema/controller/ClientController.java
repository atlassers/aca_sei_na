package it.euris.academy.cinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.cinema.data.dto.ClientDto;
import it.euris.academy.cinema.service.ClientService;
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

@Api(value = "ClientsController")
@RestController
@RequestMapping("/clients")
public class ClientController {
  
  @Autowired
  ClientService clientService;

  @GetMapping("/v1")
  public List<ClientDto> getAll() {
    return clientService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ClientDto get(@PathVariable("id") Long id) {
    return clientService.get(id);
  }

  @PostMapping("/v1")
  public ClientDto add(@RequestBody ClientDto clientDto) throws ParseException {
    return clientService.add(clientDto);
  }

  @PutMapping("/v1")
  public ClientDto update(@RequestBody ClientDto clientDto) throws ParseException {
    return clientService.update(clientDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return clientService.delete(id);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
