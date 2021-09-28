package it.euris.academy.cinema.service;

import it.euris.academy.cinema.data.dto.ClientDto;
import java.text.ParseException;
import java.util.List;

public interface ClientService {
  List<ClientDto> getAll();

  ClientDto get(Long id);

  ClientDto add(ClientDto clientDto) throws ParseException;

  ClientDto update(ClientDto clientDto) throws ParseException;

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
