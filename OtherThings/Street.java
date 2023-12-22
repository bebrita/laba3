package OtherThings;

public enum Street {
	TWISTEDSTREET("Крученая улица"),
	SNAKELANE("Змеиный проспект");

	private String translation;
	
	Street(String string) {
		this.translation = string;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	@Override
	public String toString() {
		String mes = "'" + getTranslation() + "'";
		return mes;
	}	
}
