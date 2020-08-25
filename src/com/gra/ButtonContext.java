package com.gra;

import java.awt.*;

enum ButtonContext {

	JEDZENIE {

		@Override
		public void decreaseLevel() {

			Tamagotchi.lvl_Jedzenie--;
		}

		@Override
		public void increaseLevel() {

			Tamagotchi.lvl_Jedzenie++;
		}

		@Override
		public int getLevel(){

			return Tamagotchi.lvl_Jedzenie;
		}
	},

	ZABAWA {
		@Override
		public void decreaseLevel() {

			Tamagotchi.lvl_Zabawa--;
		}

		@Override
		public void increaseLevel() {

			Tamagotchi.lvl_Zabawa++;
		}

		@Override
		public int getLevel(){

			return Tamagotchi.lvl_Zabawa;
		}
	},

	SPANIE {

		@Override
		public void decreaseLevel() {

			Tamagotchi.lvl_Spanie--;
		}

		@Override
		public void increaseLevel() {

			Tamagotchi.lvl_Spanie++;
		}

		@Override
		public int getLevel(){

			return Tamagotchi.lvl_Spanie;
		}
	};

//	--------------------------------------------------------------------------------------------------------------------

	public void decreaseLevel(){ }

	public void increaseLevel(){}

	public int getLevel(){

		return 0;
	}

	public Object[] getButtonParameters(){

		return buttonParameters[this.ordinal()];
	}

//	--------------------------------------------------------------------------------------------------------------------

	static Object[][]
		buttonParameters = {

			{new Rectangle(152, 290, 50, 25), "Jedzenie"},
			{new Rectangle(205, 310, 50, 25), "Zabawa"},
			{new Rectangle(258, 290, 50, 25), "Spanie"}
	};
}
