package de.c0lect0r.highnoon;

import java.awt.Image;

public class StartGame {

	public static void main(String[] args) {
		Image leftCowboySprite = ImageHelper.getImage("sprites/cowboy-right-small.gif");
		Image rightCowboySprite = ImageHelper.getImage("sprites/cowboy-left-small.gif");
		Player player1 = new Player(30, 150, leftCowboySprite, 40, 39, 10);
		Player player2 = new Player(550, 150, rightCowboySprite, 40, 39, 10);
		new GameFrame(player1,player2);
	}
}
