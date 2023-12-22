package Shorties;

import OtherThings.*;

public class Goat extends Shorty {
	
	private static double calc(double probality) {
		double calc_p = 0;
		if (probality >= 0.5) {
			calc_p = 1;
		}else {
			calc_p = 2 * probality;
		}
		return calc_p;	
	}
	
	@Override
	public void HaveMoney(Flat.FireproofChest chest) {
		if (chest.getThereIsMoney() == 1) { 
			System.out.print("Незнайка дал в руки Козлику немного денег. ");
			setMoney(true);
		}else {
			setMoney(false);
		}
	}

	@Override
	public void GoingDownTheRope() {
		if (calc(probality) >= 0.6) { 
			System.out.print("Козлик спустился по веревке вниз. ");
			setEscaped(true);
		}else {
			System.out.print("Козлик забоялся спускаться по веревке и остался в запертой комнате. ");
			setEscaped(false);
		}
	}

	@Override
	public void EnterTheRoom() {
		System.out.print("Козлик забежал в комнату, запер дверь и съел сырный ключ(все-таки мы на Луне). ");
	}

	@Override
	public boolean RunAwayWithMoney() {
		if (getEscaped() == true) { 
			System.out.print("Козлик сбежал ");
			if (getMoney() == true) {
				System.out.print("с деньгами. ");
			}else {
				System.out.print("без денег. ");
			}
			return true;
		}
		return false;
	}
}
