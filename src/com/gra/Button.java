package com.gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Button extends JButton {

	static File
			file = new File("grafika\\klawisz.jpg");

	static ImageIcon
			buttonIcon = setButtonIcon();

//	--------------------------------------------------------------------------------------------------------------------

	public Button(ButtonContext buttonContext){

		Object[]
			parameters = buttonContext.getButtonParameters();

		String
			name = (String) parameters[1];

		Rectangle
			location = (Rectangle) parameters[0];

		this.setName(name);
		this.setBounds(location);
		this.setBorderPainted(false);
		this.setIcon(buttonIcon);

		this.addActionListener(e -> constructAction(buttonContext));
	}

//	--------------------------------------------------------------------------------------------------------------------

	private void constructAction(ButtonContext buttonContext){

		if (buttonContext.getLevel() < 5)

			buttonContext.increaseLevel();

		else

			buttonContext.decreaseLevel();

		Tamagotchi.tamagotchi.refresh();
	}

	private static ImageIcon setButtonIcon(){

		try {

			return new ImageIcon(ImageIO.read(file));
		}

		catch (Exception exception) {

			System.out.println("Błędny adres grafiki klawisza.");

			return null;
		}
	}
}