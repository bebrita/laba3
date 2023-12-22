package Shorties;

import java.util.Objects;

import OtherThings.Flat;

public abstract class Shorty {
	protected String Small;
	protected static double probality = Math.random();
	protected boolean Escaped = false;
	protected boolean Money;
	
	public abstract void HaveMoney(Flat.FireproofChest chest);
	public abstract void GoingDownTheRope();
	public abstract void EnterTheRoom();
	public abstract boolean RunAwayWithMoney();
	
	public boolean getEscaped() {
		return Escaped;
	}
	public void setEscaped(boolean escaped) {
		Escaped = escaped;
	}
	public boolean getMoney() {
		return Money;
	}
	@Override
	public String toString() {
		return "Shorty [Small=" + Small + ", Escaped=" + Escaped + ", Money=" + Money + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Escaped, Money, Small);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Shorty)) {
			return false;
		}
		Shorty other = (Shorty) obj;
		return Escaped == other.Escaped && Money == other.Money && Objects.equals(Small, other.Small);
	}
	public void setMoney(boolean money) {
		Money = money;
	}
	
	
}
