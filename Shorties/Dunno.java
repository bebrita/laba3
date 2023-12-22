package Shorties;

import OtherThings.Flat;

public class Dunno extends Shorty implements FromEarth {
	
	public String FE() {
	        return "с Земли";
	    }
	
	private static double calc(double probality) {
		double calc_p = 0;
		if (probality >= 0.5) {
			calc_p = 1;
		}else {
			calc_p = 2 * probality;
		}
		return calc_p;	
	}
	
	public void LeaveTheSpaceSuit(Flat.GlassCabinet cab) {
		if (cab.getThereIsSpaceSuit() == true) { 
			System.out.printf("Незнайка %s взял свой скафандр. ", FE());
		}else {
			System.out.printf("Незнайка %s не нашел свой скафандр. ", FE());
		}
	}
	
	@Override
	public void HaveMoney(Flat.FireproofChest chest) {
		double item = Math.random();
		if (chest.getThereIsMoney() == 2 && item >= 0.25) { 
			System.out.printf("У Незнайки %s деньги. ", FE());
			chest.setThereIsMoney(1);
			setMoney(true);
		}else {
			System.out.printf("Незнайка %s не нашел денег. ", FE());
			setMoney(false);
		}
	}

	@Override
	public void GoingDownTheRope() {
		if (calc(probality) > 0.35) { 
			System.out.printf("Незнайка %s спустился по веревке вниз. ", FE());
			setEscaped(true);	
		}else {
			setEscaped(false);
			System.out.printf("Незнайка %s забоялся спускаться по веревке и остался в запертой комнате. ", FE());
		}
	}

	@Override
	public void EnterTheRoom() {
		System.out.printf("Незнайка %s вбежал в комнату и помчался искать деньги. ", FE());

	}

	@Override
	public boolean RunAwayWithMoney() {
		if (getEscaped() == true) { 
			System.out.printf("Незнайка %s сбежал ", FE());
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
