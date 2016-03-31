package de.c0lect0r.highnoon;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public final class ImageHelper {

	public static Image getImage(String image) {
		return Toolkit.getDefaultToolkit().getImage(image);
	}

	public Image getImageUsingResource(String imageURL) {
		return (new ImageIcon(this.getClass().getResource(imageURL))).getImage();
	}
}
