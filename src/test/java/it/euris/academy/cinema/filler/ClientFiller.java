package it.euris.academy.cinema.filler;

import it.euris.academy.cinema.data.model.Client;
import it.euris.academy.cinema.repository.ClientRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientFiller {

  @Autowired
  ClientRepository clientRepository;

  @Test
  void fillClients() throws ParseException {
    Optional<Client> clientExists = clientRepository.findById(1L);

    if(clientExists.isPresent())
      return;

    for(int i = 0; i < 100; i++) {
      int minY = 1960;
      int maxY = 2005;
      int minM = 1;
      int maxM = 9;
      int randomNumY = ThreadLocalRandom.current().nextInt(minY, maxY + 1);
      int randomNumM = ThreadLocalRandom.current().nextInt(minM, maxM + 1);
      String clientBirthDateDto = String.valueOf(randomNumY) +"-0"+ String.valueOf(randomNumM) +"-14";

      Client client = new Client();
      client.setClientName("clientName"+i);
      client.setClientSurname("clientSurname"+i);
      client.setSubscribed(Boolean.FALSE);
      client.setClientBirthDate(new SimpleDateFormat("yyyy-mm-dd").parse(clientBirthDateDto));

      clientRepository.save(client);
    }
  }
}
