import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CalculatorRunner {
    public static void main(String[] args) throws Exception {
        // Cargar el archivo de entrada
        File inputFile = new File("test3.txt");
        InputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);

        // Crear un lexer que analiza la entrada
        CalculatorLexer lexer = new CalculatorLexer(input);

        // Crear un buffer de tokens para alimentar al parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Crear un parser que analiza los tokens
        CalculatorParser parser = new CalculatorParser(tokens);

        // Empezar el análisis sintáctico en la regla 'prog'
        ParseTree tree = parser.prog();

        // Crear un visitante para evaluar las expresiones
        EvalVisitor eval = new EvalVisitor();

        // Evaluar el árbol de análisis sintáctico
        eval.visit(tree);

        // Imprimir el resultado de todas las variables
        eval.printAllVariables();
    }

    // Clase para visitar los nodos del árbol de análisis sintáctico y evaluar las expresiones
    static class EvalVisitor extends CalculatorBaseVisitor<Double> {
        private Map<String, Double> symbolTable = new HashMap<>();

        @Override
        public Double visitPrintExpr(CalculatorParser.PrintExprContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Double visitAssign(CalculatorParser.AssignContext ctx) {
            String id = ctx.ID().getText();
            Double value = visit(ctx.expr());
            symbolTable.put(id, value);
            return value;
        }

        @Override
        public Double visitInt(CalculatorParser.IntContext ctx) {
            return Double.parseDouble(ctx.INT().getText());
        }

        @Override
        public Double visitFloat(CalculatorParser.FloatContext ctx) {
            return Double.parseDouble(ctx.FLOAT().getText());
        }

        @Override
        public Double visitId(CalculatorParser.IdContext ctx) {
            String id = ctx.getText();
            return symbolTable.getOrDefault(id, 0.0);
        }

        @Override
        public Double visitMul(CalculatorParser.MulContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (left == null || right == null) {
                throw new RuntimeException("Error: Operands in multiplication expression cannot be null");
            }
            return left * right;
        }

        @Override
        public Double visitDiv(CalculatorParser.DivContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (left == null || right == null) {
                throw new RuntimeException("Error: Operands in division expression cannot be null");
            }
            if (right == 0.0) {
                throw new ArithmeticException("Error: Division by zero");
            }
            return left / right;
        }

        @Override
        public Double visitAdd(CalculatorParser.AddContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (left == null || right == null) {
                throw new RuntimeException("Error: Operands in addition expression cannot be null");
            }
            return left + right;
        }

        @Override
        public Double visitSub(CalculatorParser.SubContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (left == null || right == null) {
                throw new RuntimeException("Error: Operands in subtraction expression cannot be null");
            }
            return left - right;
        }

        @Override
        public Double visitParens(CalculatorParser.ParensContext ctx) {
            return visit(ctx.expr());
        }

        public void printAllVariables() {
            System.out.println("Valores de las variables:");
            for (Map.Entry<String, Double> entry : symbolTable.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}

