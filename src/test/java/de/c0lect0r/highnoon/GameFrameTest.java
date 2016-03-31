package de.c0lect0r.highnoon;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestSuite;

public class GameFrameTest extends TestSuite{

	@Test
	public void initGameClass(){
		assertNotNull(new GameFrame(new Player(0,0,null,0,0,0), new Player(0,0,null,0,0,0)));
	}
	@Test
	public void shouldHaveDefaultTitle(){
		GameFrame gameFrame = new GameFrame(new Player(0,0,null,0,0,0), new Player(0,0,null,0,0,0));
		Assert.assertSame(GameFrame.HIGH_NOON_TITLE, gameFrame.getTitle());
	}
	
}
