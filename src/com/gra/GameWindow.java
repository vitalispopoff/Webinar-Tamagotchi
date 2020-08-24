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

		File
			file = new File("grafika\\klawisz.jpg");

		Object[][]
			buttonParameters = {

				{buttonJedzenie, new Rectangle(152, 290, 50, 25), "Jedzenie"},
				{buttonZabawa, new Rectangle(205, 310, 50, 25), "Zabawa"},
				{buttonSpanie, new Rectangle(258, 290, 50, 25), "Spanie"}
		};

		try {

			buttonIcon = new ImageIcon(ImageIO.read(file));
		}

		catch (Exception e){

			System.out.println("Błędny adres grafiki klawisza.");
		}

		for(Object[] o : buttonParameters)
			constructButton(o,  buttonIcon);
	}

	private void constructButton(Object[] objectParameters, ImageIcon buttonIcon){

		JButton
			button = (JButton) objectParameters[0];

		Rectangle
			location = (Rectangle) objectParameters[1];

		String
			name = (String) objectParameters[2];

		button.setName(name);
		button.setBounds(location);
		button.setBorderPainted(false);
		button.setIcon(buttonIcon);

		button.addActionListener(e -> constructAction(name));
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

		BufferedImage image;

		try {

			String
				adres = "grafika\\" + tamagotchi.getMinLevel() + ".jpg";

			File
				file = new File(adres);

			image = ImageIO.read(file);
			g.drawImage(image, 0, 0, this);
		}

		catch (Exception e){

			System.out.println("Niepoprawna ścieżka dostępu.");
		}
	}
}