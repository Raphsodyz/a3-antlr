// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CCompilerParser}.
 */
public interface CCompilerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CCompilerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CCompilerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#main_function}.
	 * @param ctx the parse tree
	 */
	void enterMain_function(CCompilerParser.Main_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#main_function}.
	 * @param ctx the parse tree
	 */
	void exitMain_function(CCompilerParser.Main_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#assingment}.
	 * @param ctx the parse tree
	 */
	void enterAssingment(CCompilerParser.AssingmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#assingment}.
	 * @param ctx the parse tree
	 */
	void exitAssingment(CCompilerParser.AssingmentContext ctx);
}