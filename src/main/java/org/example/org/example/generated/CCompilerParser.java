// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
package org.example.generated;

    import java.math.BigDecimal;
    import java.util.Map;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CCompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, BOOL=12, DECIMAL=13, STRING=14, ID=15, OP=16, IF=17, 
		ELSE=18, FP=19, LP=20, FK=21, LK=22, OP_ASS=23, COMMA=24, SCOMMA=25, WS=26;
	public static final int
		RULE_prog = 0, RULE_main_function = 1, RULE_function = 2, RULE_function_body = 3, 
		RULE_declaration = 4, RULE_assignment = 5, RULE_expr = 6, RULE_term = 7, 
		RULE_printf_stmt = 8, RULE_factor = 9, RULE_type = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main_function", "function", "function_body", "declaration", 
			"assignment", "expr", "term", "printf_stmt", "factor", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'+'", "'-'", "'*'", "'/'", "'printf'", "'int'", "'bool'", 
			"'decimal'", "'string'", null, null, null, null, null, null, "'if'", 
			"'else'", "'('", "')'", "'{'", "'}'", "'='", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"BOOL", "DECIMAL", "STRING", "ID", "OP", "IF", "ELSE", "FP", "LP", "FK", 
			"LK", "OP_ASS", "COMMA", "SCOMMA", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public static class TypedValue {
	        public enum Kind { INT, BOOL, DECIMAL, STRING }

	        public final Kind kind;
	        public final Integer intVal;
	        public final Boolean boolVal;
	        public final BigDecimal decVal;
	        public final String strVal;

	        public TypedValue(Integer v)    { this.kind = Kind.INT;     this.intVal = v;    this.boolVal = null;    this.decVal = null;     this.strVal = null; }
	        public TypedValue(Boolean v)    { this.kind = Kind.BOOL;    this.intVal = null; this.boolVal = v;       this.decVal = null;     this.strVal = null; }
	        public TypedValue(BigDecimal v) { this.kind = Kind.DECIMAL; this.intVal = null; this.boolVal = null;    this.decVal = v;        this.strVal = null; }
	        public TypedValue(String v)     { this.kind = Kind.STRING;  this.intVal = null; this.boolVal = null;    this.decVal = null;     this.strVal = v;    }

	        @Override
	        public String toString() {
	            switch(kind) {
	                case INT: return intVal.toString();
	                case BOOL: return boolVal.toString();
	                case DECIMAL: return decVal.toPlainString();
	                case STRING: return strVal;
	                default: return "null";
	            }
	        }

	        public BigDecimal asBigDecimal() {
	            switch(kind) {
	                case INT: return new BigDecimal(intVal);
	                case DECIMAL: return decVal;
	                default: throw new RuntimeException("Not a numeric value: " + this);
	            }
	        }
	    }

	    private final Map<String, TypedValue> variables = new HashMap<>();

	    enum TypeKind { INT, BOOL, DECIMAL, STRING }
	    private boolean isNumeric(TypedValue v){
	        return v.kind == TypedValue.Kind.INT || v.kind == TypedValue.Kind.DECIMAL;
	    }

	    private boolean isAssignable(TypeKind declared, TypedValue val) {
	        switch(declared) {
	            case INT: return val.kind == TypedValue.Kind.INT;
	            case BOOL: return val.kind == TypedValue.Kind.BOOL;
	            case DECIMAL: return val.kind == TypedValue.Kind.DECIMAL || val.kind == TypedValue.Kind.INT;
	            case STRING: return val.kind == TypedValue.Kind.STRING;
	            default: return false;
	        }
	    }

	    private boolean isAssignable(TypedValue.Kind declared, TypedValue val) {
	        if (declared == TypedValue.Kind.DECIMAL) {
	            return val.kind == TypedValue.Kind.DECIMAL || val.kind == TypedValue.Kind.INT;
	        }
	        else {
	            return declared == val.kind;
	        }
	    }

	public CCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public Main_functionContext main_function() {
			return getRuleContext(Main_functionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CCompilerParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			main_function();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
				{
				{
				setState(23);
				function();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Main_functionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public TerminalNode FK() { return getToken(CCompilerParser.FK, 0); }
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public TerminalNode LK() { return getToken(CCompilerParser.LK, 0); }
		public Main_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterMain_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitMain_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitMain_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_functionContext main_function() throws RecognitionException {
		Main_functionContext _localctx = new Main_functionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			type();
			setState(32);
			match(T__0);
			setState(33);
			match(FP);
			setState(34);
			match(LP);
			setState(35);
			match(FK);
			setState(36);
			function_body();
			setState(37);
			match(LK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public TerminalNode FK() { return getToken(CCompilerParser.FK, 0); }
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public TerminalNode LK() { return getToken(CCompilerParser.LK, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			type();
			setState(40);
			match(ID);
			setState(41);
			match(FP);
			setState(42);
			match(LP);
			setState(43);
			match(FK);
			setState(44);
			function_body();
			setState(45);
			match(LK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_bodyContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> SCOMMA() { return getTokens(CCompilerParser.SCOMMA); }
		public TerminalNode SCOMMA(int i) {
			return getToken(CCompilerParser.SCOMMA, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<Printf_stmtContext> printf_stmt() {
			return getRuleContexts(Printf_stmtContext.class);
		}
		public Printf_stmtContext printf_stmt(int i) {
			return getRuleContext(Printf_stmtContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterFunction_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitFunction_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunction_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 589760L) != 0)) {
				{
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(47);
					declaration();
					setState(48);
					match(SCOMMA);
					}
					break;
				case 2:
					{
					setState(50);
					assignment();
					setState(51);
					match(SCOMMA);
					}
					break;
				case 3:
					{
					setState(53);
					printf_stmt();
					}
					break;
				case 4:
					{
					setState(54);
					expr();
					setState(55);
					match(SCOMMA);
					}
					break;
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext t;
		public Token id;
		public ExprContext e;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public TerminalNode OP_ASS() { return getToken(CCompilerParser.OP_ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((DeclarationContext)_localctx).t = type();
			setState(63);
			((DeclarationContext)_localctx).id = match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASS) {
				{
				setState(64);
				match(OP_ASS);
				setState(65);
				((DeclarationContext)_localctx).e = expr();
				}
			}


			    String name = ((DeclarationContext)_localctx).id.getText();
			    if (variables.containsKey(name)) {
			        throw new RuntimeException("Variable already declared: '" + name
			            + "' at line " + ((DeclarationContext)_localctx).id.getLine()
			            + ":" + ((DeclarationContext)_localctx).id.getCharPositionInLine()
			        );
			    }

			    TypedValue val = null;
			    if (((DeclarationContext)_localctx).e.value != null) val = ((DeclarationContext)_localctx).e.value;

			    if (val == null) {
			        switch(((DeclarationContext)_localctx).t.typeKind) {
			            case INT: val = new TypedValue(0); break;
			            case BOOL: val = new TypedValue(false); break;
			            case DECIMAL: val = new TypedValue(new BigDecimal("0")); break;
			        }
			    }
			    else {
			        if (!isAssignable(((DeclarationContext)_localctx).t.typeKind, val))
			            throw new RuntimeException("Cannot assign " + val.kind + " to " + ((DeclarationContext)_localctx).t.typeKind);

			        if (((DeclarationContext)_localctx).t.typeKind == TypeKind.DECIMAL && val.kind == TypedValue.Kind.INT)
			            val = new TypedValue(val.asBigDecimal());
			    }

			    variables.put(((DeclarationContext)_localctx).id.getText(), val);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public Token id;
		public ExprContext e;
		public TerminalNode OP_ASS() { return getToken(CCompilerParser.OP_ASS, 0); }
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((AssignmentContext)_localctx).id = match(ID);
			setState(71);
			match(OP_ASS);
			setState(72);
			((AssignmentContext)_localctx).e = expr();

			    TypedValue val = ((AssignmentContext)_localctx).e.value;
			    if (!variables.containsKey(((AssignmentContext)_localctx).id.getText()))
			        throw new RuntimeException("Undefined variable: " + ((AssignmentContext)_localctx).id.getText());

			    TypedValue old = variables.get(((AssignmentContext)_localctx).id.getText());
			    if (old.kind == TypedValue.Kind.DECIMAL && val.kind == TypedValue.Kind.INT)
			        val = new TypedValue(val.asBigDecimal());

			    if (!isAssignable(old.kind, val))
			        throw new RuntimeException("Cannot assign " + val.kind + " to variable of type " + old.kind);

			    variables.put(((AssignmentContext)_localctx).id.getText(), val);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TypedValue value;
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((ExprContext)_localctx).left = term();

			    ((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value;

			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__2) {
				{
				{
				setState(77);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				((ExprContext)_localctx).right = term();

				        if (((ExprContext)_localctx).op.getText().equals("+") &&
				            (_localctx.value.kind == TypedValue.Kind.STRING || ((ExprContext)_localctx).right.value.kind == TypedValue.Kind.STRING)) {
				            String a = _localctx.value.toString();
				            String b = ((ExprContext)_localctx).right.value.toString();
				            ((ExprContext)_localctx).value =  new TypedValue(a + b);
				        } else {
				            if (!isNumeric(_localctx.value) || !isNumeric(((ExprContext)_localctx).right.value))
				              throw new RuntimeException("Operator " + ((ExprContext)_localctx).op.getText() + " requires numeric operands");

				            if (_localctx.value.kind == TypedValue.Kind.DECIMAL || ((ExprContext)_localctx).right.value.kind == TypedValue.Kind.DECIMAL) {
				                BigDecimal a = _localctx.value.asBigDecimal();
				                BigDecimal b = ((ExprContext)_localctx).right.value.asBigDecimal();
				                BigDecimal res = ((ExprContext)_localctx).op.getText().equals("+") ? a.add(b) : a.subtract(b);

				                ((ExprContext)_localctx).value =  new TypedValue(res);
				            }
				            else
				            {
				                int a = _localctx.value.intVal;
				                int b = ((ExprContext)_localctx).right.value.intVal;
				                int r = ((ExprContext)_localctx).op.getText().equals("+") ? (a + b) : (a - b);

				                ((ExprContext)_localctx).value =  new TypedValue(r);
				            }
				        }
				    
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TypedValue value;
		public FactorContext left;
		public Token op;
		public FactorContext right;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((TermContext)_localctx).left = factor();

			    ((TermContext)_localctx).value =  ((TermContext)_localctx).left.value;

			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(88);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				((TermContext)_localctx).right = factor();

				      if (!isNumeric(_localctx.value) || !isNumeric(((TermContext)_localctx).right.value))
				        throw new RuntimeException("Operator " + ((TermContext)_localctx).op.getText() + " requires numeric operands");

				      if (_localctx.value.kind == TypedValue.Kind.DECIMAL || ((TermContext)_localctx).right.value.kind == TypedValue.Kind.DECIMAL) {
				        BigDecimal a = _localctx.value.asBigDecimal();
				        BigDecimal b = ((TermContext)_localctx).right.value.asBigDecimal();
				        BigDecimal res;

				        if (((TermContext)_localctx).op.getText().equals("*")) res = a.multiply(b);
				        else res = a.divide(b, 18, java.math.RoundingMode.HALF_UP); // division scale
				        ((TermContext)_localctx).value =  new TypedValue(res);
				      }
				      else
				      {
				        int a = _localctx.value.intVal;
				        int b = ((TermContext)_localctx).right.value.intVal;
				        int r;

				        if (((TermContext)_localctx).op.getText().equals("*")) r = a * b;
				        else {
				          if (b == 0) throw new RuntimeException("Division by zero");
				          r = a / b;
				        }

				        ((TermContext)_localctx).value =  new TypedValue(r);
				      }
				  
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Printf_stmtContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public TerminalNode SCOMMA() { return getToken(CCompilerParser.SCOMMA, 0); }
		public Printf_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printf_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterPrintf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitPrintf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitPrintf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Printf_stmtContext printf_stmt() throws RecognitionException {
		Printf_stmtContext _localctx = new Printf_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printf_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__5);
			setState(98);
			match(FP);
			setState(99);
			((Printf_stmtContext)_localctx).expr = expr();
			setState(100);
			match(LP);
			setState(101);
			match(SCOMMA);

			    System.out.println(((Printf_stmtContext)_localctx).expr.value);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TypedValue value;
		public Token INT;
		public Token DECIMAL;
		public Token BOOL;
		public Token STRING;
		public Token id;
		public ExprContext e;
		public TerminalNode INT() { return getToken(CCompilerParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CCompilerParser.DECIMAL, 0); }
		public TerminalNode BOOL() { return getToken(CCompilerParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(CCompilerParser.STRING, 0); }
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((FactorContext)_localctx).INT = match(INT);

				    ((FactorContext)_localctx).value =  new TypedValue(Integer.parseInt(((FactorContext)_localctx).INT.getText()));

				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				((FactorContext)_localctx).DECIMAL = match(DECIMAL);

				    ((FactorContext)_localctx).value =  new TypedValue(new BigDecimal(((FactorContext)_localctx).DECIMAL.getText()));

				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				((FactorContext)_localctx).BOOL = match(BOOL);

				    ((FactorContext)_localctx).value =  new TypedValue(Boolean.parseBoolean(((FactorContext)_localctx).BOOL.getText()));

				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				((FactorContext)_localctx).STRING = match(STRING);

				    String raw = ((FactorContext)_localctx).STRING.getText();
				    String inner = raw.substring(1, raw.length() - 1);
				    inner = inner
				        .replace("\\n", "\n")
				        .replace("\\t", "\t")
				        .replace("\\\"", "\"")
				        .replace("\\\\", "\\");

				    ((FactorContext)_localctx).value =  new TypedValue(inner);

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				((FactorContext)_localctx).id = match(ID);

				    String name = ((FactorContext)_localctx).id.getText();
				    if (!variables.containsKey(name)) throw new RuntimeException("Undefined variable: " + name);
				    ((FactorContext)_localctx).value =  variables.get(name);

				}
				break;
			case FP:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				match(FP);
				setState(115);
				((FactorContext)_localctx).e = expr();
				setState(116);
				match(LP);

				    ((FactorContext)_localctx).value =  ((FactorContext)_localctx).e.value;

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeKind typeKind;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__6);
				 ((TypeContext)_localctx).typeKind =  TypeKind.INT; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(T__7);
				 ((TypeContext)_localctx).typeKind =  TypeKind.BOOL; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(T__8);
				 ((TypeContext)_localctx).typeKind =  TypeKind.DECIMAL; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				match(T__9);
				 ((TypeContext)_localctx).typeKind =  TypeKind.STRING; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u0084\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003:\b\u0003\n\u0003\f\u0003=\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004C\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006R\b\u0006\n\u0006\f\u0006U\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007]\b\u0007\n\u0007\f\u0007`\t\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\tx\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0082\b\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0002\u0001\u0000\u0002\u0003"+
		"\u0001\u0000\u0004\u0005\u0088\u0000\u0016\u0001\u0000\u0000\u0000\u0002"+
		"\u001f\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006;"+
		"\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000"+
		"\u0000\fK\u0001\u0000\u0000\u0000\u000eV\u0001\u0000\u0000\u0000\u0010"+
		"a\u0001\u0000\u0000\u0000\u0012w\u0001\u0000\u0000\u0000\u0014\u0081\u0001"+
		"\u0000\u0000\u0000\u0016\u001a\u0003\u0002\u0001\u0000\u0017\u0019\u0003"+
		"\u0004\u0002\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001c\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001"+
		"\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u001a\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001"+
		"\u0000\u0000\u0000\u001f \u0003\u0014\n\u0000 !\u0005\u0001\u0000\u0000"+
		"!\"\u0005\u0013\u0000\u0000\"#\u0005\u0014\u0000\u0000#$\u0005\u0015\u0000"+
		"\u0000$%\u0003\u0006\u0003\u0000%&\u0005\u0016\u0000\u0000&\u0003\u0001"+
		"\u0000\u0000\u0000\'(\u0003\u0014\n\u0000()\u0005\u000f\u0000\u0000)*"+
		"\u0005\u0013\u0000\u0000*+\u0005\u0014\u0000\u0000+,\u0005\u0015\u0000"+
		"\u0000,-\u0003\u0006\u0003\u0000-.\u0005\u0016\u0000\u0000.\u0005\u0001"+
		"\u0000\u0000\u0000/0\u0003\b\u0004\u000001\u0005\u0019\u0000\u00001:\u0001"+
		"\u0000\u0000\u000023\u0003\n\u0005\u000034\u0005\u0019\u0000\u00004:\u0001"+
		"\u0000\u0000\u00005:\u0003\u0010\b\u000067\u0003\f\u0006\u000078\u0005"+
		"\u0019\u0000\u00008:\u0001\u0000\u0000\u00009/\u0001\u0000\u0000\u0000"+
		"92\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u000096\u0001\u0000\u0000"+
		"\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<\u0007\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">?\u0003\u0014\n\u0000?B\u0005\u000f\u0000\u0000@A\u0005\u0017\u0000\u0000"+
		"AC\u0003\f\u0006\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DE\u0006\u0004\uffff\uffff\u0000E\t\u0001\u0000"+
		"\u0000\u0000FG\u0005\u000f\u0000\u0000GH\u0005\u0017\u0000\u0000HI\u0003"+
		"\f\u0006\u0000IJ\u0006\u0005\uffff\uffff\u0000J\u000b\u0001\u0000\u0000"+
		"\u0000KL\u0003\u000e\u0007\u0000LS\u0006\u0006\uffff\uffff\u0000MN\u0007"+
		"\u0000\u0000\u0000NO\u0003\u000e\u0007\u0000OP\u0006\u0006\uffff\uffff"+
		"\u0000PR\u0001\u0000\u0000\u0000QM\u0001\u0000\u0000\u0000RU\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\r\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0003\u0012\t\u0000W^\u0006"+
		"\u0007\uffff\uffff\u0000XY\u0007\u0001\u0000\u0000YZ\u0003\u0012\t\u0000"+
		"Z[\u0006\u0007\uffff\uffff\u0000[]\u0001\u0000\u0000\u0000\\X\u0001\u0000"+
		"\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_\u000f\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000ab\u0005\u0006\u0000\u0000bc\u0005\u0013\u0000\u0000cd\u0003\f\u0006"+
		"\u0000de\u0005\u0014\u0000\u0000ef\u0005\u0019\u0000\u0000fg\u0006\b\uffff"+
		"\uffff\u0000g\u0011\u0001\u0000\u0000\u0000hi\u0005\u000b\u0000\u0000"+
		"ix\u0006\t\uffff\uffff\u0000jk\u0005\r\u0000\u0000kx\u0006\t\uffff\uffff"+
		"\u0000lm\u0005\f\u0000\u0000mx\u0006\t\uffff\uffff\u0000no\u0005\u000e"+
		"\u0000\u0000ox\u0006\t\uffff\uffff\u0000pq\u0005\u000f\u0000\u0000qx\u0006"+
		"\t\uffff\uffff\u0000rs\u0005\u0013\u0000\u0000st\u0003\f\u0006\u0000t"+
		"u\u0005\u0014\u0000\u0000uv\u0006\t\uffff\uffff\u0000vx\u0001\u0000\u0000"+
		"\u0000wh\u0001\u0000\u0000\u0000wj\u0001\u0000\u0000\u0000wl\u0001\u0000"+
		"\u0000\u0000wn\u0001\u0000\u0000\u0000wp\u0001\u0000\u0000\u0000wr\u0001"+
		"\u0000\u0000\u0000x\u0013\u0001\u0000\u0000\u0000yz\u0005\u0007\u0000"+
		"\u0000z\u0082\u0006\n\uffff\uffff\u0000{|\u0005\b\u0000\u0000|\u0082\u0006"+
		"\n\uffff\uffff\u0000}~\u0005\t\u0000\u0000~\u0082\u0006\n\uffff\uffff"+
		"\u0000\u007f\u0080\u0005\n\u0000\u0000\u0080\u0082\u0006\n\uffff\uffff"+
		"\u0000\u0081y\u0001\u0000\u0000\u0000\u0081{\u0001\u0000\u0000\u0000\u0081"+
		"}\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0015"+
		"\u0001\u0000\u0000\u0000\b\u001a9;BS^w\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}