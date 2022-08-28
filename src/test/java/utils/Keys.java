package utils;

public enum Keys {
	
	EURO("\u20ac"),
	HTML("html");
	
	Keys(String value) {this.value = value; }
	
	private final String value;
	
	
	public String getValue() {
		return this.value;
	}
}
