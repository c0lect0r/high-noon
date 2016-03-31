package de.c0lect0r.highnoon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bullet extends GameObject {
	private Player victimPlayer;
	private int deltaX;

	public Bullet(Player victimPlayer,int xPos, int yPos, int deltaX ,Image image, int width, int height) {
		this.setVictimPlayer(victimPlayer);
		this.setXPosition(xPos);
		this.setYPosition(yPos);
		this.deltaX = deltaX;
		this.setImage(image);
		this.setWidth(width);
		this.setHeight(height);
		this.rectangle = new Rectangle(xPos, yPos, width, height);
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(this.getImage(), getXPosition(), getYPosition(), null);
	}

	public int getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	@Override
	public void update(Movement key, CopyOnWriteArrayList bullets) {
		if(rectangle.intersects(victimPlayer.rectangle)){
			bullets.remove(this);
			victimPlayer.setHealth(victimPlayer.getHealth()-1);
		}else if (xPosition < 5 || xPosition > 595){
			bullets.remove(this);
		}else{
			xPosition += deltaX;
			rectangle.x += deltaX;
		}
		
	}

	public Player getVictimPlayer() {
		return victimPlayer;
	}

	public void setVictimPlayer(Player victimPlayer) {
		this.victimPlayer = victimPlayer;
	}
}
