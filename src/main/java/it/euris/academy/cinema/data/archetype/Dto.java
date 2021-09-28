package it.euris.academy.cinema.data.archetype;

import java.text.ParseException;

public interface Dto {
  Model toModel() throws ParseException;
}
