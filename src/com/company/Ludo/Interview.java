package com.company.Ludo;

import com.company.Ludo.configuration.Board;
import com.company.Ludo.model.Node;
import com.company.Ludo.model.Place;
import com.company.Ludo.model.Player;
import com.company.Ludo.service.BoardService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Interview {
  //design a game with 5 snakes and 5 ladders
  // Create a board, board has all place
  // place has a relationship with snake
  // place has a relationship with ladder
  // snake has functionality to move from head to toe -> start to last
  // ladder has functionality to move from bottom to up
  // game ends if one player reach 100 or top of board
  // Player class
  static BoardService boardService = new BoardService();

  public static void main(String[] args) {
      String[] names = {"Vivek", "Raju", "Rashmendra", "Kunal"};
      Board board = new Board(names);
      List<Player> players = board.getPlayers();
      Node head = getHead(players);
      playGame(board, head);

  }

  private static Node getHead(List<Player> players) {
    Node node = new Node(players.get(0));
    Node dummy = new Node(new Player("Dummy"));
    dummy.next = node;
    node.prev = dummy;
    Node head = node;
    for (int i = 1; i < players.size(); i++) {
      Node currNode = new Node(players.get(i));
      currNode.prev = node;
      node.next = currNode;
      node = node.next;
    }
    head.prev = node;
    node.next = head;
    return head;
  }

  private static void playGame(Board board, Node head) {
    List<Player> winners = new ArrayList<>();
    while (head.next != null && board.getPlayers().size() > 1) {
      Random random = new Random();
      int number = random.nextInt(6) + 1;
      int pos = head.player.getPos() + number;
      if (pos == 100) {
       head = removeWinnerPlayer(board, head, winners);
      } else if (pos < 100) {
        head.player.setPos(pos);
        System.out.println("Player " + head.player.getName() + " played got " + number + " "
            + "current pos : " + (pos - number) + " ,Now go to position " + pos);
        Place place = board.getPlaces().get(pos - 1);
        if(Objects.nonNull(place.getBlocker())){
          boardService.setBlockerPosition(head.player, place);
        }
        head = head.next;
      }
    }
    System.out.println("*******");
    System.out.println(winners);
  }

  private static Node removeWinnerPlayer(Board board, Node head, List<Player> winners) {
    head.player.setWinner(true);
    System.out.println("Hurray!! Player " + head.player.getName() + " has reached 100."
        + " Congratulations Winner !!");
    board.getPlayers().remove(head.player);
    winners.add(head.player);
    Node prev = head.prev;
    Node curr = head.next;
    head.prev = null;
    head.next = null;
    prev.next = curr;
    curr.prev = prev;
    head = curr;
    return head;
  }

}
