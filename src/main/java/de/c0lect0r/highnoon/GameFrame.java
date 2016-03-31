package de.c0lect0r.highnoon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener {
	public static final int MAXIMUM_LOWER_POSITION_360 = 360;
	public static final int MINIMUM_UPPER_POSITION_30 = 30;

	public static final String HIGH_NOON_TITLE = "High Noon";
	private static final long serialVersionUID = 7088273539648875301L;
	private Player player1;
	private Movement player1Key;
	private Player player2;
	private Movement player2Key;
	private Image image;
	private Graphics graphics;
	private CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();

	public CopyOnWriteArrayList<Bullet> getBullets() {
		return bullets;
	}

	public GameFrame(Player player1, Player player2) {
		initFrame();
		addKeyListener(this);
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		player1Key = Movement.NO_KEY_PRESSED;
		player2Key = Movement.NO_KEY_PRESSED;
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(HIGH_NOON_TITLE);
		setVisible(true);
		setSize(600, 400);
		setResizable(false);
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {

		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		graphics.fillRect(0, 0, getWidth(), getHeight());

		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();

	}

	public void paintComponent(Graphics g) {
		if (player1.getHealth() > 0 && player2.getHealth() > 0) {
			for (Bullet bullet : bullets) {
				bullet.draw(g);
				bullet.update(Movement.NO_KEY_PRESSED, bullets);
			}
		}else if(player1.getHealth() == 0){
			g.setColor(Color.ORANGE);
			g.drawString("Cowboy 2 hat gewonnen", 290, 190);
		}
		else if(player2.getHealth() == 0){
			g.setColor(Color.ORANGE);
			g.drawString("Cowboy 1 hat gewonnen", 290, 190);
		}
		player1.draw(g);
		player1.update(player1Key, this.bullets);
		player2.draw(g);
		player2.update(player2Key, this.bullets);

	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2Key = Movement.PLAYER_2_UP;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2Key = Movement.PLAYER_2_DOWN;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			player1Key = Movement.PLAYER_1_UP;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player1Key = Movement.PLAYER_1_DOWN;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			player1Key = Movement.PLAYER_1_SHOOT;
			Bullet player1Bullet = new Bullet(player2, player1.getXPosition() + 40, player1.getYPosition() + 16, 2,
					ImageHelper.getImage("sprites/bullet.gif"), 5, 5);
			bullets.add(player1Bullet);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			player1Key = Movement.PLAYER_2_SHOOT;
			Bullet player2Bullet = new Bullet(player1, player2.getXPosition() - 5, player2.getYPosition() + 16, -2,
					ImageHelper.getImage("sprites/bullet.gif"), 5, 5);
			bullets.add(player2Bullet);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2Key = Movement.NO_KEY_PRESSED;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2Key = Movement.NO_KEY_PRESSED;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			player2Key = Movement.NO_KEY_PRESSED;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player2Key = Movement.NO_KEY_PRESSED;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			player2Key = Movement.NO_KEY_PRESSED;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			player2Key = Movement.NO_KEY_PRESSED;
		}
	}
}
