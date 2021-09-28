package it.euris.academy.cinema.filler;

import it.euris.academy.cinema.data.enums.ItemType;
import it.euris.academy.cinema.data.model.Item;
import it.euris.academy.cinema.repository.ItemRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemFiller {

  @Autowired
  ItemRepository itemRepository;

  @Test
  void fillItems() throws ParseException {
    Optional<Item> itemExists = itemRepository.findById(1L);

    if(itemExists.isPresent())
      return;

    for(int i = 0; i < 600; i++) {
      int minI = 0;
      int maxI = 5;
      int minY = 2018;
      int maxY = 2020;
      int minM = 1;
      int maxM = 9;
      int minD = 10;
      int maxD = 26;
      int minH = 12;
      int maxH = 24;
      int minMM = 10;
      int maxMM = 60;
      int randomNumI = ThreadLocalRandom.current().nextInt(minI, maxI + 1);
      int randomNumY = ThreadLocalRandom.current().nextInt(minY, maxY + 1);
      int randomNumM = ThreadLocalRandom.current().nextInt(minM, maxM + 1);
      int randomNumD = ThreadLocalRandom.current().nextInt(minD, maxD + 1);
      int randomNumH = ThreadLocalRandom.current().nextInt(minH, maxH + 1);
      int randomNumMM = ThreadLocalRandom.current().nextInt(minMM, maxMM + 1);
      String saleDate = String.valueOf(randomNumY) +"-0"+ String.valueOf(randomNumM) +"-"+ String.valueOf(randomNumD)
           +" | "+ String.valueOf(randomNumH) +":"+ String.valueOf(randomNumMM);

      Item item = new Item();
      item.setItemType(ItemType.values()[randomNumI]);
      item.setDateOfSale(new SimpleDateFormat("yyyy-MM-dd | HH:mm").parse(saleDate));

      itemRepository.save(item);
    }
  }
}
