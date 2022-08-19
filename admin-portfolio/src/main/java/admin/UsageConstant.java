package admin;

public enum UsageConstant {
	YES("Y"), NO("N");
	
	private String value;
	
	UsageConstant(String value) {
		this.value = value;
	};
	
	public String getValue() {
		return this.value;
	}
}
