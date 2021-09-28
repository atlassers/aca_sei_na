package it.euris.academy.cinema.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.ClientDto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "clients")
@Entity
@FilterDef(name = "deletedClientFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
public class Client implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String clientName;

  @Column(name = "surname")
  private String clientSurname;

  @Column(name = "birth_date")
  private Date clientBirthDate;

  @Column(name = "is_subscribed")
  private Boolean subscribed;

  @Column(name = "soft_delete_flag")
  @JsonIgnore
  private Boolean softDeleted = Boolean.FALSE;

  @ManyToMany
  @JoinTable(
      name ="items_bought",
      joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id"))
  Set<Item> boughtItems;

  @ManyToMany
  @JoinTable(
      name = "projection_clients",
      joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "movie_id"),
          @JoinColumn(name = "room_id", referencedColumnName = "room_id"),
          @JoinColumn(name="date_time", referencedColumnName = "date_time_of_projection")})
  Set<ProjectionPlanner> projections;

  @Override
  public ClientDto toDto() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    return ClientDto.builder()
        .idDto(String.valueOf(id))
        .clientNameDto(clientName)
        .clientSurnameDto(clientSurname)
        .clientBirthDateDto(dateFormat.format(clientBirthDate))
        .subscribedDto(String.valueOf(subscribed))
        .build();
  }
}
