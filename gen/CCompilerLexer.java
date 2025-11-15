// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CCompilerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OP=2, INT=3, DECIMAL=4, BOOL=5, ID=6, IF=7, ELSE=8, FP=9, LP=10, 
		FK=11, LK=12, OP_ASS=13, COMMA=14, SCOLLON=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "OP", "INT", "DECIMAL", "BOOL", "ID", "IF", "ELSE", "FP", "LP", 
			"FK", "LK", "OP_ASS", "COMMA", "SCOLLON", "WS"
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


	public CCompilerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004>\b\u0004\u0001\u0005\u0003\u0005A\b\u0005\u0001\u0005\u0005\u0005"+
		"D\b\u0005\n\u0005\f\u0005G\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f`\b"+
		"\u000f\u000b\u000f\f\u000fa\u0001\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010\u0001\u0000\u0004\u0003\u0000*+--//\u0002\u0000"+
		"AZaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  g\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003"+
		"&\u0001\u0000\u0000\u0000\u0005(\u0001\u0000\u0000\u0000\u0007,\u0001"+
		"\u0000\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000b@\u0001\u0000\u0000"+
		"\u0000\rH\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000\u0011"+
		"P\u0001\u0000\u0000\u0000\u0013R\u0001\u0000\u0000\u0000\u0015T\u0001"+
		"\u0000\u0000\u0000\u0017V\u0001\u0000\u0000\u0000\u0019X\u0001\u0000\u0000"+
		"\u0000\u001bZ\u0001\u0000\u0000\u0000\u001d\\\u0001\u0000\u0000\u0000"+
		"\u001f_\u0001\u0000\u0000\u0000!\"\u0005m\u0000\u0000\"#\u0005a\u0000"+
		"\u0000#$\u0005i\u0000\u0000$%\u0005n\u0000\u0000%\u0002\u0001\u0000\u0000"+
		"\u0000&\'\u0007\u0000\u0000\u0000\'\u0004\u0001\u0000\u0000\u0000()\u0005"+
		"i\u0000\u0000)*\u0005n\u0000\u0000*+\u0005t\u0000\u0000+\u0006\u0001\u0000"+
		"\u0000\u0000,-\u0005d\u0000\u0000-.\u0005e\u0000\u0000./\u0005c\u0000"+
		"\u0000/0\u0005i\u0000\u000001\u0005m\u0000\u000012\u0005a\u0000\u0000"+
		"23\u0005l\u0000\u00003\b\u0001\u0000\u0000\u000045\u0005t\u0000\u0000"+
		"56\u0005r\u0000\u000067\u0005u\u0000\u00007>\u0005e\u0000\u000089\u0005"+
		"f\u0000\u00009:\u0005a\u0000\u0000:;\u0005l\u0000\u0000;<\u0005s\u0000"+
		"\u0000<>\u0005e\u0000\u0000=4\u0001\u0000\u0000\u0000=8\u0001\u0000\u0000"+
		"\u0000>\n\u0001\u0000\u0000\u0000?A\u0007\u0001\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000AE\u0001\u0000\u0000\u0000BD\u0007\u0002\u0000\u0000CB\u0001"+
		"\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000F\f\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000HI\u0005i\u0000\u0000IJ\u0005f\u0000\u0000J\u000e\u0001\u0000\u0000"+
		"\u0000KL\u0005e\u0000\u0000LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000"+
		"NO\u0005e\u0000\u0000O\u0010\u0001\u0000\u0000\u0000PQ\u0005(\u0000\u0000"+
		"Q\u0012\u0001\u0000\u0000\u0000RS\u0005)\u0000\u0000S\u0014\u0001\u0000"+
		"\u0000\u0000TU\u0005{\u0000\u0000U\u0016\u0001\u0000\u0000\u0000VW\u0005"+
		"}\u0000\u0000W\u0018\u0001\u0000\u0000\u0000XY\u0005=\u0000\u0000Y\u001a"+
		"\u0001\u0000\u0000\u0000Z[\u0005,\u0000\u0000[\u001c\u0001\u0000\u0000"+
		"\u0000\\]\u0005;\u0000\u0000]\u001e\u0001\u0000\u0000\u0000^`\u0007\u0003"+
		"\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cd\u0006\u000f\u0000\u0000d \u0001\u0000\u0000\u0000\u0006\u0000=@CEa"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}