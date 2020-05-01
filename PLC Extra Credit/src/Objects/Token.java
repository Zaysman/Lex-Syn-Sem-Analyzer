package Objects;

public class Token {

	int code; //every token in our analyzer will have a code.
	String type;
	String lex; //The lexeme that converted into the token

	public int getCode() {
		return this.code;
	}


	public String getType() {
		return this.type;
	}
	
	public String getLex() {
		return this.lex;
	}

}
