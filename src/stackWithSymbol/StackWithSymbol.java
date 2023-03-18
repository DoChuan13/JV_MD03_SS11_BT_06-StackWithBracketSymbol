package stackWithSymbol;

import java.util.Scanner;
import java.util.Stack;

public class StackWithSymbol {
    static Stack<Character> bStack = new Stack<>();
    static String expression;

    public static void checkBracketSymbol(Scanner scanner) {
        System.out.print("Nhập một chuỗi biểu thức: ");
        expression = scanner.nextLine();
        System.out.println("Chuỗi biểu thức ban đầu là: " + expression);
        boolean checkResult = checkMatchSymbol();
        if (checkResult) {
            System.out.println("Chuỗi biểu thức hợp lệ");
        } else System.out.println("Chuỗi biểu thức KHÔNG hợp lệ");
    }

    private static boolean checkMatchSymbol() {
        char left;
        char roundOpenBracket = '(';
        char roundCloseBracket = ')';
        char squareOpenBracket = '[';
        char squareCloseBracket = ']';
        char curlyOpenBracket = '{';
        char curlyCloseBracket = '}';
        for (int i = 0; i < expression.length(); i++) {
            char sym = expression.charAt(i);

            if (sym == roundOpenBracket || sym == squareOpenBracket || sym == curlyOpenBracket) {
                bStack.push(sym);
                continue;
            }
            if (sym == roundCloseBracket || sym == squareCloseBracket || sym == curlyCloseBracket) {
                if (bStack.isEmpty()) {
                    //Ngoặc đóng nhiều hơn ngoặc mở
                    //System.out.println("Empty");
                    return false;
                }
                //Lấy ra khỏi stack ngoặc mở gần nhất
                left = bStack.pop();
                if ((left == roundOpenBracket && sym != roundCloseBracket) ||
                        (left == squareOpenBracket && sym != squareCloseBracket) ||
                        (left == curlyOpenBracket && sym != curlyCloseBracket)) {
                        //Ngoặc đóng và ngoặc mở không khớp với nhau
                        //ystem.out.println("Don't match");
                    return false;
                }
            }
        }
        if (bStack.isEmpty()) return true;
        //Ngoặc đóng ít hơn ngoặc mở
        //System.out.println("Don't clear");
        return false;
    }
}
