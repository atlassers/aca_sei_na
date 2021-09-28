package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.enums.ItemType;
import it.euris.academy.cinema.data.model.Item;
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
public class ItemDto implements Dto {

  private String idDto;
  private String itemTypeDto;
  private String dateOfSaleDto;

  @Override
  public Item toModel() throws ParseException {
    return Item.builder()
        .id(idDto == null ? null : Long.valueOf(idDto))
        .itemType(ItemType.valueOf(itemTypeDto))
        .dateOfSale(new SimpleDateFormat("yyyy-MM-dd | HH:mm").parse(dateOfSaleDto))
        .build();
  }
}
