package OtherThings;

import java.util.Objects;

public class Door {
	protected boolean Broken = false;
	private double probBreak = Math.random();
	
	public boolean Cracle() {
		if (probBreak >= 0.25) {
			System.out.print("Дверь треснула. ");
			return true;
		}else {
			System.out.print("Дверь не треснула. ");
			return false;
		}
	}
	
	public boolean FlyOffTheHinges() {
		if (probBreak >= 0.30) {
			System.out.print("Дверь слетела с петель. ");
			return true;
		}else {
			System.out.print("Дверь не слетела с петель. ");
			return false;
		}
	}
	
	public boolean FallToTheFloor() {
		if (probBreak >= 0.4) {
			System.out.print("Дверь упала на пол. ");
			return true;
		}else {
			System.out.print("Дверь не упала на пол. ");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Door [Broken=" + Broken + ", probBreak=" + probBreak + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Broken, probBreak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Door other = (Door) obj;
		return Broken == other.Broken && Double.doubleToLongBits(probBreak) == Double.doubleToLongBits(other.probBreak);
	}

	public double getProbBreak() {
		return probBreak;
	}

	public void setProbBreak(double probBreak) {
		if (probBreak >= 0) {
			this.probBreak = probBreak;
		}else {
			System.err.println("Ошибка! Неверное значение вероятности выбить дверь.");
		}
	}
	public boolean getBroken() {
		return Broken;
	}

	public void setBroken(boolean Broken) {
	this.Broken = Broken;
	}	
}
