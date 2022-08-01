package com.company.Ludo.model;


public class Node {
    public Player player;
    public Node next;
    public Node prev;

    public Node(){}

    public Node(Player player) {
      this.player = player;
      next = null;
      prev = null;
    }

}
