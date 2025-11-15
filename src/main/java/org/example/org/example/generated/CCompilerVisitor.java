// Generated from C:/Users/arthu/OneDrive/Documentos/Faculdade/Compiladores/a3compiler/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
package org.example.generated;
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
	 * Visit a parse tree produced by {@link CCompilerParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(CCompilerParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(CCompilerParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CCompilerParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CCompilerParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CCompilerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CCompilerParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#printf_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintf_stmt(CCompilerParser.Printf_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(CCompilerParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CCompilerParser.TypeContext ctx);
}