// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CCompilerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CCompilerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CCompilerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#main_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_function(CCompilerParser.Main_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#assingment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssingment(CCompilerParser.AssingmentContext ctx);
}