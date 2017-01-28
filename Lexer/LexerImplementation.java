import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class LexerImplementation implements Lexer,Token {

    @Override
    public List<Token> lex(String input) throws LexicalException, Task1Exception {
        ArrayList<Token> tokens = new ArrayList();
        Pattern lang = Pattern.compile("\\p{Space}|(<=)|(>=)|(:=)|[;,\\(\\){}<>\\+\\-\\*/]|={2}|=|[a-z]+\\w*|(\\d+)|.*");
        Pattern ident = Pattern.compile("[a-z]+\\w*");
        Pattern spaces = Pattern.compile("[\\s]");
        
        Matcher m = lang.matcher(input);
        while(m.find()){
            if(m.group().matches("$")) {
                break;
            }
            else if(m.group().equals(";")){
                tokens.add(new T_Semicolon());
            }
            else if(m.group().equals("(")){
                tokens.add(new T_LeftBracket());
            }
            else if(m.group().equals(")")){
                tokens.add(new T_RightBracket());
            }
            else if(m.group().equals("=")){
                tokens.add(new T_EqualDefines());
            }
            else if(m.group().equals("==")){
                tokens.add(new T_Equal());
            }
            else if(m.group().equals("<")){
                tokens.add(new T_LessThan());
            }
            else if(m.group().equals(">")){
                tokens.add(new T_GreaterThan());
            }
            else if(m.group().equals("<=")){
                tokens.add(new T_LessEq());
            }
            else if(m.group().equals(">=")){
                tokens.add(new T_GreaterEq());
            }
            else if(m.group().equals(",")){
                tokens.add(new T_Comma());
            }
            else if(m.group().equals("{")){
                tokens.add(new T_LeftCurlyBracket());
            }
            else if(m.group().equals("}")){
                tokens.add(new T_RightCurlyBracket());
            }
            else if(m.group().equals(":=")){
                tokens.add(new T_Assign());
            }
            else if(m.group().equals("+")){
                tokens.add(new T_Plus());
            }
            else if(m.group().equals("*")){
                tokens.add(new T_Times());
            }
            else if(m.group().equals("-")){
                tokens.add(new T_Minus());
            }
            else if(m.group().equals("/")){
                tokens.add(new T_Div());
            }
            else if(m.group().equals("def")){
                tokens.add(new T_Def()); 
            }
            else if(m.group().equals("skip")){
                tokens.add(new T_Skip());
            }
            else if(m.group().equals("if")){
                tokens.add(new T_If());
            }
            else if(m.group().equals("then")){
                tokens.add(new T_Then());
            }
            else if(m.group().equals("else")){
                tokens.add(new T_Else());
            }
            else if(m.group().equals("while")){
                tokens.add(new T_While());
            }
            else if(m.group().equals("do")){
                tokens.add(new T_Do());
            }
            else if(m.group().equals("repeat")){
                tokens.add(new T_Repeat());
            }
            else if(m.group().equals("until")){
                tokens.add(new T_Until());
            }
            else if(m.group().equals("break")){
                tokens.add(new T_Break());
            }
            else if(m.group().equals("continue")){
                tokens.add(new T_Continue());
            }
            else if(Pattern.compile("\\d+").matcher(m.group()).matches()){
                tokens.add(new T_Integer(parseInt(m.group())));
            }
            else if(ident.matcher(m.group()).matches()){
                tokens.add(new T_Identifier(m.group()));
            }
            else if(spaces.matcher(m.group()).matches()){  
            }
            else{
                throw new LexicalException("incorrect input");
            }
           
        }

        return tokens;
        
        
        
    }
}

