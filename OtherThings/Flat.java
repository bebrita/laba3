package OtherThings;

import java.util.Objects;
import java.util.Random;

public class Flat {
	
	private static boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public static class GlassCabinet{
		protected boolean Broken = false;
		protected boolean ThereIsSpaceSuit = getRandomBoolean();

		public boolean getThereIsSpaceSuit() {
			return ThereIsSpaceSuit;
		}

		public void setThereIsSpaceSuit(boolean thereIsSpaceSuit) {
			ThereIsSpaceSuit = thereIsSpaceSuit;
		}

		@Override
		public String toString() {
			return "GlassCabinet [Broken=" + Broken + ", ThereIsSpaceSuit=" + ThereIsSpaceSuit + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(Broken, ThereIsSpaceSuit);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GlassCabinet other = (GlassCabinet) obj;
			return Broken == other.Broken && ThereIsSpaceSuit == other.ThereIsSpaceSuit;
		}

		public boolean getBroken() {
			return Broken;
		}

		public void setBroken(boolean broken) {
			Broken = broken;
		}
	}
	
	public static class FireproofCabinet{
		int Empty = 0;

		@Override
		public int hashCode() {
			return Objects.hash(Empty);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FireproofCabinet other = (FireproofCabinet) obj;
			return Empty == other.Empty;
		}
		}
	
	public static class FireproofChest{
		protected int ThereIsMoney = calcMoney();
		
		@Override
		public int hashCode() {
			return Objects.hash(ThereIsMoney, ThereIsPaper);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FireproofChest other = (FireproofChest) obj;
			return ThereIsMoney == other.ThereIsMoney && ThereIsPaper == other.ThereIsPaper;
		}

		private int calcMoney() {
			double some = Math.random();
			if (some >= 0.25) {
				return 2;
			}else {
				return 0;
			}
		}
				
		public int getThereIsMoney() {
			return ThereIsMoney;
		}
		
		public void setThereIsMoney(int ThereIsMoney) {
			this.ThereIsMoney = ThereIsMoney;
		}
		
		private boolean ThereIsPaper = true;

		public boolean getThereIsPaper() {
			return ThereIsPaper;
		}

		public void setThereIsPaper(boolean thereIsPaper) {
			ThereIsPaper = thereIsPaper;
		}
	}
}
	

