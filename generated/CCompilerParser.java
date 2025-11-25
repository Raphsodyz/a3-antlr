// Generated from CCompiler.g4 by ANTLR 4.13.2
package generated;

    import java.math.BigDecimal;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.function.Supplier;

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
		T__9=10, INT=11, BOOL=12, DECIMAL=13, STRING=14, IF=15, ELSE=16, EQ=17, 
		GT=18, LT=19, ID=20, OP=21, FP=22, LP=23, FK=24, LK=25, OP_ASS=26, COMMA=27, 
		SCOMMA=28, WS=29;
	public static final int
		RULE_prog = 0, RULE_main_function = 1, RULE_function = 2, RULE_statement = 3, 
		RULE_function_body = 4, RULE_block = 5, RULE_if_stmt = 6, RULE_declaration = 7, 
		RULE_assignment = 8, RULE_printf_stmt = 9, RULE_expr = 10, RULE_compare = 11, 
		RULE_add = 12, RULE_term = 13, RULE_factor = 14, RULE_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main_function", "function", "statement", "function_body", "block", 
			"if_stmt", "declaration", "assignment", "printf_stmt", "expr", "compare", 
			"add", "term", "factor", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'printf'", "'+'", "'-'", "'*'", "'/'", "'int'", "'bool'", 
			"'decimal'", "'string'", null, null, null, null, "'if'", "'else'", "'=='", 
			"'>'", "'<'", null, null, "'('", "')'", "'{'", "'}'", "'='", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"BOOL", "DECIMAL", "STRING", "IF", "ELSE", "EQ", "GT", "LT", "ID", "OP", 
			"FP", "LP", "FK", "LK", "OP_ASS", "COMMA", "SCOMMA", "WS"
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
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			main_function();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) {
				{
				{
				setState(33);
				function();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
	}

	public final Main_functionContext main_function() throws RecognitionException {
		Main_functionContext _localctx = new Main_functionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			type();
			setState(42);
			match(T__0);
			setState(43);
			match(FP);
			setState(44);
			match(LP);
			setState(45);
			match(FK);
			setState(46);
			function_body();
			setState(47);
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
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			type();
			setState(50);
			match(ID);
			setState(51);
			match(FP);
			setState(52);
			match(LP);
			setState(53);
			match(FK);
			setState(54);
			function_body();
			setState(55);
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
	public static class StatementContext extends ParserRuleContext {
		public Runnable action;
		public DeclarationContext d;
		public AssignmentContext a;
		public Printf_stmtContext p;
		public ExprContext e;
		public If_stmtContext i;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Printf_stmtContext printf_stmt() {
			return getRuleContext(Printf_stmtContext.class,0);
		}
		public TerminalNode SCOMMA() { return getToken(CCompilerParser.SCOMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((StatementContext)_localctx).d = declaration();
				 ((StatementContext)_localctx).action =  ((StatementContext)_localctx).d.action; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((StatementContext)_localctx).a = assignment();
				 ((StatementContext)_localctx).action =  ((StatementContext)_localctx).a.action; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				((StatementContext)_localctx).p = printf_stmt();
				 ((StatementContext)_localctx).action =  ((StatementContext)_localctx).p.action; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				((StatementContext)_localctx).e = expr();
				setState(67);
				match(SCOMMA);
				 ((StatementContext)_localctx).action =  null; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				((StatementContext)_localctx).i = if_stmt();
				 ((StatementContext)_localctx).action =  ((StatementContext)_localctx).i.action; 
				}
				break;
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
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SCOMMA() { return getTokens(CCompilerParser.SCOMMA); }
		public TerminalNode SCOMMA(int i) {
			return getToken(CCompilerParser.SCOMMA, i);
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
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5308292L) != 0)) {
				{
				{
				setState(75);
				((Function_bodyContext)_localctx).statement = statement();
				((Function_bodyContext)_localctx).st.add(((Function_bodyContext)_localctx).statement);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SCOMMA) {
					{
					setState(76);
					match(SCOMMA);
					}
				}

				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			    if (((Function_bodyContext)_localctx).st != null) {
			        for (int i = 0; i < ((Function_bodyContext)_localctx).st.size(); ++i) {
			            Runnable r = ((Function_bodyContext)_localctx).st.get(i).action;
			            if (r != null) r.run();
			        }
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
	public static class BlockContext extends ParserRuleContext {
		public java.util.List<Runnable> actions;
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public TerminalNode FK() { return getToken(CCompilerParser.FK, 0); }
		public TerminalNode LK() { return getToken(CCompilerParser.LK, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SCOMMA() { return getTokens(CCompilerParser.SCOMMA); }
		public TerminalNode SCOMMA(int i) {
			return getToken(CCompilerParser.SCOMMA, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FK);

			        ((BlockContext)_localctx).actions =  new java.util.ArrayList<Runnable>();
			    
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5308292L) != 0)) {
				{
				{
				setState(88);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).st.add(((BlockContext)_localctx).statement);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SCOMMA) {
					{
					setState(89);
					match(SCOMMA);
					}
				}


				            if (((BlockContext)_localctx).st.get(((BlockContext)_localctx).st.size()-1).action != null) _localctx.actions.add(((BlockContext)_localctx).st.get(((BlockContext)_localctx).st.size()-1).action);
				        
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
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
	public static class If_stmtContext extends ParserRuleContext {
		public Runnable action;
		public Token IF;
		public ExprContext cond;
		public BlockContext thenBlock;
		public BlockContext elseBlock;
		public TerminalNode IF() { return getToken(CCompilerParser.IF, 0); }
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CCompilerParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((If_stmtContext)_localctx).IF = match(IF);
			setState(102);
			match(FP);
			setState(103);
			((If_stmtContext)_localctx).cond = expr();
			setState(104);
			match(LP);
			setState(105);
			((If_stmtContext)_localctx).thenBlock = block();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(106);
				match(ELSE);
				setState(107);
				((If_stmtContext)_localctx).elseBlock = block();
				}
			}


			    final Supplier<TypedValue> condSupplier = ((If_stmtContext)_localctx).cond.value;
			    final java.util.List<Runnable> thenActions = ((If_stmtContext)_localctx).thenBlock.actions;
			    final java.util.List<Runnable> elseActions = (((If_stmtContext)_localctx).elseBlock.actions != null ? ((If_stmtContext)_localctx).elseBlock.actions : null);
			    final int line = ((If_stmtContext)_localctx).IF.getLine();
			    final int pos = ((If_stmtContext)_localctx).IF.getCharPositionInLine();

			    ((If_stmtContext)_localctx).action =  new Runnable() {
			        public void run() {
			            TypedValue conditionValue = condSupplier.get();
			            if (conditionValue == null || conditionValue.kind != TypedValue.Kind.BOOL)
			                throw new RuntimeException("if condition must be boolean at line " + line + ":" + pos);

			            boolean c = conditionValue.boolVal;
			            java.util.List<Runnable> toRun = c ? thenActions : elseActions;
			            if (toRun != null) {
			                for (Runnable r : toRun) {
			                    r.run();
			                }
			            }
			        }
			    };

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
		public Runnable action;
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
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			((DeclarationContext)_localctx).t = type();
			setState(113);
			((DeclarationContext)_localctx).id = match(ID);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASS) {
				{
				setState(114);
				match(OP_ASS);
				setState(115);
				((DeclarationContext)_localctx).e = expr();
				}
			}


			    final String name = ((DeclarationContext)_localctx).id.getText();
			    final TypeKind typeKind = ((DeclarationContext)_localctx).t.typeKind;
			    final Supplier<TypedValue> initSupplier = (((DeclarationContext)_localctx).e.value != null ? ((DeclarationContext)_localctx).e.value : null);
			    final int line = ((DeclarationContext)_localctx).id.getLine();
			    final int pos = ((DeclarationContext)_localctx).id.getCharPositionInLine();

			    ((DeclarationContext)_localctx).action =  new Runnable() {
			        public void run() {
			            if (variables.containsKey(name)) {
			                throw new RuntimeException("Variable already declared: '" + name
			                    + "' at line " + line
			                    + ":" + pos
			                );
			            }

			            TypedValue val = null;
			            if (initSupplier != null) {
			                val = initSupplier.get();
			            }

			            if (val == null) {
			                switch(typeKind) {
			                    case INT: val = new TypedValue(0); break;
			                    case BOOL: val = new TypedValue(false); break;
			                    case DECIMAL: val = new TypedValue(new BigDecimal("0")); break;
			                    case STRING: val = new TypedValue(""); break;
			                }
			            } else {
			                if (!isAssignable(typeKind, val))
			                    throw new RuntimeException("Cannot assign " + val.kind + " to " + typeKind);

			                if (typeKind == TypeKind.DECIMAL && val.kind == TypedValue.Kind.INT)
			                    val = new TypedValue(val.asBigDecimal());
			            }

			            variables.put(name, val);
			        }
			    };

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
		public Runnable action;
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			((AssignmentContext)_localctx).id = match(ID);
			setState(121);
			match(OP_ASS);
			setState(122);
			((AssignmentContext)_localctx).e = expr();

			    final String name = ((AssignmentContext)_localctx).id.getText();
			    final Supplier<TypedValue> rvalSupplier = ((AssignmentContext)_localctx).e.value;
			    final int line = ((AssignmentContext)_localctx).id.getLine();
			    final int pos = ((AssignmentContext)_localctx).id.getCharPositionInLine();

			    ((AssignmentContext)_localctx).action =  new Runnable() {
			        public void run() {
			            if (!variables.containsKey(name))
			                throw new RuntimeException("Undefined variable: " + name + " at line " + line + ":" + pos);

			            TypedValue val = rvalSupplier.get();
			            TypedValue old = variables.get(name);

			            if (old.kind == TypedValue.Kind.DECIMAL && val.kind == TypedValue.Kind.INT)
			                val = new TypedValue(val.asBigDecimal());

			            if (!isAssignable(old.kind, val))
			                throw new RuntimeException("Cannot assign " + val.kind + " to variable of type " + old.kind);

			            variables.put(name, val);
			        }
			    };

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
		public Runnable action;
		public ExprContext e;
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
	}

	public final Printf_stmtContext printf_stmt() throws RecognitionException {
		Printf_stmtContext _localctx = new Printf_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printf_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__1);
			setState(126);
			match(FP);
			setState(127);
			((Printf_stmtContext)_localctx).e = expr();
			setState(128);
			match(LP);

			    final Supplier<TypedValue> vSupplier = ((Printf_stmtContext)_localctx).e.value;
			    ((Printf_stmtContext)_localctx).action =  new Runnable() {
			        public void run() {
			            TypedValue v = vSupplier.get();
			            System.out.println(v);
			        }
			    };

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
		public Supplier<TypedValue> value;
		public CompareContext left;
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			((ExprContext)_localctx).left = compare();

			    ((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value;

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
	public static class CompareContext extends ParserRuleContext {
		public Supplier<TypedValue> value;
		public AddContext left;
		public Token op;
		public AddContext right;
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(CCompilerParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(CCompilerParser.EQ, i);
		}
		public List<TerminalNode> GT() { return getTokens(CCompilerParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(CCompilerParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(CCompilerParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(CCompilerParser.LT, i);
		}
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitCompare(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((CompareContext)_localctx).left = add();

			    ((CompareContext)_localctx).value =  ((CompareContext)_localctx).left.value;
			    
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) {
				{
				{
				setState(136);
				((CompareContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) ) {
					((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(137);
				((CompareContext)_localctx).right = add();

				    final Supplier<TypedValue> leftSup = _localctx.value;
				    final Supplier<TypedValue> rightSup = ((CompareContext)_localctx).right.value;
				    final String operator = ((CompareContext)_localctx).op.getText();

				    ((CompareContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() {
				        TypedValue l = leftSup.get();
				        TypedValue r = rightSup.get();

				        if (operator.equals("==")) {
				            if (l.kind == r.kind) {
				                switch (l.kind) {
				                    case INT:   return new TypedValue(l.intVal.equals(r.intVal));
				                    case BOOL:  return new TypedValue(l.boolVal.equals(r.boolVal));
				                    case DECIMAL: return new TypedValue(l.asBigDecimal().compareTo(r.asBigDecimal()) == 0);
				                    case STRING: return new TypedValue(l.strVal.equals(r.strVal));
				                }
				            }

				            if ((l.kind == TypedValue.Kind.INT && r.kind == TypedValue.Kind.DECIMAL) ||
				                (l.kind == TypedValue.Kind.DECIMAL && r.kind == TypedValue.Kind.INT)) {
				                return new TypedValue(l.asBigDecimal().compareTo(r.asBigDecimal()) == 0);
				            }

				            throw new RuntimeException("Operator == not supported for operands: " + l.kind + " and " + r.kind);
				        }

				        if (operator.equals(">") || operator.equals("<")) {
				            if ( (l.kind == TypedValue.Kind.INT || l.kind == TypedValue.Kind.DECIMAL)
				                && (r.kind == TypedValue.Kind.INT || r.kind == TypedValue.Kind.DECIMAL) ) {
				                BigDecimal a = l.asBigDecimal();
				                BigDecimal b = r.asBigDecimal();
				                int cmp = a.compareTo(b);
				                boolean res = operator.equals(">") ? (cmp > 0) : (cmp < 0);
				                return new TypedValue(res);
				            }

				            if (l.kind == TypedValue.Kind.STRING && r.kind == TypedValue.Kind.STRING) {
				                int cmp = l.strVal.compareTo(r.strVal);
				                boolean res = operator.equals(">") ? (cmp > 0) : (cmp < 0);
				                return new TypedValue(res);
				            }

				            throw new RuntimeException("Operator " + operator + " requires numeric or string operands");
				        }

				        throw new RuntimeException("Unknown comparison operator: " + operator);
				        }
				    };
				    
				}
				}
				setState(144);
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
	public static class AddContext extends ParserRuleContext {
		public Supplier<TypedValue> value;
		public TermContext left;
		public Token op;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((AddContext)_localctx).left = term();

			    ((AddContext)_localctx).value =  ((AddContext)_localctx).left.value;

			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(147);
				((AddContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
					((AddContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				((AddContext)_localctx).right = term();

				        final Supplier<TypedValue> leftSup = _localctx.value;
				        final Supplier<TypedValue> rightSup = ((AddContext)_localctx).right.value;
				        final String operator = ((AddContext)_localctx).op.getText();

				        ((AddContext)_localctx).value =  new Supplier<TypedValue>() {
				            public TypedValue get() {
				                TypedValue l = leftSup.get();
				                TypedValue r = rightSup.get();

				                if (operator.equals("+") &&
				                    (l.kind == TypedValue.Kind.STRING || r.kind == TypedValue.Kind.STRING)) {
				                    String a = l.toString();
				                    String b = r.toString();
				                    return new TypedValue(a + b);
				                } else {
				                    if (!isNumeric(l) || !isNumeric(r))
				                        throw new RuntimeException("Operator " + operator + " requires numeric operands");

				                    if (l.kind == TypedValue.Kind.DECIMAL || r.kind == TypedValue.Kind.DECIMAL) {
				                        BigDecimal a = l.asBigDecimal();
				                        BigDecimal b = r.asBigDecimal();
				                        BigDecimal res = operator.equals("+") ? a.add(b) : a.subtract(b);
				                        return new TypedValue(res);
				                    } else {
				                        int a = l.intVal;
				                        int b = r.intVal;
				                        int rr = operator.equals("+") ? (a + b) : (a - b);
				                        return new TypedValue(rr);
				                    }
				                }
				            }
				        };
				    
				}
				}
				setState(155);
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
		public Supplier<TypedValue> value;
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
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			((TermContext)_localctx).left = factor();

			    ((TermContext)_localctx).value =  ((TermContext)_localctx).left.value;

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__5) {
				{
				{
				setState(158);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				((TermContext)_localctx).right = factor();

				        final Supplier<TypedValue> leftSup = _localctx.value;
				        final Supplier<TypedValue> rightSup = ((TermContext)_localctx).right.value;
				        final String operator = ((TermContext)_localctx).op.getText();

				        ((TermContext)_localctx).value =  new Supplier<TypedValue>() {
				            public TypedValue get() {
				                TypedValue l = leftSup.get();
				                TypedValue r = rightSup.get();

				                if (!isNumeric(l) || !isNumeric(r))
				                    throw new RuntimeException("Operator " + operator + " requires numeric operands");

				                if (l.kind == TypedValue.Kind.DECIMAL || r.kind == TypedValue.Kind.DECIMAL) {
				                    BigDecimal a = l.asBigDecimal();
				                    BigDecimal b = r.asBigDecimal();
				                    BigDecimal res;
				                    if (operator.equals("*")) res = a.multiply(b);
				                    else res = a.divide(b, 18, java.math.RoundingMode.HALF_UP);
				                    return new TypedValue(res);
				                } else {
				                    int a = l.intVal;
				                    int b = r.intVal;
				                    if (operator.equals("*")) return new TypedValue(a * b);
				                    else {
				                        if (b == 0) throw new RuntimeException("Division by zero!!!");
				                        return new TypedValue(a / b);
				                    }
				                }
				            }
				        };
				    
				}
				}
				setState(166);
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
	public static class FactorContext extends ParserRuleContext {
		public Supplier<TypedValue> value;
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((FactorContext)_localctx).INT = match(INT);

				    final String txt = ((FactorContext)_localctx).INT.getText();
				    ((FactorContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() { return new TypedValue(Integer.parseInt(txt)); }
				    };

				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((FactorContext)_localctx).DECIMAL = match(DECIMAL);

				    final String txt = ((FactorContext)_localctx).DECIMAL.getText();
				    ((FactorContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() { return new TypedValue(new BigDecimal(txt)); }
				    };

				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				((FactorContext)_localctx).BOOL = match(BOOL);

				    final String txt = ((FactorContext)_localctx).BOOL.getText();
				    ((FactorContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() { return new TypedValue(Boolean.parseBoolean(txt)); }
				    };

				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				((FactorContext)_localctx).STRING = match(STRING);

				    final String raw = ((FactorContext)_localctx).STRING.getText();
				    final String inner = raw.substring(1, raw.length() - 1)
				        .replace("\\n", "\n")
				        .replace("\\t", "\t")
				        .replace("\\\"", "\"")
				        .replace("\\\\", "\\");
				    ((FactorContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() { return new TypedValue(inner); }
				    };

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				((FactorContext)_localctx).id = match(ID);

				    final String name = ((FactorContext)_localctx).id.getText();
				    ((FactorContext)_localctx).value =  new Supplier<TypedValue>() {
				        public TypedValue get() {
				            if (!variables.containsKey(name)) throw new RuntimeException("Undefined variable: " + name);
				            return variables.get(name);
				        }
				    };

				}
				break;
			case FP:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				match(FP);
				setState(178);
				((FactorContext)_localctx).e = expr();
				setState(179);
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(T__6);
				 ((TypeContext)_localctx).typeKind =  TypeKind.INT; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__7);
				 ((TypeContext)_localctx).typeKind =  TypeKind.BOOL; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(T__8);
				 ((TypeContext)_localctx).typeKind =  TypeKind.DECIMAL; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
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
		"\u0004\u0001\u001d\u00c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0003\u0004N\b\u0004\u0005\u0004P\b\u0004"+
		"\n\u0004\f\u0004S\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005[\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005_\b\u0005\n\u0005\f\u0005b\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006m\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007u\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u008d\b\u000b"+
		"\n\u000b\f\u000b\u0090\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u0098\b\f\n\f\f\f\u009b\t\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u00a3\b\r\n\r\f\r\u00a6\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00b7\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00c1\b\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0003"+
		"\u0001\u0000\u0011\u0013\u0001\u0000\u0003\u0004\u0001\u0000\u0005\u0006"+
		"\u00c8\u0000 \u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004"+
		"1\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bQ\u0001\u0000"+
		"\u0000\u0000\nV\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000\u0000\u000e"+
		"p\u0001\u0000\u0000\u0000\u0010x\u0001\u0000\u0000\u0000\u0012}\u0001"+
		"\u0000\u0000\u0000\u0014\u0083\u0001\u0000\u0000\u0000\u0016\u0086\u0001"+
		"\u0000\u0000\u0000\u0018\u0091\u0001\u0000\u0000\u0000\u001a\u009c\u0001"+
		"\u0000\u0000\u0000\u001c\u00b6\u0001\u0000\u0000\u0000\u001e\u00c0\u0001"+
		"\u0000\u0000\u0000 $\u0003\u0002\u0001\u0000!#\u0003\u0004\u0002\u0000"+
		"\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000"+
		")*\u0003\u001e\u000f\u0000*+\u0005\u0001\u0000\u0000+,\u0005\u0016\u0000"+
		"\u0000,-\u0005\u0017\u0000\u0000-.\u0005\u0018\u0000\u0000./\u0003\b\u0004"+
		"\u0000/0\u0005\u0019\u0000\u00000\u0003\u0001\u0000\u0000\u000012\u0003"+
		"\u001e\u000f\u000023\u0005\u0014\u0000\u000034\u0005\u0016\u0000\u0000"+
		"45\u0005\u0017\u0000\u000056\u0005\u0018\u0000\u000067\u0003\b\u0004\u0000"+
		"78\u0005\u0019\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0003\u000e"+
		"\u0007\u0000:;\u0006\u0003\uffff\uffff\u0000;J\u0001\u0000\u0000\u0000"+
		"<=\u0003\u0010\b\u0000=>\u0006\u0003\uffff\uffff\u0000>J\u0001\u0000\u0000"+
		"\u0000?@\u0003\u0012\t\u0000@A\u0006\u0003\uffff\uffff\u0000AJ\u0001\u0000"+
		"\u0000\u0000BC\u0003\u0014\n\u0000CD\u0005\u001c\u0000\u0000DE\u0006\u0003"+
		"\uffff\uffff\u0000EJ\u0001\u0000\u0000\u0000FG\u0003\f\u0006\u0000GH\u0006"+
		"\u0003\uffff\uffff\u0000HJ\u0001\u0000\u0000\u0000I9\u0001\u0000\u0000"+
		"\u0000I<\u0001\u0000\u0000\u0000I?\u0001\u0000\u0000\u0000IB\u0001\u0000"+
		"\u0000\u0000IF\u0001\u0000\u0000\u0000J\u0007\u0001\u0000\u0000\u0000"+
		"KM\u0003\u0006\u0003\u0000LN\u0005\u001c\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OK\u0001\u0000"+
		"\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"TU\u0006\u0004\uffff\uffff\u0000U\t\u0001\u0000\u0000\u0000VW\u0005\u0018"+
		"\u0000\u0000W`\u0006\u0005\uffff\uffff\u0000XZ\u0003\u0006\u0003\u0000"+
		"Y[\u0005\u001c\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\]\u0006\u0005\uffff\uffff\u0000]_\u0001"+
		"\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000cd\u0005\u0019\u0000\u0000d\u000b\u0001"+
		"\u0000\u0000\u0000ef\u0005\u000f\u0000\u0000fg\u0005\u0016\u0000\u0000"+
		"gh\u0003\u0014\n\u0000hi\u0005\u0017\u0000\u0000il\u0003\n\u0005\u0000"+
		"jk\u0005\u0010\u0000\u0000km\u0003\n\u0005\u0000lj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0006\u0006\uffff"+
		"\uffff\u0000o\r\u0001\u0000\u0000\u0000pq\u0003\u001e\u000f\u0000qt\u0005"+
		"\u0014\u0000\u0000rs\u0005\u001a\u0000\u0000su\u0003\u0014\n\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vw\u0006\u0007\uffff\uffff\u0000w\u000f\u0001\u0000\u0000\u0000xy\u0005"+
		"\u0014\u0000\u0000yz\u0005\u001a\u0000\u0000z{\u0003\u0014\n\u0000{|\u0006"+
		"\b\uffff\uffff\u0000|\u0011\u0001\u0000\u0000\u0000}~\u0005\u0002\u0000"+
		"\u0000~\u007f\u0005\u0016\u0000\u0000\u007f\u0080\u0003\u0014\n\u0000"+
		"\u0080\u0081\u0005\u0017\u0000\u0000\u0081\u0082\u0006\t\uffff\uffff\u0000"+
		"\u0082\u0013\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u0016\u000b\u0000"+
		"\u0084\u0085\u0006\n\uffff\uffff\u0000\u0085\u0015\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0003\u0018\f\u0000\u0087\u008e\u0006\u000b\uffff\uffff\u0000"+
		"\u0088\u0089\u0007\u0000\u0000\u0000\u0089\u008a\u0003\u0018\f\u0000\u008a"+
		"\u008b\u0006\u000b\uffff\uffff\u0000\u008b\u008d\u0001\u0000\u0000\u0000"+
		"\u008c\u0088\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000"+
		"\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0003\u001a\r\u0000\u0092\u0099\u0006\f\uffff\uffff\u0000"+
		"\u0093\u0094\u0007\u0001\u0000\u0000\u0094\u0095\u0003\u001a\r\u0000\u0095"+
		"\u0096\u0006\f\uffff\uffff\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097"+
		"\u0093\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u0019\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0003\u001c\u000e\u0000\u009d\u00a4\u0006\r\uffff\uffff\u0000\u009e"+
		"\u009f\u0007\u0002\u0000\u0000\u009f\u00a0\u0003\u001c\u000e\u0000\u00a0"+
		"\u00a1\u0006\r\uffff\uffff\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2"+
		"\u009e\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u001b\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0005\u000b\u0000\u0000\u00a8\u00b7\u0006\u000e\uffff\uffff\u0000"+
		"\u00a9\u00aa\u0005\r\u0000\u0000\u00aa\u00b7\u0006\u000e\uffff\uffff\u0000"+
		"\u00ab\u00ac\u0005\f\u0000\u0000\u00ac\u00b7\u0006\u000e\uffff\uffff\u0000"+
		"\u00ad\u00ae\u0005\u000e\u0000\u0000\u00ae\u00b7\u0006\u000e\uffff\uffff"+
		"\u0000\u00af\u00b0\u0005\u0014\u0000\u0000\u00b0\u00b7\u0006\u000e\uffff"+
		"\uffff\u0000\u00b1\u00b2\u0005\u0016\u0000\u0000\u00b2\u00b3\u0003\u0014"+
		"\n\u0000\u00b3\u00b4\u0005\u0017\u0000\u0000\u00b4\u00b5\u0006\u000e\uffff"+
		"\uffff\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00b6\u00a9\u0001\u0000\u0000\u0000\u00b6\u00ab\u0001\u0000"+
		"\u0000\u0000\u00b6\u00ad\u0001\u0000\u0000\u0000\u00b6\u00af\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b7\u001d\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0007\u0000\u0000\u00b9\u00c1\u0006\u000f"+
		"\uffff\uffff\u0000\u00ba\u00bb\u0005\b\u0000\u0000\u00bb\u00c1\u0006\u000f"+
		"\uffff\uffff\u0000\u00bc\u00bd\u0005\t\u0000\u0000\u00bd\u00c1\u0006\u000f"+
		"\uffff\uffff\u0000\u00be\u00bf\u0005\n\u0000\u0000\u00bf\u00c1\u0006\u000f"+
		"\uffff\uffff\u0000\u00c0\u00b8\u0001\u0000\u0000\u0000\u00c0\u00ba\u0001"+
		"\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u001f\u0001\u0000\u0000\u0000\r$IMQZ`lt\u008e"+
		"\u0099\u00a4\u00b6\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}