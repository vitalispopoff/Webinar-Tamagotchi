package com.gra;

import javax.swing.*;
import java.util.Random;

public class Tamagotchi extends JFrame {

	int
		lvl_Jedzenie = 5,
		lvl_Zabawa = 5,
		lvl_Spanie = 5;

//	--------------------------------------------------------------------------------------------------------------------

	public Tamagotchi(String nazwa) {

		super(nazwa);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		GameWindow
			okno = new GameWindow(this);

		add(okno);
		pack();

		Thread
			logikaGry = new Thread(

				() -> {

					boolean
						gameIsOver = false;

					while(!gameIsOver) {

						try {

							Thread.sleep(2000);

							int
								whatChanges = new Random().nextInt(3) + 1;

							Changes.values()[whatChanges].changeStatus(this);

							reportStatus();

							if (getMinLevel() > 0)
								repaint();

							else
								gameIsOver = true;
						}

						catch (Exception e) {

							System.out.println("Błędny czas dostępu do wątku.");
						}
					}

				JOptionPane.showMessageDialog(null, "Haha! Przegrałeś.");
			}
		);

		logikaGry.start();
	}

//	--------------------------------------------------------------------------------------------------------------------

	public int getLvl(String level){

		if(level.equals("Jedzenie")) return lvl_Jedzenie;
		if(level.equals("Zabawa")) return lvl_Zabawa;
		if(level.equals("Spanie")) return lvl_Spanie;

		return 0;
	}

	public void increaseLvl(String level){

		if(level.equals("Jedzenie"))

			lvl_Jedzenie++;

		if(level.equals("Zabawa"))

			lvl_Zabawa++;

		if(level.equals("Spanie"))

			lvl_Spanie++;
	}

	public int getMinLevel(){

		return Math.min(lvl_Jedzenie, Math.min(lvl_Zabawa, lvl_Spanie));
	}



	public void reportStatus() {

		System.out.println(
				"-----------------------------\n"
						+ "Jedzenie : " + lvl_Jedzenie + "\n"
						+ "Zabawa : " + lvl_Zabawa + "\n"
						+ "Spanie : " + lvl_Spanie + "\n"
		);
	}

	//	--------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {

		Tamagotchi tamagotchi = new Tamagotchi("Tamagotchi");

		tamagotchi.reportStatus();
	}
}