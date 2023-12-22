package Shorties;

import Exp.Open;
import Exp.Rope;
import OtherThings.Desk;
import OtherThings.Door;
import OtherThings.Flat;
import OtherThings.Street;
import OtherThings.Yard;

public class Shareholders extends Shorty implements ToBeHappy {
	
	protected String Nosy = "Нос целый";
	protected int FerocityLevel; //from 1 to 100
	protected int Count = 1; //from 1 to 10
	protected int Speed = 1; //from 1 to 40
	protected int Power = 1; //from 1 to 50
	private int probCount =  (int) Math.random()*Count;
	protected int Brave =  (int) ((int) Count*Math.random());
	
	private int CalcFerocityLevel(int Count, int Speed, int Power) {
		return Count+Speed+Power;
	}
	
	public int getFerocityLevel() {
		return FerocityLevel;
	}
	
	public int getCount() {
		return Count;
	}
	
	public int getProbCount() {
		return probCount;
	}

	public int getSpeed() {
		return Speed;
	}
	
	public int getPower() {
		return Power;
	}
	
	public void setFerocityLevel(int ferocityLevel) {
		   if (ferocityLevel >= 1 && ferocityLevel <= 100) {
		       this.FerocityLevel = ferocityLevel;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение уровня свирепости.");
		   }
		}
	
	public void setCount(int count) {
		   if (count >= 1 && count <= 10) {
		       this.Count = count;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение количества коротышек.");
		   }
		}
	
	public void setProbCount(int probcount) {
		   if (probcount >= 0 && probcount <= 10) {
		       this.probCount = probcount;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение части коротышек.");
		   }
		}
	
	public void setPower(int power) {
		   if (power >= 1 && power <= 50) {
		       this.Power = power;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение силы.");
		   }
		}
	
	public void setSpeed(int speed) {
		   if (speed >= 1 && speed <= 40) {
		       this.Speed = speed;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение скоростию.");
		   }
		}
	
	public String getNosy() {
		return Nosy;
	}
	
	public void setNosy(String nosy) {
		if (nosy == "Нос разбитый" || nosy == "Нос целый") {
			this.Nosy = nosy;
		}else {
			System.err.print("Ошибка! Введено неопределенное значение состояния носов коротышек.");
		}	
	}
	
	public Shareholders(int speed, int power, int count) {
		setCount(count);
		setNosy("Нос целый");
		setPower(power);
		setSpeed(speed);
		setFerocityLevel(CalcFerocityLevel(count, power, speed));
		int probcount = (int) ((int)count*Math.random());
		setProbCount(probcount);
	}
	
	public void start() {
		if (Count == 1) {
			System.out.print("Коротышка-аукционер забежал по лестнице. Он искал Незнайку, Козлика и деньги. ");
		}else {
			System.out.print("Коротышки-аукционеры забежали по лестнице. Они искали Незнайку, Козлика и деньги. ");
		}
	}
	
	public boolean BreakTheDoor(Desk desk, Door door) {
		if (door.getBroken() == true) {
			if (Count == 1) {
				System.out.print("Коротышка просто зашел в комнату, дверь была сломана. ");
			}else {
				System.out.print("Коротышки просто зашли в комнату, дверь была сломана. ");
			}
			return true;
		}else{
			if (Count == 1) {
				System.out.println("Один коротышка не сможет выбить дверь. Он растроился и ушел. ");
				return false;
			}else {
				System.out.print("Коротышки искали, чем можно выбить дверь. ");
				if (desk.CanUseCapAsRam(Power)) {
					System.out.println("Коротышки взяли крышку стола и решили ее использовать в качестве тарана. ");
					while(Count*Power < 40 ) {
						System.out.println("У коротышек не хватает выбить дверь, им необходимо отдохнуть и накопить сил. ");
						Power += 2;
					}
					while (door.Cracle() == false || door.FlyOffTheHinges()==false || door.FallToTheFloor()==false) {
						System.out.println("Не получилось. Еще раз!");
						door.setProbBreak(door.getProbBreak() * 2);
					}
					System.out.print("У коротышек получилось выбить дверь! ");
					Power = (int) (Math.ceil(Count) / 2);
					door.setBroken(true);		
					return true;
				}else {
					System.out.print("Коротышки расстроились и ушли. ");
				}
			}	
		}
		return false;
	}
	
	public void FallToTheFloor() {
		System.out.print("Коротышки упали и разбили носы.");
		setNosy("Нос целый");
	}
	
	@Override
	public void EnterTheRoom() {
		if (Count == 1) {
			System.out.print("Коротышка попал в комнату. ");
		}else {
			System.out.print("Коротышки попали в комнату. ");
		}
	}
	
	public void SeeDunnoOrGoat(Dunno Dunno, Goat Goat) {
		if (Dunno.getEscaped() == false || Goat.getEscaped() == false) {
			if (Count == 1) {
				System.out.print("Коротышка увидел предателя и напал. ");
			}else {
				System.out.print("Коротышки увидели предателя и напали. ");
			}
			if (Dunno.getMoney() == true || Goat.getMoney() == true) {
				if (Count == 1) {
					System.out.print("Он подумал: 'У него деньги!!'. И коротышка забрал деньги. ");
				}else {
					System.out.print("Кто-то крикнул: 'У него деньги!!'. И коротышки забрали деньги. ");
				}
				setMoney(true);
			} else if (Count == 1) {
				System.out.print("Он не нашел деньги у предателя. ");
			}else {
				System.out.print("Они не нашли деньги у предателя. ");
			}
		}
	}
	
	public boolean BoolSeeDunnoOrGoat(Dunno Dunno, Goat Goat) {
		if (Dunno.getEscaped() == false || Goat.getEscaped() == false) {
			if (Dunno.getMoney() == true || Goat.getMoney() == true) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean RunAwayWithMoney() {
		if (getMoney()==true) {
			if (Count == 1) {
				System.out.print("Коротышка сделал свое дело и ушел. ");
			}else {
				System.out.print("Коротышки сделали свое дело и ушли. ");
			}
			return true;
		}
		return false;
	}
	
	public void RunToTheFireproofCabinet() {
		if(probCount == 0) {
			System.out.print("Никто из которышек не побежал к несгораемому шкафу. ");
		}else if (probCount == 1){
			System.out.print("Коротышка побежала к несгораемому шкафу. ");
		}else if (probCount == 2 || probCount == 3) {
			System.out.printf("%s коротышки побежали к несгораемому шкафу. ", probCount);
		}else {
			System.out.printf("%s коротышек побежали к несгораемому шкафу. ", probCount);
		}
	}
	
	public void RunToTheFireproofChest() {
		if(Count - probCount == 0) {
			System.out.print("Никто из которышек не побежал к несгораемому сундуку. ");
		}else if (Count - probCount == 1){
			System.out.print("Коротышка побежала к несгораемому сундуку. ");
		}else if (Count - probCount == 2 || Count - probCount == 3) {
			System.out.printf("%s коротышки побежали к несгораемому сундуку. ", Count - probCount);
		}else {
			System.out.printf("%s коротышек побежали к несгораемому сундуку. ", Count - probCount);
		}
	}
	
	
	@Override
	public void HaveMoney(Flat.FireproofChest chest) {
		if (chest.getThereIsMoney() == 2) {
			setMoney(true);
		}else {
			setMoney(false);
		}
	}
	
	public boolean OpenAndCheckTheChest(Flat.FireproofChest chest, Dunno dunno, Goat goat) {
		HaveMoney(chest);
		if (chest.getThereIsPaper()) {
			if (Count - probCount == 1) {
				System.out.print("Коротышка увидел бумаги от акций и разорвал их. ");
			}else if (Count - probCount == 2 || Count - probCount == 3 || Count - probCount == 4) {
				System.out.printf("%s коротышки увидели бумаги от акций и разорвали их. ", Count - probCount);
			}else {
				System.out.printf("%s коротышек увидели бумаги от акций и разорвали их. ", Count - probCount);
			}
			chest.setThereIsPaper(false);
		}
		if (getMoney()) {
			System.out.print("УРА ТУТ ДЕНЬГИ!!! ");
			return false;
		}else {
			if (Count - probCount == 1) {
				System.out.print("Он не нашел денег и очень сильно разозлился!!  ");
			}else {
				System.out.print("Они не нашли денег и очень сильно разозлились!! ");
			}
			if (BoolSeeDunnoOrGoat(dunno, goat)) {
				System.out.print("Значит деньги в другом месте. ");
				return false;
			}
			if (getFerocityLevel() <= 90) {
				setFerocityLevel(FerocityLevel + 10);
			}else {
				setFerocityLevel(100);
			}
			
		}
		return true;
	}
	
	public void BreakTheCabinet(Flat.GlassCabinet cab) {
		if (getFerocityLevel() < 60) {
			if (Count == 1) {
				System.out.print("Коротышка не свирепый и не сломал шкаф. ");
			}else {
				System.out.print("Коротышки не свирепые и не сломали шкаф. ");
			}
		}else {
			cab.setBroken(true);
			if (Count == 1) {
				System.out.print("Коротышка сломал стеклянный шкаф.  ");
			}else if (Count == 2 || Count == 3 ) {
				System.out.printf("%s коротышки сломали стеклянный шкаф. ", Count);
			}else {
				System.out.printf("%s коротышек сломали стеклянный шкаф. ", Count);
			}
		}
	}
	
	public void BreakTheSpaceSuit(Flat.GlassCabinet cab) {
		if (cab.getThereIsSpaceSuit() == true) {
			System.out.print("Кто-то крикнул: 'Тут скафандр Незнайки!' ");
			if (FerocityLevel >= 40) {
				cab.setThereIsSpaceSuit(false);
				if (Count == 1) {
					System.out.print("Коротышка разорвал скафандр Незнайки. ");
				}else if (Count == 2 || Count == 3) {
					System.out.printf("%s коротышки разорвали скафандр Незнайки. ", Count);
				}else {
					System.out.printf("%s коротышек разорвали скафандр Незнайки. ", Count);
				}
			}
		}
	}
	
	private static void ExpOpen() throws Open {
		probality = probality * 0.5 - 0.2;
        if (probality <= 0) {
            throw new Open("Окно не поддалось!");
        }
    }
	
	public void LookOutTheWindow(Dunno Dunno, Goat Goat) {
		if (Count == 1) {
			System.out.print("Коротышка посмотрел в окно! Он подумал: 'Может они через окно сбежали?!' ");
		}else {
			System.out.print("Коротышки посмотрели в окно! Кто-то выкрикнул: 'Может они через окно сбежали?!' ");
		}
		if (Dunno.getEscaped() == true && Goat.getEscaped() == true) {
			System.out.print("Окно открыто. ");
		}else if ((Goat.getEscaped() == false && Dunno.getEscaped() == true) || (Goat.getEscaped() == true && Dunno.getEscaped() == false)){
			System.out.print("Окно закрыто. ");
			boolean local = false;
			while(local == false) {
				try {
					ExpOpen();
					local = true;
					if (Count == 1) {
						System.out.print("Коротышка понял, как открыть окно. ");
					}else {
						System.out.print("Коротышки понял, как открыть окно.  ");
					}
				}catch (Open e) {
					System.out.print(e.getMessage());
		        }
				probality += 1.1;
			}
		}
	}

	private static void ExpRope() throws Rope {
		probality = probality * 0.8 - 0.7;
        if (probality < 0) {
            throw new Rope("Еще чуть-чуть до веревки! ");
        }
    }
	
	public void CatchRope(Dunno Dunno, Goat Goat) {
		if (Count == 1) {
			System.out.print("Коротышка понял, что сбежавшие спустились по веревке. ");
		}else {
			System.out.print("Коротышки поняли, что сбежавшие спустились по веревке. ");
		}
		if (Dunno.getEscaped() == false && Goat.getEscaped() == false) {
			System.err.print("что то не так написала Ж(");
		}else{
			boolean local = false;
			while(local == false) {
				try {
					ExpRope();
					local = true;
					if (Count == 1) {
						System.out.print("Коротышка достал до веревки. ");
					}else {
						System.out.print("Коротышки достали до веревки. ");
					}
				}catch (Rope e) {
					System.out.print(e.getMessage());
		        }
				probality += 1.1;
			}
		}
	}
	
	@Override
	public void GoingDownTheRope() {
		if (Brave == 0) {
			System.out.print("Никто не осмелился спуститься по веревке. ");
		}else if (Brave == 1) {
			System.out.print("Коротышка спустился по веревке. ");
		}else if (Brave == 2 || Brave == 3) {
			System.out.printf("%s коротышек спустились по веревке. ", Brave);
		}else{
			System.out.printf("%s коротышки спустилось по веревке. ", Brave);
		}
	}
	
	public void GoingDownTheStairs() {
		if (Count - Brave == 0) {
			System.out.print("Никто не осмелился спуститься по лестнице. ");
		}else if (Count - Brave == 1) {
			System.out.print("Коротышка спустился по лестнице. ");
		}else if (Count - Brave == 2 || Count - Brave == 3 ) {
			System.out.printf("%s коротышек спустилось по лестнице. ", Count-Brave);
		}else{
			System.out.printf("%s коротышки спустилось по лестнице. ", Count-Brave);
		}
	}
	
	private boolean HowBrave() {
		if (Brave == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String TBH() {
        return "К счастью, ";
    }
	
	public boolean WalkingDownTheStreet(Yard yard) {
		if (HowBrave()) {
			if (Count == 1) {
				System.out.print("Коротышка выбежал на улицу. ");
				System.out.print("Он увидел вывеску " + Street.TWISTEDSTREET.toString()+ ". ");
				if (yard.getPassThrough() >= 10) {
					System.out.println(TBH() + "улица была свободна и коротышка помчался дальше. ");
					System.out.print("Коротышка быстро прошел улицу и свернул на другую. Он вспомнил, что это " + Street.SNAKELANE.getTranslation() + ". ");
				}else {
					System.out.print("На улице было очень много людей. " + Mingle() + "Он заплутал и потерялся. ");
					return false;
				}
			}else {
				System.out.print("Коротышки выбежали на улицу. ");
				System.out.print("Они увидели вывеску "+ Street.TWISTEDSTREET.toString() + ". " );
				if (yard.getPassThrough() >= 20) {
					System.out.println(TBH() + "улица была свободна и коротышки помчались дальше. ");
					System.out.print("Коротышки быстро прошли улицу и свернули на другую. Они вспомнили, что это " + Street.SNAKELANE.getTranslation() + ". ");
				}else {
					System.out.print("На улице было очень много людей. " + Mingle() + "Они заплутали и потерялись. ");
					return false;
				}
			}
		}else{
			if (Brave == 1) {
				System.out.print("Коротышка выбежали на улицу. ");
				System.out.print("Он увидел вывеску " + Street.TWISTEDSTREET.toString() + ". " );
				if (yard.getPassThrough() >= 10) {
					System.out.println(TBH() + "улица была свободна и коротышка помчались дальше. ");
					System.out.print("Коротышка быстро прошел улицу и свернул на другую. Он вспомнил, что это " + Street.SNAKELANE.getTranslation()+ ". ");
				}else {
					System.out.print("На улице было очень много людей. " + Mingle() + "Он заплутал и потерялся");
					return false;
				}
			}else {
				System.out.print("Коротышки выбежали на улицу. ");
				System.out.print("Они увидели вывеску " + Street.TWISTEDSTREET.toString() + ". " );
				if (yard.getPassThrough() >= 20) {
					System.out.println(TBH() + "улица была свободна и коротышки помчались дальше. ");
					System.out.print("Коротышки быстро прошли улицу и свернули на другую. Они вспомнил, что это " + Street.SNAKELANE.getTranslation() + ". ");
				}else {
					System.out.print("На улице было очень много людей. " + Mingle() + "Они заплутал и потерялся");
					return false;
				}
			}
		}
		return true;
	}
		
		
	
	public String Mingle() {
		if (Brave == 1) {
			return "Коротышка смешался с толпой. ";
		}else{
			return "Коротышки смешались с толпой. ";
		}
	}
	
	public void SearchForAStoreOfMiscellaneousGoods() {
		String words = " искать придателя в магазине разноколиберных товаров, но его нигде не было. ";
		if (HowBrave()) {
			if (Count == 1) {
				System.out.print("Коротышка отправился");
			}else if (Count == 2 || Count == 3 ) {
				System.out.printf("%s коротышки отправилось", Count);
			}else{
				System.out.printf("%s коротышек отправилось", Count);
			}
		}else{
			if (Brave == 1) {
				System.out.print("Коротышка отправился");
			}else if (Brave == 2 || Brave == 3) {
				System.out.printf("%s коротышки отправилось", Brave);
			}else{
				System.out.printf("%s коротышек отправилось", Brave);
			}
		}
		System.out.println(words);
	}
}
