package Objects;
import Objects.Token;

public class KeywordToken extends Token {

	private String type; //Holds what type of string we're working with
	
	/*
	 * public constructor
	 */
	
	public KeywordToken(String key) {
		if(key.compareTo("new") == 0) {
			this.type = "new_keyword";
			this.code = 4;
			this.lex = key;
			
		} else if(key.compareTo("num") == 0) {
			this.type = "num_keyword";
			this.code = 5;
			this.lex = key;
			
		} else if(key.compareTo("real") == 0) {
			this.type = "real_keyword";
			this.code = 6;
			this.lex = key;
			
		} else if(key.compareTo("Sentence") == 0) {
			this.type = "sentence_keyword";
			this.code = 7;
			this.lex = key;
			
		} else if(key.compareTo("is") == 0) {
			this.type = "is_keyword";
			this.code = 8;
			this.lex = key;
			
		} else if(key.compareTo("isnot") == 0) {
			this.type = "is_not_key";
			this.code = 9;
			this.lex = key;
			
		} else if(key.compareTo("for") == 0) {
			this.type = "for_keyword";
			this.code = 10;
			this.lex = key;
			
		} else if(key.compareTo("until") == 0) {
			this.type = "until_keyword";
			this.code = 11;
			this.lex = key;
			
		} else if(key.compareTo("perform") == 0) {
			this.type = "perform_keyword";
			this.code = 12;
			this.lex = key;
			
		} else if(key.compareTo("open") == 0) {
			this.type = "open_keyword";
			this.code = 13;
			this.lex = key;
			
		} else if(key.compareTo("closed") == 0) {
			this.type = "closed_keyword";
			this.code = 14;
			this.lex = key;
			
		} else if(key.compareTo("empty") == 0) {
			this.type = "empty_keyword";
			this.code = 15;
			this.lex = key;
			
		} else if(key.compareTo("skip") == 0) {
			this.type = "skip_keyword";
			this.code = 16;
			this.lex = key;
			
		} else if(key.compareTo("jump") == 0) {
			this.type = "jump_keyword";
			this.code = 17;
			this.lex = key;
			
		} else if(key.compareTo("jump_out") == 0) {
			this.type = "jump_out_keyword";
			this.code = 18;
			this.lex = key;
			
		} else if(key.compareTo("bool") == 0) {
			this.type = "bool_keyword";
			this.code = 19;
			this.lex = key;
			
		}
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
