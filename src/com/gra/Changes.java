package com.gra;

enum Changes {

	JEDZENIE {

		@Override
		public void changeStatus(Tamagotchi tamagotchi) {

			tamagotchi.lvl_Jedzenie--;
		}
	},

	ZABAWA {
		@Override
		public void changeStatus(Tamagotchi tamagotchi) {

			tamagotchi.lvl_Zabawa--;
		}
	},

	SPANIE {

		@Override
		public void changeStatus(Tamagotchi tamagotchi) {

			tamagotchi.lvl_Spanie--;
		}
	};

	public void changeStatus(Tamagotchi tamagotchi){ }
}
