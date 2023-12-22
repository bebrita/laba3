package OtherThings;

import java.util.Objects;

public class Yard {
	protected int PassThrough = (int) (Math.random()*39)+1;

	public int getPassThrough() {
		return PassThrough;
	}

	public void setPassThrough(int passThrough) {
		if (passThrough >= 1 && passThrough <= 40) {
		       this.PassThrough = passThrough;
		   } else {
		       System.err.println("Ошибка! Ввели некоректное значение загруженности на улице.");
		   }
	}

	@Override
	public String toString() {
		return "Yard [PassThrough=" + PassThrough + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(PassThrough);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Yard other = (Yard) obj;
		return PassThrough == other.PassThrough;
	}	
}
