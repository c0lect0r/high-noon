package de.c0lect0r.highnoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

public class Player extends GameObject  implements Health{


	private int health;

	public Player(int xPos, int yPos, Image image, int width, int height, int health) {
		this.setXPosition(xPos);
		this.setYPosition(yPos);
		this.setImage(image);
		this.setWidth(width);
		this.setHeight(height);
		this.setHealth(health);
		this.rectangle = new Rectangle(xPos, yPos, width, height);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(this.getImage(), getXPosition(), getYPosition(), null);
	}

	public void setHealth(int health) {
		this.health = health;
		
	}

	public int getHealth() {
		return health;
	}

	@Override
	public void update(Movement key, CopyOnWriteArrayList bullets) {
		if(key.equals(Movement.PLAYER_1_UP)){
			if(yPosition>GameFrame.MINIMUM_UPPER_POSITION_30){
				yPosition--;
				rectangle.y--;
			}
		}else if(key.equals(Movement.PLAYER_1_DOWN)){
			if(yPosition<GameFrame.MAXIMUM_LOWER_POSITION_360){
				yPosition++;
				rectangle.y++;
			}
		}
		if(key.equals(Movement.PLAYER_2_UP)){
			if(yPosition>30){
				yPosition--;
				rectangle.y--;
			}
		}else if(key.equals(Movement.PLAYER_2_DOWN)){
			if(yPosition<360){
				yPosition++;
				rectangle.y++;
			}
		}
	}
}
