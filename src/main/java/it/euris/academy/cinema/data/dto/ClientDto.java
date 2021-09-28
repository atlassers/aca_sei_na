package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.Client;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto implements Dto {

  private String idDto;
  private String clientNameDto;
  private String clientSurnameDto;
  private String clientBirthDateDto;
  private String subscribedDto;

  @Override
  public Client toModel() throws ParseException {
    return Client.builder()
        .id(idDto == null ? null : Long.valueOf(idDto))
        .clientName(clientNameDto)
        .clientSurname(clientSurnameDto)
        .clientBirthDate(new SimpleDateFormat("yyyy-mm-dd").parse(clientBirthDateDto))
        .subscribed(Boolean.valueOf(subscribedDto))
        .build();
  }
}
