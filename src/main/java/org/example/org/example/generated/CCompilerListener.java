// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
package org.example.generated;
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
	 * Enter a parse tree produced by {@link CCompilerParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(CCompilerParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(CCompilerParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(CCompilerParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(CCompilerParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CCompilerParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CCompilerParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CCompilerParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CCompilerParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CCompilerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CCompilerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CCompilerParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CCompilerParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#printf_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintf_stmt(CCompilerParser.Printf_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#printf_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintf_stmt(CCompilerParser.Printf_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CCompilerParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CCompilerParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CCompilerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CCompilerParser.TypeContext ctx);
}