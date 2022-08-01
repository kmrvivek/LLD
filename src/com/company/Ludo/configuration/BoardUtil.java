package com.company.Ludo.configuration;

import com.company.Ludo.model.Ladder;
import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;
import com.company.Ludo.model.Snake;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardUtil {
  private final Board board;
  static int[][] snakes = {{17, 7}, {60, 18},{68, 49}, {99, 46}, {87, 24}, {93, 73}};
  static int[][] ladders = {{14, 4}, {38, 20}, {31, 9}, {59, 40}, {84, 29}, {81, 63}, {91, 71}};

  public BoardUtil(Board board, List<String> names){
    this.board = board;
    setPlayers(names);
    setBoardPlaces();
  }

  private void setPlayers(List<String> names){
    List<Player> players = this.board.getPlayers();
    for(String name : names){
      Player player = new Player(name);
      players.add(player);
    }
  }

  public void setBoardPlaces() {
    Map<Integer, Integer> snakesPos = Arrays.stream(snakes).
        collect(Collectors.toMap(snake -> snake[0], snake -> snake[1]));
    Map<Integer, Integer> ladderPos = Arrays.stream(ladders).
        collect(Collectors.toMap(ladder -> ladder[0], ladder -> ladder[1]));
    List<Place> places = this.board.getPlaces();
    for(int i=1; i<=100; i++){
      Place place = new Place(i);
      places.add(place);
      if(snakesPos.containsKey(i)){
        place.setBlocker(new Snake(i, snakesPos.get(i)));
        place.setBlocked(true);
      } else if(ladderPos.containsKey(i)){
        places.get(ladderPos.get(i)-1).setBlocker(new Ladder(i, ladderPos.get(i)));
        places.get(ladderPos.get(i)-1).setBlocked(true);
      }
    }

    for (Place place : places){
      System.out.println(place.getNumber()+"  "+place.getBlocker()+"  "+place.isBlocked());
    }

  }


}
