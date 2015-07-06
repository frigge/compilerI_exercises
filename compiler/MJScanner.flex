package minijava; // The generated parser will belong to this package 

import minijava.MJParser.Terminals; 
// The terminals are implicitly defined in the parser
%%

// define the signature for the generated scanner
%public
%final
%class MJScanner 
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 
%yylexthrow beaver.Scanner.Exception
%eofval{
	return new beaver.Symbol(Terminals.EOF, "end-of-file");
%eofval}

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

kw_class = class
kw_public = public
kw_static = static
kw_void = void
kw_while = while
kw_if = if
kw_else = else
kw_extends = extends
kw_return = return
kw_System_out_println = System\.out\.println
kw_this = this
kw_new = new
kw_main = main

t_String = String
t_int = int
t_boolean = boolean

sym_open = \(
sym_open_square = \[
sym_open_curly = \{
sym_close = \)
sym_close_square = \]
sym_close_curly = \}
sym_semicolon = ;
sym_comma = ,
sym_equals = =
sym_dot_len = \.length
sym_dot = \.
sym_exclam = \!
sym_logic_and = &&
sym_plus = \+
sym_minus = -
sym_mult = \*
sym_less = <

c_true  = true 
c_false = false
integer_lit = \d+
ident = [a-zA-Z](\d|\w)*
%%

{WhiteSpace}  { }
{sym_open} { return sym(Terminals.sym_open); }
{sym_open_square} { return sym(Terminals.sym_open_square); }
{sym_open_curly} { return sym(Terminals.sym_open_curly); }
{sym_close} { return sym(Terminals.sym_close); }
{sym_close_square} { return sym(Terminals.sym_close_square); }
{sym_close_curly} { return sym(Terminals.sym_close_curly); }
{sym_comma} { return sym(Terminals.sym_comma); }
{sym_semicolon} { return sym(Terminals.sym_semicolon); }
{sym_equals} { return sym(Terminals.sym_equals); }
{sym_dot_len} { return sym(Terminals.sym_dot_len); }
{sym_dot} { return sym(Terminals.sym_dot); }
{sym_exclam} { return sym(Terminals.sym_exclam); }
{sym_logic_and} { return sym(Terminals.sym_logic_and); }
{sym_plus} { return sym(Terminals.sym_plus); }
{sym_minus} { return sym(Terminals.sym_minus); }
{sym_mult} { return sym(Terminals.sym_mult); }
{sym_less} { return sym(Terminals.sym_less); }

{kw_class} { return sym(Terminals.kw_class); }
{kw_public} { return sym(Terminals.kw_public); }
{kw_static} { return sym(Terminals.kw_static); }
{kw_void} { return sym(Terminals.kw_void); }
{kw_while} { return sym(Terminals.kw_while); }
{kw_if} { return sym(Terminals.kw_if); }
{kw_else} { return sym(Terminals.kw_else); }
{kw_extends} { return sym(Terminals.kw_extends); }
{kw_return} { return sym(Terminals.kw_return); }
{kw_System_out_println} { return sym(Terminals.kw_System_out_println); }
{kw_this} { return sym(Terminals.kw_this); }
{kw_new} { return sym(Terminals.kw_new); }
{kw_main} { return sym(Terminals.kw_main); }

{t_String} { return sym(Terminals.t_String); }
{t_int} { return sym(Terminals.t_int); }
{t_boolean} { return sym(Terminals.t_boolean); }

{c_true } { return sym(Terminals.c_true ); }
{c_false} { return sym(Terminals.c_false); }
{integer_lit} { return sym(Terminals.integer_lit); }
{ident} { return sym(Terminals.ident); }

// fall through errors
.            { throw new beaver.Scanner.Exception("illegal character \"" + yytext() + "\" at line " + yyline + "," + yycolumn); }
