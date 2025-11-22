// Generated from D:/Codes/A3_Algoritmos/a3-antlr/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link CCompilerParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CCompilerParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CCompilerParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CCompilerParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CCompilerParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(CCompilerParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(CCompilerParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(CCompilerParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(CCompilerParser.ForUpdateContext ctx);
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
	 * Visit a parse tree produced by {@link CCompilerParser#simpleAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAssignment(CCompilerParser.SimpleAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CCompilerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(CCompilerParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(CCompilerParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(CCompilerParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(CCompilerParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CCompilerParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(CCompilerParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#printfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintfStmt(CCompilerParser.PrintfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#scanfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanfStmt(CCompilerParser.ScanfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CCompilerParser.TypeContext ctx);
}