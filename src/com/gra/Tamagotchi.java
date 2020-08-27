//	@formatter:off

package com.gra;

import javax.swing.*;
import java.util.Random;

public class Tamagotchi extends JFrame {

	static Tamagotchi
		tamagotchi;

	static int
		lvl_Jedzenie = 5,
		lvl_Zabawa = 5,
		lvl_Spanie = 5;

	Thread
		gameLogic;

//	--------------------------------------------------------------------------------------------------------------------

	public Tamagotchi() {

		tamagotchi = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		GameWindow
			window = new GameWindow();

		add(window);
		pack();

		setGameLogic();
		gameLogic.start();
	}

//	--------------------------------------------------------------------------------------------------------------------

	private void setGameLogic(){

		this.gameLogic = new Thread( () -> {

			boolean
				gameIsOver = false;

			Random
				random = new Random();

			int
				timeRandomizer = 5000;

			while(!gameIsOver) {

				try {

					int
						time = random.nextInt(timeRandomizer) + 1000,
						index = new Random().nextInt(3);

					ButtonContext
						context = ButtonContext.values()[index];

					context.decreaseLevel();
					refresh();
					reportStatus();

					if (getMinLevel() == 0)

						gameIsOver = true;

					Thread.sleep(time);
					timeRandomizer -= 50;
				}

				catch (Exception e) {

					System.out.println("Błędny czas dostępu do wątku.");
				}
			}

			JOptionPane.showMessageDialog(null, "Haha! Przegrałeś.");
		});

	}

	public void refresh(){

		repaint();
	}

	public static int getMinLevel(){

		return Math.min(lvl_Jedzenie, Math.min(lvl_Zabawa, lvl_Spanie));
	}

	public void reportStatus() {

		System.out.println(
			"-----------------------------\n"
			+ "\tJedzenie : " + lvl_Jedzenie + "\n"
			+ "\tZabawa : " + lvl_Zabawa + "\n"
			+ "\tSpanie : " + lvl_Spanie + "\n"
		);
	}

//	--------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {

		Tamagotchi tamagotchi = new Tamagotchi();

		tamagotchi.reportStatus();
	}
}

//	@formatter:on