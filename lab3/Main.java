package lab3;


import OtherThings.*;
import Shorties.*;

public class Main{
	 public static void main(String[] args) {
		int count = (int) ((Math.random()*10) + 1);
		int power = (int) ((Math.random()*50) + 1);
		int speed = (int) ((Math.random()*40) + 1);
		Dunno dunno = new Dunno();
		Goat goat = new Goat();
		Shareholders shorties = new Shareholders(speed, power, count);
		Flat.FireproofChest chest = new Flat.FireproofChest();
		Flat.GlassCabinet gCab = new Flat.GlassCabinet();
		Door door = new Door();
		Desk desk = new Desk();
		Yard yard = new Yard();
		
		System.out.println("Узнаем, что было до нашей истории... ");
		dunno.EnterTheRoom();
		goat.EnterTheRoom();
		Space();
		dunno.HaveMoney(chest);
		goat.HaveMoney(chest);
		dunno.LeaveTheSpaceSuit(gCab);
		Space();
		dunno.GoingDownTheRope();
		goat.GoingDownTheRope();
		Space();
		dunno.RunAwayWithMoney();
		goat.RunAwayWithMoney();
		Space();
	    System.out.println("Прошло немного времени. ");
	    shorties.start();
	    Space();
	    if (shorties.BreakTheDoor(desk, door)) {
	    	shorties.FallToTheFloor();
	    	Space();
	    	shorties.SeeDunnoOrGoat(dunno, goat);
	    	if (shorties.RunAwayWithMoney() == false) {
	    		shorties.RunToTheFireproofCabinet();
	    		shorties.RunToTheFireproofChest();
	    		Space();
	    		if(shorties.OpenAndCheckTheChest(chest, dunno, goat)) {
	    			shorties.BreakTheCabinet(gCab);
	    			Space();
	    			shorties.BreakTheSpaceSuit(gCab);
	    			Space();
	    			shorties.LookOutTheWindow(dunno, goat);
	    			Space();
	    			shorties.CatchRope(dunno, goat);
	    			Space();
	    			shorties.GoingDownTheRope();
	    			shorties.GoingDownTheStairs();
	    			Space();
	    			if (shorties.WalkingDownTheStreet(yard)) {
	    				Space();
	    				shorties.SearchForAStoreOfMiscellaneousGoods();
	    			}
	    		}else {
	    			shorties.RunAwayWithMoney();
	    		}
	    	}
	    }
	}
	public static void Space() {
		System.out.println();
	 }
}