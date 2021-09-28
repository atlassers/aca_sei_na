package it.euris.academy.cinema.service.impl;

import it.euris.academy.cinema.data.dto.ClientDto;
import it.euris.academy.cinema.data.model.Client;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNullException;
import it.euris.academy.cinema.repository.ClientRepository;
import it.euris.academy.cinema.service.ClientService;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  ClientRepository clientRepository;

  @Override
  public List<ClientDto> getAll() {
    return clientRepository.findAll()
        .stream().map(client -> client.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ClientDto get(Long id) {
    Optional<Client> findById = clientRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public ClientDto add(ClientDto clientDto) throws ParseException {
    if(clientDto.getIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return clientRepository.save(clientDto.toModel()).toDto();
  }

  @Override
  public ClientDto update(ClientDto clientDto) throws ParseException {
    if(clientDto.getIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return clientRepository.save(clientDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    clientRepository.deleteById(id);
    Optional<Client> deletedClient = clientRepository.findById(id);
    if(deletedClient.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
