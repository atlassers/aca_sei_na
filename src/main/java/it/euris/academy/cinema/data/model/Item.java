package it.euris.academy.cinema.data.model;

import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.ItemDto;
import it.euris.academy.cinema.data.enums.ItemType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "items")
@Entity
@FilterDef(name = "deletedItemFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
public class Item implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "item")
  private ItemType itemType;

  @Column(name = "date_of_sale")
  private Date dateOfSale;

  @ManyToMany(mappedBy = "boughtItems")
  Set<Client> clients;

  @Override
  public ItemDto toDto() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd | HH:mm");
    return ItemDto.builder()
        .idDto(String.valueOf(id))
        .itemTypeDto(String.valueOf(itemType))
        .dateOfSaleDto(dateFormat.format(dateOfSale))
        .build();
  }
}
