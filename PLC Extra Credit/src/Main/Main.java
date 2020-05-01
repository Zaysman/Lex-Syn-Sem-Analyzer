package Main;
//Packages
import Objects.KeywordToken; //Class for all keywordToken
import Objects.Token; //Parent class for all tokens
import Objects.OpToken; //Class for all operation tokens
import Objects.literalToken; //class for all literal tokens
import Objects.IdToken; //Class for all Identifier tokens

//Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Main {

	static File file = new File("Sample input");
	static List<String> lexemes = new LinkedList<String>(); //The list we add our lexemes into
	static int lexemesIndex = 0;

	static List<Token> tokens = new LinkedList<Token>(); //The list we add our tokens into

	static String token = new String(); //global value, every method can see this

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Get Lexemes
		Scanner scan = new Scanner(file);
		String input = new String();


		while(scan.hasNext()) {
			input = scan.next(); //input becomes the next token in the file
			handleString(input);
		}
		scan.close();

		clearEmptySpaces(lexemes);
		printList(lexemes); //here we have our list of lexemes 

		System.out.println();

		//Convert Lexemes into Tokens
		for(int i = 0; i < lexemes.size(); i++) {
			getLexeme();
			System.out.println("Converting Token: " + token);
			convertToken(token);
			
			if(endOfLexemes() == true) { //if we for whatever reason reach the end of our list of lexemes prematurely, we exit this loop.
				break;
			}
		}

		System.out.println();

		printTokens(tokens);

	}

	public static void getLexeme() {
		if(lexemesIndex >= lexemes.size()) {
			return;
		} else {
			token = lexemes.get(lexemesIndex++);
		}
	}
	
	public static String checkNextLexeme() {
		if(lexemesIndex >= (lexemes.size() - 1)) {
			return null;
		} else {
			return lexemes.get(lexemesIndex);
		}
	}
	
	public static boolean endOfLexemes() {
		
		if(lexemesIndex == lexemes.size()) {
			return true;
		}
		
		return false;
	}
	
	//This is another way to acquire a lexeme from our list of lexemes
	public static void getLexeme(String lex) {
		if(lexemesIndex >= lexemes.size()) {
			return;
		} else {
			lex = lexemes.get(lexemesIndex++);
			return;
		}
		
	}

	public static void convertToken(String token) {
		if(checkOperator(token) == true) {
			handleOperator(token);

		} else if(checkKeyword(token) == true) {
			handleKeyword(token);

		} else if(checkLiteral(token) == true) {
			//We don't need to add anything in this block b/c the check literal method has it's own ways of handling different types of literals.
			
		} else if (checkIdentifier(token) == true) {
			//Hand identifiers here
			handleIdentifier(token);
			
		} else {
			System.out.println("The token: " + token + " is an invalid token in our language");
		}

	}

	public static boolean checkOperator(String op) {
		switch(op) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "=":
		case ";":
			return true;
		default:
			return false;
		}
	}

	public static void handleOperator(String op) {
		if(op.compareTo("+") == 0) { //adds addition operator to the list
			OpToken optoken = new OpToken("+");
			tokens.add(optoken);
			return;

		} else if(op.compareTo("-") == 0) { //adds subtraction operator to token list
			OpToken optoken = new OpToken("-");
			tokens.add(optoken);
			return;

		} else if(op.compareTo("*") == 0) { //adds multiplication operator to token list
			OpToken optoken = new OpToken("*");
			tokens.add(optoken);
			return;

		} else if(op.compareTo("/") == 0) { //adds division operator to token list
			OpToken optoken = new OpToken("/");
			tokens.add(optoken);
			return;

		} else if (op.compareTo("=") == 0) {
			OpToken optoken = new OpToken("=");
			tokens.add(optoken);
			return;

		} else if (op.compareTo(";") == 0) {
			OpToken optoken = new OpToken(";");
			tokens.add(optoken);
			return;
		}

	}

	public static boolean checkKeyword(String key) {
		switch(key) {
		case "new":
		case "num":
		case "real":
		case "Sentence":
		case "is":
		case "isnot":
		case "for":
		case "until":
		case "perform":
		case "open":
		case "closed":
		case "empty":
		case "skip":
		case "jump":
		case "jump_out":
		case "bool":
			return true;
		default:
			return false;
		}

	}

	public static void handleKeyword(String key) {
		if(key.compareTo("new") == 0) {
			KeywordToken keytoken = new KeywordToken("new");
			tokens.add(keytoken);

		} else if(key.compareTo("num") == 0) {
			KeywordToken keytoken = new KeywordToken("num");
			tokens.add(keytoken);

		} else if(key.compareTo("real") == 0) {
			KeywordToken keytoken = new KeywordToken("real");
			tokens.add(keytoken);

		} else if(key.compareTo("Sentence") == 0) {
			KeywordToken keytoken = new KeywordToken("Sentence");
			tokens.add(keytoken);

		} else if(key.compareTo("is") == 0) {
			KeywordToken keytoken = new KeywordToken("is");
			tokens.add(keytoken);

		} else if(key.compareTo("isnot") == 0) {
			KeywordToken keytoken = new KeywordToken("isnot");
			tokens.add(keytoken);

		} else if(key.compareTo("for") == 0) {
			KeywordToken keytoken = new KeywordToken("for");
			tokens.add(keytoken);

		} else if(key.compareTo("until") == 0) {
			KeywordToken keytoken = new KeywordToken("until");
			tokens.add(keytoken);

		} else if(key.compareTo("perform") == 0) {
			KeywordToken keytoken = new KeywordToken("perform");
			tokens.add(keytoken);

		} else if(key.compareTo("open") == 0) {
			KeywordToken keytoken = new KeywordToken("open");
			tokens.add(keytoken);

		} else if(key.compareTo("closed") == 0) {
			KeywordToken keytoken = new KeywordToken("closed");
			tokens.add(keytoken);

		} else if(key.compareTo("empty") == 0) {
			KeywordToken keytoken = new KeywordToken("empty");
			tokens.add(keytoken);

		} else if(key.compareTo("skip") == 0) {
			KeywordToken keytoken = new KeywordToken("skip");
			tokens.add(keytoken);

		} else if(key.compareTo("jump") == 0) {
			KeywordToken keytoken = new KeywordToken("jump");
			tokens.add(keytoken);

		} else if(key.compareTo("jump_out") == 0) {
			KeywordToken keytoken = new KeywordToken("jump_out");
			tokens.add(keytoken);
			
		} else if(key.compareTo("bool") == 0) {
			KeywordToken keytoken = new KeywordToken("bool");
			tokens.add(keytoken);

		}
		return;
	}

	public static boolean checkLiteral(String lit) {
		boolean foundBool = false;

		//check boolean literal
		switch(lit) {
		case "true":
		case "false":
			foundBool = true;
		}

		if(foundBool == true) { //If a boolean was found to be true, we can return a true for the method
			handleBooleanLiteral(lit);
			return true;
		}  //If a boolean wasn't found we need to check if its a num (integer) or real (double) value

		if(checkReal(lit) == true) { //check for real
			handleReal(lit);
			return true;

		} else if(checkNum(lit) == true) { //check for num
			handleNum(lit);
			return true;

		} else if(checkSentence(lit) == true) { //check if the lexeme is a string literal
			//The converting of a lexeme into a string literal token is handled inside the checkSentence method. So we just return true here.
			return true;

		} 


		return false;
	}

	public static void handleBooleanLiteral(String lit) {
		if(lit.compareTo("true") == 0) {
			literalToken litToken = new literalToken("true");
			tokens.add(litToken);
			
		} else if(lit.compareTo("false") == 0) {
			literalToken litToken = new literalToken("false");
			tokens.add(litToken);
			
		}
	}

	public static void handleLiteral(String lit) {
		if(lit.compareTo("true") == 0) {
			literalToken litToken = new literalToken("true");
			tokens.add(litToken);

		} else if(lit.compareTo("false") == 0) {
			literalToken litToken = new literalToken("false");
			tokens.add(litToken);

		} else if(checkReal(lit) == true) {
			handleReal(lit);
			//literalToken litToken = new literalToken(lit, "real");
			//tokens.add(litToken);

		} else if(checkNum(lit) == true) {
			literalToken litToken = new literalToken(lit, "num");
			tokens.add(litToken);

		} else if(checkSentence(lit) == true) {
			//create literal token and add to list of tokens
			return; //We'll add this later
		} else {
			return; //If we get here, then the lexeme isn't a literal.
		}


	}

	public static boolean checkReal(String real) {
		char check; //this char variable will hold characters from the passed string

		//check the first character of the string if see if it's true
		check = real.charAt(0);

		//in order to not confused with a potential String, we check to see if the first character is a numeric value. If so, we can move on.
		//If it doesn't then, we know the lexeme does not qualifiy as a real value in our language and thus, we return false
		if(checkNumFirst(check) == false) {
			return false;
		}


		check = real.charAt(real.length() - 1); //check is set to the last character of the string
		//System.out.println("the last character in the string is: " + check);

		if(check == 'r') { //if the last character of the lexeme is 'r', we can assume the lexeme is to be converted to a real_value token
			return true;

		} //If the above isn't true, we need to check for a period to see if the lexeme is a real_value

		//iterates through the string looking for a period.
		for(int i = 0; i < real.length(); i++) { 
			check = real.charAt(i);

			if(check == '.') { //If we encounter a period in our lexeme, at this point we can assume that the lexeme is a real_value token
				return true;
			}	
		}


		//If none of the above statements are true, then our lexeme does not qualifiy as a real_value token and we can move on to check 
		//something else

		return false; 
	}

	public static void handleReal(String real) {
		literalToken realToken = new literalToken(real, "real");
		tokens.add(realToken);

	}

	public static boolean checkNum(String num) {
		char check; //this char variable will hold characters from the passed string

		check = num.charAt(0); // we set check to the first character of the passed string


		//we check to see if the first character of the passed string is a numeric character. If so, we continue on.
		//If not, the lexeme does not qualify as a num_value token in our language. therefore we return false.
		if(checkNumFirst(check) == false) { 
			return false;
		}

		//Since we called check num, we can assume that the lexeme isn't a real_value.
		//We can simply check to make sure all characters in the string are a numeric value to ensure it isn't a string
		for(int i = 0; i < num.length(); i++) {
			check = num.charAt(i);

			//we iterate/traverse through the string to check if all indexes are a numeric value
			//if we find one non-numeric character, the lexeme, 
			if(checkNumFirst(check) == false) {
				return false;
			}
		}

		//If the above for loop iterates to completion, we can assume that the lexeme contained all numeric characters
		//This means we can assume the lexeme is a num_value token and thus return true;
		return true;
	}
	
	public static void handleNum(String lit) {
		literalToken numToken = new literalToken(lit, "num");
		tokens.add(numToken);
		
		
	}

	public static boolean checkNumFirst(char ch) {
		switch(ch) {
		case '0':
		case '1':
		case '2':
		case '3':	
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return true;
		default:
			return false;
		}

	}
	
	public static boolean checkSentence(String str) {
		//s[Hello World];, s[] means that whatever's inside is the string literal we're looking for
		String startStringOp = new String(); 
		
		if(str.compareTo("s") == 0) {
			//System.out.println("This is an s");
			//System.out.println("Next Lexeme: " + checkNextLexeme());
			startStringOp += str;
			
			if(checkNextLexeme().compareTo("[") == 0) {
				//System.out.println("The next lexeme is an open semicolon");
				getLexeme(); //This will grab the open semicolon as the next lexeme
				startStringOp += token;
				
				OpToken op = new OpToken(startStringOp, "start_string");
				tokens.add(op);
				
				String stringLiteral = new String();
				String string = new String();
				getLexeme(); //This should grab the start of the string literal itself
				
				
				while(token.compareTo("]") != 0) {
					string = token;
					stringLiteral += string;
					stringLiteral += " "; //adds a space since individual parts of a string lit are considered lexemes by our lexical analyzer.
					getLexeme();
					if (token.compareTo("]") == 0) {
						break;
					}
					
				}
				
				String endStringbracket = token; //grabs the 
				
				
				System.out.println("String Literal: " + stringLiteral);
				literalToken stringToken = new literalToken(stringLiteral, "string");
				tokens.add(stringToken);
				
				OpToken endStringOp = new OpToken(token, "end_string"); //adds the close bracket
				tokens.add(endStringOp);
				
				
				return true;
			}
			
		}
		
		return false;
	}
	
	public static boolean checkIdentifier(String id) {
		//In our language,an Id cannot start with a number
		
		char check = id.charAt(0);
		
		if(checkNumFirst(check) == true) { //If the first character is a number, then the lexeme doesn't qualify as a valid id in our language.
			return false;
		}
		
		//If we've reached this point, we know that the lexeme doesn't qualify as an operator, keyword, or literal. So we can add them to our
		//list of tokens.
		return true;
	}
	
	public static void handleIdentifier(String id) {
		IdToken idtoken = new IdToken(id);
		tokens.add(idtoken);
	}
	
	

	public static void handleString(String str) {
		if(hasSpecialCharacter(str) == false) {
			lexemes.add(str);
		} else {
			spliceString(str);
		}


	}

	public static void spliceString(String str) { 
		int special = specialCharacterAt(str);
		String substr = str.substring(0, special);
		lexemes.add(substr);

		lexemes.add(Character.toString(str.charAt(special)));
		substr = str.substring(special + 1, str.length());
		handleString(substr);
	}

	/*
	 * The purpose of this method is to determine if a special character exists within a string. If so, returns true. else returns false
	 * 
	 * str - String parameter
	 */

	public static boolean hasSpecialCharacter(String str) {

		for(int i = 0; i < str.length(); i++) {
			if(checkSpecialCharacter(str.charAt(i)) == true) {
				return true;
			}
		}

		return false;
	}

	/*
	 * Assuming a special character has been found within a string, this method finds and returns the index of the first special character found.
	 * 
	 * str - String parameter
	 */

	public static int specialCharacterAt(String str) {

		for(int i = 0; i < str.length(); i++) {
			if(checkSpecialCharacter(str.charAt(i)) == true) {
				return i;
			}
		}

		return -1;
	}

	/*
	 * method that check if the given character is a special character. if so, returns true. else returns false.
	 */

	public static boolean checkSpecialCharacter(char ch) {

		switch(ch) {
		case ';' :
		case '!' :
		case '#' :
		case '"' :
		case '$' :
		case '%' :
		case '&' :
		case '(' :
		case ')' :
		case '*' :
		case '+' :
		case ',' :
		case '-' :
			//case '.' :
		case '/' :
		case ':' :
		case '<' :
		case '=' :
		case '>' :
		case '?' :
		case '@' :
		case '[' :
		case '\\':
		case ']' :
		case '^' :
			//case '_' :
		case '`' :
		case '{' :
		case '}' :
		case '|' :
		case '~' :	
			return true;
		default:
			return false;
		}
	}

	/*
	 * Utility method that prints out the contents of the list of lexemes
	 */
	public static void printList(List list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list(" + i + "): " + list.get(i));
		}
	}

	public static void printTokens(List<Token> tokens) {
		System.out.println("Printing Tokens");
		for(int i = 0; i < tokens.size(); i++) {
			System.out.println("Token(" + i + "): " + tokens.get(i).getType() + ": " + tokens.get(i).getLex());
		}
	}

	/*
	 * Utility that removes any empty spaces in our list just in case
	 */
	public static void clearEmptySpaces(List list) {
		for(int i = 0; i < list.size(); i++) {
			String str = (String) list.get(i);
			if(str.isEmpty() == true) {
				list.remove(i);
				i--;
			}
		}
	}
	
	public static void trimElementsInList(List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).trim();
			
		}
		
	}
}
