package com.gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class GameWindow extends JPanel {

	private final Tamagotchi
		tamagotchi;

//	--------------------------------------------------------------------------------------------------------------------

	public GameWindow(Tamagotchi tamagotchi){

		this.tamagotchi = tamagotchi;

		setLayout(null);
		addButtons();
	}

//	--------------------------------------------------------------------------------------------------------------------

	public void addButtons(){

		ImageIcon
			buttonIcon = null;

		JButton
			buttonJedzenie = new JButton(),
			buttonZabawa = new JButton(),
			buttonSpanie = new JButton();

		try {

			buttonIcon = new ImageIcon(ImageIO.read(new File("grafika\\klawisz.jpg")));
		}

		catch (Exception e){

			System.out.println("Błędny adres grafiki klawisza.");
		}

		constructButton(buttonJedzenie, new Rectangle(152, 290, 50, 25), buttonIcon, "Jedzenie");
		constructButton(buttonZabawa, new Rectangle(205, 310, 50, 25), buttonIcon, "Zabawa");
		constructButton(buttonSpanie, new Rectangle(258, 290, 50, 25), buttonIcon, "Spanie");
	}

	private void constructButton(JButton button, Rectangle location, ImageIcon ikonaKlawisza, String name){

		button.setName(name);

		button.setBounds(location);
		button.setBorderPainted(false);
		button.setIcon(ikonaKlawisza);

		button.addActionListener( e -> constructAction(name));

		add(button);
	}

	private void constructAction(String level){

		if(tamagotchi.getLvl(level) < 5)
			tamagotchi.increaseLvl(level);

		repaint();
	}

		@Override
	public Dimension getPreferredSize(){

		return new Dimension(450, 450);
	}

		@Override
	protected void paintComponent(Graphics g){

		super.paintComponent(g);

		BufferedImage obrazek;

		try {

			String
				adres = "grafika\\" + tamagotchi.getMinLevel() + ".jpg";

			File
				file = new File(adres);

			obrazek = ImageIO.read(file);
			g.drawImage(obrazek, 0, 0, this);
		}

		catch (Exception e){

			System.out.println("Niepoprawna ścieżka dostępu.");
		}
	}
}