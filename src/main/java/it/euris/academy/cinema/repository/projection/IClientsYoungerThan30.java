package it.euris.academy.cinema.repository.projection;

import java.util.Date;

public interface IClientsYoungerThan30 {
  Date getClientBirthDate();
  String getClientName();
  String getClientSurname();
  Integer getClientAge();
}
