import java.util.ArrayList;
import java.util.List;

class ParserImplementation implements Parser,Token {
    
    int j = 0;

    @Override
    public Block parse(List<Token> input) throws SyntaxException, Task2Exception {
        ArrayList <Exp> parseList = new ArrayList();
                 if(input.get(j) instanceof T_LeftCurlyBracket){
                        if(input.get(j+1) instanceof T_Skip || input.get(j+1) instanceof T_Integer){
                            j++;  
                        }
                        else{
                            throw new SyntaxException("Invalid input");
                        }
                    }
                while(true){
                    
                    if(input.get(j) instanceof T_Skip){
                        if(input.get(j+1) instanceof T_RightCurlyBracket || input.get(j+1) instanceof T_Semicolon){
                            parseList.add(new Skip());
                            j++;
                        }
                        else{
                            throw new SyntaxException("Invalid input");
                        }
                    }
                    else if(input.get(j) instanceof T_Integer){
                        if(input.get(j+1) instanceof T_RightCurlyBracket || input.get(j+1) instanceof T_Semicolon){               
                            parseList.add(new IntLiteral(((T_Integer)input.get(j)).n));
                            j++;
                        }
                        else{
                            throw new SyntaxException("Invalid input");
                        }
                    }
                    else if(input.get(j) instanceof T_Semicolon){
                        if(input.get(j+1) instanceof T_LeftCurlyBracket || input.get(j+1) instanceof T_Integer || input.get(j+1) instanceof T_Skip){
                           j++; 
                        }
                        else{
                            throw new SyntaxException("Invalid input");
                        }
                    }
                    else if(input.get(j) instanceof T_LeftCurlyBracket){
                        if(input.get(j+1) instanceof T_Skip || input.get(j+1) instanceof T_Integer){
                            parseList.add(new BlockExp(parse(input)));
                            j++;
                        }
                        else{
                            throw new SyntaxException("Invalid input");
                        }
                    }
                    else if(input.get(j) instanceof T_RightCurlyBracket){
                        return new Block(parseList);
                    }
                    else{
                        throw new SyntaxException("Invalid input");
                    }
                }
                
            }
        }
    
    
    
    

