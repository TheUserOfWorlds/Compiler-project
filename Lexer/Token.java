interface Token {
    

class T_Semicolon implements Token {}
class T_LeftBracket implements Token {}
class T_RightBracket implements Token {}
class T_EqualDefines implements Token {} 
class T_Equal implements Token {} 
class T_LessThan implements Token {} 
class T_GreaterThan implements Token {} 
class T_LessEq implements Token {} 
class T_GreaterEq implements Token {} 
class T_Comma implements Token {} 
class T_LeftCurlyBracket implements Token {} 
class T_RightCurlyBracket implements Token {} 
class T_Assign implements Token {} 
class T_Plus implements Token {} 
class T_Times implements Token {} 
class T_Minus implements Token {} 
class T_Div implements Token {} 
class T_Identifier implements Token { 
    public String s;
    public T_Identifier ( String _s ) { s = _s; } }
class T_Integer implements Token { 
    public int n;
    public T_Integer ( int _n ) { n = _n; } }
class T_Def implements Token {} 
class T_Skip implements Token {} 
class T_If implements Token {} 
class T_Then implements Token {} 
class T_Else implements Token {} 
class T_While implements Token {} 
class T_Do implements Token {} 
class T_Repeat implements Token {} 
class T_Until implements Token {} 
class T_Break implements Token {} 
class T_Continue implements Token {} 

class T_EOF implements Token {} 
class T_Error implements Token {
    public String msg;
    public T_Error ( String _msg ) { msg = _msg; } }

}
