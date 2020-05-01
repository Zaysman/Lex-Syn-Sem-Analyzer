package Objects;
//imports
import Objects.Token;

public class IdToken extends Token{

	public IdToken(String id) {
		this.type = "identifier";
		this.code = 25;
		this.lex = id;
		
		
	}
	
	
	
	
	public String getType() {
		return this.type;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getLex() {
		return this.lex;
	}
	
}
