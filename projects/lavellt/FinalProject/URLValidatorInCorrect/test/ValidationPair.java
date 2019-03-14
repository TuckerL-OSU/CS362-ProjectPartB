public class ValidationPair {
	public String url;
	public boolean valid;
	
	public ValidationPair() {
		this.url = "";
		this.valid = true;
	}
	
	public ValidationPair(String url, boolean valid) {
		this.url = url;
		this.valid = valid;
	}
}