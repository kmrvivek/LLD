package com.company.Ludo.configuration;

import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;

@Data
public class Board {

  private List<Player> players;
  private List<Place> places;

  public Board(String[] names){
    this.places = new ArrayList<>(100);
    this.players = new ArrayList<>(names.length);
    setBoardConfiguration(names);
  }

  private void setBoardConfiguration(String[] names){
    new BoardUtil(this, Arrays.asList(names));
  }

}
