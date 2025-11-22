// Generated from D:/Codes/A3_Algoritmos/a3-antlr/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
package org.example.generated;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		DECIMAL=32, INT=33, BOOL=34, STRING=35, ID=36, WS=37, LINE_COMMENT=38, 
		BLOCK_COMMENT=39;
	public static final int
		RULE_prog = 0, RULE_main_function = 1, RULE_function = 2, RULE_function_body = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_ifStatement = 6, RULE_whileStatement = 7, 
		RULE_doWhileStatement = 8, RULE_forStatement = 9, RULE_forInit = 10, RULE_forUpdate = 11, 
		RULE_declaration = 12, RULE_assignment = 13, RULE_simpleAssignment = 14, 
		RULE_expr = 15, RULE_orExpr = 16, RULE_andExpr = 17, RULE_relExpr = 18, 
		RULE_addExpr = 19, RULE_term = 20, RULE_factor = 21, RULE_printfStmt = 22, 
		RULE_scanfStmt = 23, RULE_type = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main_function", "function", "function_body", "statement", "block", 
			"ifStatement", "whileStatement", "doWhileStatement", "forStatement", 
			"forInit", "forUpdate", "declaration", "assignment", "simpleAssignment", 
			"expr", "orExpr", "andExpr", "relExpr", "addExpr", "term", "factor", 
			"printfStmt", "scanfStmt", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'('", "')'", "'{'", "'}'", "';'", "'if'", "'else'", 
			"'while'", "'do'", "'for'", "'='", "'||'", "'&&'", "'<'", "'>'", "'<='", 
			"'>='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'!'", "'printf'", 
			"'scanf'", "'int'", "'bool'", "'decimal'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "DECIMAL", "INT", "BOOL", 
			"STRING", "ID", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
			setState(50);
			main_function();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) {
				{
				{
				setState(51);
				function();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
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
			setState(59);
			type();
			setState(60);
			match(T__0);
			setState(61);
			match(T__1);
			setState(62);
			match(T__2);
			setState(63);
			match(T__3);
			setState(64);
			function_body();
			setState(65);
			match(T__4);
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
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
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
			setState(67);
			type();
			setState(68);
			match(ID);
			setState(69);
			match(T__1);
			setState(70);
			match(T__2);
			setState(71);
			match(T__3);
			setState(72);
			function_body();
			setState(73);
			match(T__4);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137409597140L) != 0)) {
				{
				{
				setState(75);
				statement();
				}
				}
				setState(80);
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
	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintfStmtContext printfStmt() {
			return getRuleContext(PrintfStmtContext.class,0);
		}
		public ScanfStmtContext scanfStmt() {
			return getRuleContext(ScanfStmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				doWhileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				declaration();
				setState(87);
				match(T__5);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				assignment();
				setState(90);
				match(T__5);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(92);
				printfStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(93);
				scanfStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(94);
				expr();
				setState(95);
				match(T__5);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(97);
				match(T__5);
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__3);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137409597140L) != 0)) {
				{
				{
				setState(101);
				statement();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(T__4);
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
	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext condition;
		public StatementContext thenBranch;
		public StatementContext elseBranch;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__6);
			setState(110);
			match(T__1);
			setState(111);
			((IfStatementContext)_localctx).condition = expr();
			setState(112);
			match(T__2);
			setState(113);
			((IfStatementContext)_localctx).thenBranch = statement();
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(114);
				match(T__7);
				setState(115);
				((IfStatementContext)_localctx).elseBranch = statement();
				}
				break;
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
	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext condition;
		public StatementContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__8);
			setState(119);
			match(T__1);
			setState(120);
			((WhileStatementContext)_localctx).condition = expr();
			setState(121);
			match(T__2);
			setState(122);
			((WhileStatementContext)_localctx).body = statement();
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
	public static class DoWhileStatementContext extends ParserRuleContext {
		public StatementContext body;
		public ExprContext condition;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__9);
			setState(125);
			((DoWhileStatementContext)_localctx).body = statement();
			setState(126);
			match(T__8);
			setState(127);
			match(T__1);
			setState(128);
			((DoWhileStatementContext)_localctx).condition = expr();
			setState(129);
			match(T__2);
			setState(130);
			match(T__5);
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
	public static class ForStatementContext extends ParserRuleContext {
		public ForInitContext init;
		public ExprContext condition;
		public ForUpdateContext update;
		public StatementContext body;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__10);
			setState(133);
			match(T__1);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72746008576L) != 0)) {
				{
				setState(134);
				((ForStatementContext)_localctx).init = forInit();
				}
			}

			setState(137);
			match(T__5);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 133181734916L) != 0)) {
				{
				setState(138);
				((ForStatementContext)_localctx).condition = expr();
				}
			}

			setState(141);
			match(T__5);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(142);
				((ForStatementContext)_localctx).update = forUpdate();
				}
			}

			setState(145);
			match(T__2);
			setState(146);
			((ForStatementContext)_localctx).body = statement();
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
	public static class ForInitContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public SimpleAssignmentContext simpleAssignment() {
			return getRuleContext(SimpleAssignmentContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forInit);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				declaration();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				simpleAssignment();
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
	public static class ForUpdateContext extends ParserRuleContext {
		public SimpleAssignmentContext simpleAssignment() {
			return getRuleContext(SimpleAssignmentContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			simpleAssignment();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
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
		enterRule(_localctx, 24, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			type();
			setState(155);
			match(ID);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(156);
				match(T__11);
				setState(157);
				expr();
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
	public static class AssignmentContext extends ParserRuleContext {
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
		enterRule(_localctx, 26, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(ID);
			setState(161);
			match(T__11);
			setState(162);
			expr();
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
	public static class SimpleAssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SimpleAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterSimpleAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitSimpleAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitSimpleAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleAssignmentContext simpleAssignment() throws RecognitionException {
		SimpleAssignmentContext _localctx = new SimpleAssignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(ID);
			setState(165);
			match(T__11);
			setState(166);
			expr();
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
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
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
		enterRule(_localctx, 30, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			orExpr();
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
	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			andExpr();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(171);
				match(T__12);
				setState(172);
				andExpr();
				}
				}
				setState(177);
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
	public static class AndExprContext extends ParserRuleContext {
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			relExpr();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(179);
				match(T__13);
				setState(180);
				relExpr();
				}
				}
				setState(185);
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
	public static class RelExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			addExpr();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) {
				{
				setState(187);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				addExpr();
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
	public static class AddExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			term();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20 || _la==T__21) {
				{
				{
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				term();
				}
				}
				setState(198);
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
		enterRule(_localctx, 40, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			factor();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__23) {
				{
				{
				setState(200);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(201);
				factor();
				}
				}
				setState(206);
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
		public TerminalNode INT() { return getToken(CCompilerParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CCompilerParser.DECIMAL, 0); }
		public TerminalNode BOOL() { return getToken(CCompilerParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(CCompilerParser.STRING, 0); }
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
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
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(INT);
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(DECIMAL);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(BOOL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(210);
				match(STRING);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(211);
				match(ID);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 6);
				{
				setState(212);
				match(T__1);
				setState(213);
				expr();
				setState(214);
				match(T__2);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 7);
				{
				setState(216);
				match(T__21);
				setState(217);
				factor();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				match(T__24);
				setState(219);
				factor();
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
	public static class PrintfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterPrintfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitPrintfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitPrintfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintfStmtContext printfStmt() throws RecognitionException {
		PrintfStmtContext _localctx = new PrintfStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_printfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__25);
			setState(223);
			match(T__1);
			setState(224);
			expr();
			setState(225);
			match(T__2);
			setState(226);
			match(T__5);
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
	public static class ScanfStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CCompilerParser.ID, 0); }
		public ScanfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterScanfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitScanfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitScanfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanfStmtContext scanfStmt() throws RecognitionException {
		ScanfStmtContext _localctx = new ScanfStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_scanfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__26);
			setState(229);
			match(T__1);
			setState(230);
			match(ID);
			setState(231);
			match(T__2);
			setState(232);
			match(T__5);
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
		enterRule(_localctx, 48, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\'\u00ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0005\u00005\b\u0000\n\u0000\f\u00008\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004c\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005g\b\u0005\n\u0005\f\u0005j\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006u\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0088\b\t\u0001\t\u0001\t\u0003\t\u008c\b\t\u0001\t\u0001\t"+
		"\u0003\t\u0090\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u0097"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u009f"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00ae\b\u0010\n\u0010\f\u0010\u00b1\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00b6\b\u0011\n\u0011\f\u0011\u00b9\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00be\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00c3\b\u0013\n\u0013\f\u0013\u00c6"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00cb\b\u0014"+
		"\n\u0014\f\u0014\u00ce\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00dd\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"0\u0000\u0004\u0001\u0000\u000f\u0014\u0001\u0000\u0015\u0016\u0001\u0000"+
		"\u0017\u0018\u0001\u0000\u001c\u001f\u00f2\u00002\u0001\u0000\u0000\u0000"+
		"\u0002;\u0001\u0000\u0000\u0000\u0004C\u0001\u0000\u0000\u0000\u0006N"+
		"\u0001\u0000\u0000\u0000\bb\u0001\u0000\u0000\u0000\nd\u0001\u0000\u0000"+
		"\u0000\fm\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010"+
		"|\u0001\u0000\u0000\u0000\u0012\u0084\u0001\u0000\u0000\u0000\u0014\u0096"+
		"\u0001\u0000\u0000\u0000\u0016\u0098\u0001\u0000\u0000\u0000\u0018\u009a"+
		"\u0001\u0000\u0000\u0000\u001a\u00a0\u0001\u0000\u0000\u0000\u001c\u00a4"+
		"\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000 \u00aa\u0001"+
		"\u0000\u0000\u0000\"\u00b2\u0001\u0000\u0000\u0000$\u00ba\u0001\u0000"+
		"\u0000\u0000&\u00bf\u0001\u0000\u0000\u0000(\u00c7\u0001\u0000\u0000\u0000"+
		"*\u00dc\u0001\u0000\u0000\u0000,\u00de\u0001\u0000\u0000\u0000.\u00e4"+
		"\u0001\u0000\u0000\u00000\u00ea\u0001\u0000\u0000\u000026\u0003\u0002"+
		"\u0001\u000035\u0003\u0004\u0002\u000043\u0001\u0000\u0000\u000058\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0005\u0000\u0000"+
		"\u0001:\u0001\u0001\u0000\u0000\u0000;<\u00030\u0018\u0000<=\u0005\u0001"+
		"\u0000\u0000=>\u0005\u0002\u0000\u0000>?\u0005\u0003\u0000\u0000?@\u0005"+
		"\u0004\u0000\u0000@A\u0003\u0006\u0003\u0000AB\u0005\u0005\u0000\u0000"+
		"B\u0003\u0001\u0000\u0000\u0000CD\u00030\u0018\u0000DE\u0005$\u0000\u0000"+
		"EF\u0005\u0002\u0000\u0000FG\u0005\u0003\u0000\u0000GH\u0005\u0004\u0000"+
		"\u0000HI\u0003\u0006\u0003\u0000IJ\u0005\u0005\u0000\u0000J\u0005\u0001"+
		"\u0000\u0000\u0000KM\u0003\b\u0004\u0000LK\u0001\u0000\u0000\u0000MP\u0001"+
		"\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"O\u0007\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000Qc\u0003\f\u0006"+
		"\u0000Rc\u0003\u000e\u0007\u0000Sc\u0003\u0010\b\u0000Tc\u0003\u0012\t"+
		"\u0000Uc\u0003\n\u0005\u0000VW\u0003\u0018\f\u0000WX\u0005\u0006\u0000"+
		"\u0000Xc\u0001\u0000\u0000\u0000YZ\u0003\u001a\r\u0000Z[\u0005\u0006\u0000"+
		"\u0000[c\u0001\u0000\u0000\u0000\\c\u0003,\u0016\u0000]c\u0003.\u0017"+
		"\u0000^_\u0003\u001e\u000f\u0000_`\u0005\u0006\u0000\u0000`c\u0001\u0000"+
		"\u0000\u0000ac\u0005\u0006\u0000\u0000bQ\u0001\u0000\u0000\u0000bR\u0001"+
		"\u0000\u0000\u0000bS\u0001\u0000\u0000\u0000bT\u0001\u0000\u0000\u0000"+
		"bU\u0001\u0000\u0000\u0000bV\u0001\u0000\u0000\u0000bY\u0001\u0000\u0000"+
		"\u0000b\\\u0001\u0000\u0000\u0000b]\u0001\u0000\u0000\u0000b^\u0001\u0000"+
		"\u0000\u0000ba\u0001\u0000\u0000\u0000c\t\u0001\u0000\u0000\u0000dh\u0005"+
		"\u0004\u0000\u0000eg\u0003\b\u0004\u0000fe\u0001\u0000\u0000\u0000gj\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\u0005\u0000"+
		"\u0000l\u000b\u0001\u0000\u0000\u0000mn\u0005\u0007\u0000\u0000no\u0005"+
		"\u0002\u0000\u0000op\u0003\u001e\u000f\u0000pq\u0005\u0003\u0000\u0000"+
		"qt\u0003\b\u0004\u0000rs\u0005\b\u0000\u0000su\u0003\b\u0004\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\r\u0001\u0000\u0000\u0000"+
		"vw\u0005\t\u0000\u0000wx\u0005\u0002\u0000\u0000xy\u0003\u001e\u000f\u0000"+
		"yz\u0005\u0003\u0000\u0000z{\u0003\b\u0004\u0000{\u000f\u0001\u0000\u0000"+
		"\u0000|}\u0005\n\u0000\u0000}~\u0003\b\u0004\u0000~\u007f\u0005\t\u0000"+
		"\u0000\u007f\u0080\u0005\u0002\u0000\u0000\u0080\u0081\u0003\u001e\u000f"+
		"\u0000\u0081\u0082\u0005\u0003\u0000\u0000\u0082\u0083\u0005\u0006\u0000"+
		"\u0000\u0083\u0011\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u000b\u0000"+
		"\u0000\u0085\u0087\u0005\u0002\u0000\u0000\u0086\u0088\u0003\u0014\n\u0000"+
		"\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0005\u0006\u0000\u0000"+
		"\u008a\u008c\u0003\u001e\u000f\u0000\u008b\u008a\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008f\u0005\u0006\u0000\u0000\u008e\u0090\u0003\u0016\u000b\u0000"+
		"\u008f\u008e\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0003\u0000\u0000"+
		"\u0092\u0093\u0003\b\u0004\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094"+
		"\u0097\u0003\u0018\f\u0000\u0095\u0097\u0003\u001c\u000e\u0000\u0096\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0015"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0003\u001c\u000e\u0000\u0099\u0017"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u00030\u0018\u0000\u009b\u009e\u0005"+
		"$\u0000\u0000\u009c\u009d\u0005\f\u0000\u0000\u009d\u009f\u0003\u001e"+
		"\u000f\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f\u0019\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005$\u0000"+
		"\u0000\u00a1\u00a2\u0005\f\u0000\u0000\u00a2\u00a3\u0003\u001e\u000f\u0000"+
		"\u00a3\u001b\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005$\u0000\u0000\u00a5"+
		"\u00a6\u0005\f\u0000\u0000\u00a6\u00a7\u0003\u001e\u000f\u0000\u00a7\u001d"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0003 \u0010\u0000\u00a9\u001f\u0001"+
		"\u0000\u0000\u0000\u00aa\u00af\u0003\"\u0011\u0000\u00ab\u00ac\u0005\r"+
		"\u0000\u0000\u00ac\u00ae\u0003\"\u0011\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0!\u0001\u0000\u0000\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b7\u0003$\u0012\u0000\u00b3"+
		"\u00b4\u0005\u000e\u0000\u0000\u00b4\u00b6\u0003$\u0012\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8#\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bd\u0003"+
		"&\u0013\u0000\u00bb\u00bc\u0007\u0000\u0000\u0000\u00bc\u00be\u0003&\u0013"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be%\u0001\u0000\u0000\u0000\u00bf\u00c4\u0003(\u0014\u0000\u00c0"+
		"\u00c1\u0007\u0001\u0000\u0000\u00c1\u00c3\u0003(\u0014\u0000\u00c2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\'\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00cc\u0003"+
		"*\u0015\u0000\u00c8\u00c9\u0007\u0002\u0000\u0000\u00c9\u00cb\u0003*\u0015"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cd)\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cf\u00dd\u0005!\u0000\u0000\u00d0\u00dd\u0005 \u0000\u0000\u00d1\u00dd"+
		"\u0005\"\u0000\u0000\u00d2\u00dd\u0005#\u0000\u0000\u00d3\u00dd\u0005"+
		"$\u0000\u0000\u00d4\u00d5\u0005\u0002\u0000\u0000\u00d5\u00d6\u0003\u001e"+
		"\u000f\u0000\u00d6\u00d7\u0005\u0003\u0000\u0000\u00d7\u00dd\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0005\u0016\u0000\u0000\u00d9\u00dd\u0003*\u0015"+
		"\u0000\u00da\u00db\u0005\u0019\u0000\u0000\u00db\u00dd\u0003*\u0015\u0000"+
		"\u00dc\u00cf\u0001\u0000\u0000\u0000\u00dc\u00d0\u0001\u0000\u0000\u0000"+
		"\u00dc\u00d1\u0001\u0000\u0000\u0000\u00dc\u00d2\u0001\u0000\u0000\u0000"+
		"\u00dc\u00d3\u0001\u0000\u0000\u0000\u00dc\u00d4\u0001\u0000\u0000\u0000"+
		"\u00dc\u00d8\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dd+\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u001a\u0000\u0000\u00df"+
		"\u00e0\u0005\u0002\u0000\u0000\u00e0\u00e1\u0003\u001e\u000f\u0000\u00e1"+
		"\u00e2\u0005\u0003\u0000\u0000\u00e2\u00e3\u0005\u0006\u0000\u0000\u00e3"+
		"-\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u001b\u0000\u0000\u00e5\u00e6"+
		"\u0005\u0002\u0000\u0000\u00e6\u00e7\u0005$\u0000\u0000\u00e7\u00e8\u0005"+
		"\u0003\u0000\u0000\u00e8\u00e9\u0005\u0006\u0000\u0000\u00e9/\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0007\u0003\u0000\u0000\u00eb1\u0001\u0000\u0000"+
		"\u0000\u00106Nbht\u0087\u008b\u008f\u0096\u009e\u00af\u00b7\u00bd\u00c4"+
		"\u00cc\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}