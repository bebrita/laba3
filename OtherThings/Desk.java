package OtherThings;

import java.util.Objects;

public class Desk {
	protected boolean Cap = getBoolean();
	
	private static boolean getBoolean() {
		double prob_cap = Math.random();
		if (prob_cap <= 0.9) {
			return true;
		}
		return false;
	}
		
	public boolean CanUseCapAsRam(int Power) {
		if (Cap == true && Power >= 15) {
			System.out.print("Крышка есть. ");
			return true;
		}else if (Cap == false) {
			System.out.print("Крышки стола нигде нет. ");;
		}else {
			System.out.print("Крышка слишком тяжелая. ");
		}
		return false;
	}

	@Override
	public String toString() {
		return "Desk [Cap=" + Cap + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Cap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desk other = (Desk) obj;
		return Cap == other.Cap;
	}
}
