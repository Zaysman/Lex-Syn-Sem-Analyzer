package Objects;
import Objects.Token;



/*
 * This class is for operator tokens in our programming language
 */
public class OpToken extends Token {

	
	/*
	 * Constructor
	 */
	public OpToken(String op) {
		if(op.compareTo("+") == 0) {
			this.type = "add_op";
			this.code = 0;
			this.lex = op;
					
		} else if(op.compareTo("-") == 0) {
			this.type = "sub_op";
			this.code = 1;
			this.lex = op;

		} else if(op.compareTo("*") == 0) {
			this.type = "multi_op";
			this.code = 2;
			this.lex = op;

		} else if(op.compareTo("/") == 0) {
			this.type = "divis_op";
			this.code = 3;
			this.lex = op;
			
		} else if(op.compareTo("=") == 0) {
			this.type = "assign_op";
			this.code = 99; //will be reassign later.
			this.lex = op;
			
		} else if(op.compareTo(";") == 0) {
			this.type = "end_statement_op";
			this.code = 102; //will reassign later
			this.lex = op;
		}

	}
	
	public OpToken(String op, String str) {
		if(str.compareTo("start_string") == 0) {
			this.type = "start_string_op";
			this.code = 100; //will reassign later.
			this.lex = op;
		} else if (str.compareTo("end_string") == 0) {
			this.type = "end_string_op";
			this.code = 101; //will reassign later
			this.lex = op;
		}
		
	}
	
	/*
	public String getType() {
		return this.type;
	}
	
	public int getCode() {
		return this.code;
	}
	*/
}
