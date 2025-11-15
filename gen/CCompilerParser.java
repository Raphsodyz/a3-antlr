// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
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
		T__0=1, OP=2, INT=3, DECIMAL=4, BOOL=5, ID=6, IF=7, ELSE=8, FP=9, LP=10, 
		FK=11, LK=12, OP_ASS=13, COMMA=14, SCOLLON=15, WS=16;
	public static final int
		RULE_prog = 0, RULE_main_function = 1, RULE_assingment = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main_function", "assingment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", null, "'int'", "'decimal'", null, null, "'if'", "'else'", 
			"'('", "')'", "'{'", "'}'", "'='", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "OP", "INT", "DECIMAL", "BOOL", "ID", "IF", "ELSE", "FP", 
			"LP", "FK", "LK", "OP_ASS", "COMMA", "SCOLLON", "WS"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			main_function();
			setState(7);
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
		public TerminalNode FP() { return getToken(CCompilerParser.FP, 0); }
		public TerminalNode LP() { return getToken(CCompilerParser.LP, 0); }
		public TerminalNode FK() { return getToken(CCompilerParser.FK, 0); }
		public TerminalNode LK() { return getToken(CCompilerParser.LK, 0); }
		public TerminalNode INT() { return getToken(CCompilerParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CCompilerParser.DECIMAL, 0); }
		public TerminalNode BOOL() { return getToken(CCompilerParser.BOOL, 0); }
		public AssingmentContext assingment() {
			return getRuleContext(AssingmentContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(10);
			match(T__0);
			setState(11);
			match(FP);
			setState(12);
			match(LP);
			setState(13);
			match(FK);
			{
			setState(14);
			assingment();
			}
			setState(15);
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
	public static class AssingmentContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CCompilerParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CCompilerParser.ID, i);
		}
		public List<TerminalNode> SCOLLON() { return getTokens(CCompilerParser.SCOLLON); }
		public TerminalNode SCOLLON(int i) {
			return getToken(CCompilerParser.SCOLLON, i);
		}
		public List<TerminalNode> INT() { return getTokens(CCompilerParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CCompilerParser.INT, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(CCompilerParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(CCompilerParser.DECIMAL, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(CCompilerParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(CCompilerParser.BOOL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CCompilerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CCompilerParser.COMMA, i);
		}
		public AssingmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assingment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).enterAssingment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CCompilerListener ) ((CCompilerListener)listener).exitAssingment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitAssingment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssingmentContext assingment() throws RecognitionException {
		AssingmentContext _localctx = new AssingmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assingment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(17);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(18);
				match(ID);
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(19);
					match(COMMA);
					setState(20);
					match(ID);
					}
					}
					setState(25);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(26);
				match(SCOLLON);
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) );
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
		"\u0004\u0001\u0010 \u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0016"+
		"\b\u0002\n\u0002\f\u0002\u0019\t\u0002\u0001\u0002\u0004\u0002\u001c\b"+
		"\u0002\u000b\u0002\f\u0002\u001d\u0001\u0002\u0000\u0000\u0003\u0000\u0002"+
		"\u0004\u0000\u0001\u0001\u0000\u0003\u0005\u001e\u0000\u0006\u0001\u0000"+
		"\u0000\u0000\u0002\t\u0001\u0000\u0000\u0000\u0004\u001b\u0001\u0000\u0000"+
		"\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0005\u0000\u0000\u0001"+
		"\b\u0001\u0001\u0000\u0000\u0000\t\n\u0007\u0000\u0000\u0000\n\u000b\u0005"+
		"\u0001\u0000\u0000\u000b\f\u0005\t\u0000\u0000\f\r\u0005\n\u0000\u0000"+
		"\r\u000e\u0005\u000b\u0000\u0000\u000e\u000f\u0003\u0004\u0002\u0000\u000f"+
		"\u0010\u0005\f\u0000\u0000\u0010\u0003\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0007\u0000\u0000\u0000\u0012\u0017\u0005\u0006\u0000\u0000\u0013\u0014"+
		"\u0005\u000e\u0000\u0000\u0014\u0016\u0005\u0006\u0000\u0000\u0015\u0013"+
		"\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001a"+
		"\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0005\u000f\u0000\u0000\u001b\u0011\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0001\u0000\u0000\u0000\u001e\u0005\u0001\u0000\u0000\u0000\u0002\u0017"+
		"\u001d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}