// Generated from D:/Codes/A3_Algoritmos/a3-antlr/src/main/antlr/CCompiler.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link CCompilerParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CCompilerParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CCompilerParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CCompilerParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CCompilerParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CCompilerParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CCompilerParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CCompilerParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CCompilerParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(CCompilerParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(CCompilerParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CCompilerParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CCompilerParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(CCompilerParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(CCompilerParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(CCompilerParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(CCompilerParser.ForUpdateContext ctx);
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
	 * Enter a parse tree produced by {@link CCompilerParser#simpleAssignment}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAssignment(CCompilerParser.SimpleAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#simpleAssignment}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAssignment(CCompilerParser.SimpleAssignmentContext ctx);
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
	 * Enter a parse tree produced by {@link CCompilerParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(CCompilerParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(CCompilerParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(CCompilerParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(CCompilerParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(CCompilerParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(CCompilerParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(CCompilerParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(CCompilerParser.AddExprContext ctx);
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
	 * Enter a parse tree produced by {@link CCompilerParser#printfStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintfStmt(CCompilerParser.PrintfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#printfStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintfStmt(CCompilerParser.PrintfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CCompilerParser#scanfStmt}.
	 * @param ctx the parse tree
	 */
	void enterScanfStmt(CCompilerParser.ScanfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CCompilerParser#scanfStmt}.
	 * @param ctx the parse tree
	 */
	void exitScanfStmt(CCompilerParser.ScanfStmtContext ctx);
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