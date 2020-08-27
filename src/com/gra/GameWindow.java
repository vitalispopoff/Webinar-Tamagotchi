package com.gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class GameWindow extends JPanel {

	public GameWindow(){

		setLayout(null);
		addButtons();
	}

//	--------------------------------------------------------------------------------------------------------------------

	public void addButtons(){

		Buttons
			buttonsJedzenie = new Buttons(ButtonContext.JEDZENIE),
			buttonsZabawa = new Buttons(ButtonContext.ZABAWA),
			buttonsSpanie = new Buttons(ButtonContext.SPANIE);

		add(buttonsJedzenie);
		add(buttonsZabawa);
		add(buttonsSpanie);
	}

	@Override
	public Dimension getPreferredSize(){

		return new Dimension(450, 450);
	}

	@Override
	protected void paintComponent(Graphics g){

		super.paintComponent(g);

		BufferedImage
			image;

		String
			adres = "grafika\\" + Tamagotchi.getMinLevel() + ".jpg";

		File
			file = new File(adres);

		try {

			image = ImageIO.read(file);
			g.drawImage(image, 0, 0, this);
		}

		catch (Exception e){

			System.out.println("Niepoprawna ścieżka dostępu.");
		}
	}
}