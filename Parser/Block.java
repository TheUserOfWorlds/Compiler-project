import java.util.List;

class Block {
    public List <Exp> exps;
    public Block ( List <Exp> _exps ) {
	assert ( _exps.size () > 0 );
	exps = _exps; } }

abstract class Exp {} 

class IntLiteral extends Exp { 
    public int n;
    IntLiteral ( int _n ) { n = _n; } }

class Skip extends Exp { 
    public Skip () {} }

class BlockExp extends Exp { 
    public Block b;
    public BlockExp ( Block _b ) { b = _b; } }

