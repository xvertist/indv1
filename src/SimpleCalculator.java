import java.text.DecimalFormat;
import java.util.Stack;



interface Calculable {
    /**
     * @param expression An arithmetic expression that can only have one or more of the basic four operations: addition, subtraction, multiplication, and division (double division). Parentheses can be used in the expression. The type of the expression is String.
     * @return If the provided expression is valid, return the calculated value of the expression (up to five places after decimal point); If the expression is not valid, return "Invalid expression".
     */
    String calculate(String expression);
}

public class SimpleCalculator implements Calculable {


    public static int prec(char refOp) {
		switch (refOp){
			case '*':
			case '/': return 2;
			case '+':
			case '-': return 1;
		}
		return -1;
	}


    private static boolean isOperator(char c) {
		return (c=='+'||c=='-'||c=='/'||c=='*');
	}


    // arithmetic
    public String calculate(String expression) {
        Stack<Double> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		int i = 0;
        DecimalFormat d = new DecimalFormat("#.#####");



        //error prechecks
        if (expression.equals("")) {
            return "Invalid Expression";
        }
        if (expression.charAt(0) == ' ') {
            return "Invalid Expression";
        }
        for (int e =1; e < expression.length(); e++){

            if (expression.charAt(e) == ' '&& expression.charAt(e-1) == ' ') {
                return "Invalid Expression";
            }
        }
        //end error prechecks



		while (i < expression.length()) {
			if (Character.isDigit(expression.charAt(i))) {
                String number = "0";
                double dig = 0;
                boolean cutNumber = false;
				
                    for (int j = 0; i < expression.length(); i++) {
                        char c = expression.charAt(i);
                        if (cutNumber) {
                            if (Character.isDigit(c) || c == '.') {
                                number += c;
                            } else {
                                cutNumber = false;
                                break;
                            }
                        } else {
                            if (Character.isDigit(c)) {
                                cutNumber = true;
                                number += c;
                            }
                        }
                    }
                    
                
                dig = Double.parseDouble(number);
                dig = Double.valueOf(d.format(dig));
				numStack.push(dig);
				
			}
			else if (expression.charAt(i) == '(') opStack.push('(');
			else if (expression.charAt(i) == ')'){
                
                //Check if there is an operator directly next to parenthesis
                try {
                    if (i > 0 && isOperator(expression.charAt(i - 1))) {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception IllegalArgumentException) {
                    //Error caught, returning invalid
                    return "Invalid Expression";
                }
                //Check if there is an invalid expression loaded into the math logic
                try {
                while (!opStack.empty() && opStack.peek() != '(') {
                    doOperation(numStack, opStack);
                }
            } catch (Exception NullPointerException) {
                //Error caught, returning invalid
                return "Invalid Expression";
            }
				opStack.pop();
			}
			else if (expression.charAt(i) != ' ') {
                try {
                    if (i > 0 && isOperator(expression.charAt(i - 1))) {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception IllegalArgumentException) {
                    return "Invalid Expression";
                }
                if (Character.isLetter(expression.charAt(i)) == true) {
                    return "Invalid Expression";
                }
                
                while (!opStack.empty() && opStack.peek() != '(' 
						&& prec(opStack.peek()) >= prec(expression.charAt(i)))
					doOperation(numStack, opStack);
				opStack.push(expression.charAt(i));
			}
			i++;
		}

		while (!opStack.empty()) doOperation(numStack, opStack);
        double answer = numStack.pop();
        answer = Double.valueOf(d.format(answer));
        return String.valueOf(answer);
	}

	private void doOperation(Stack<Double> numStack, Stack<Character> opStack) {
		double b = numStack.pop(), a = numStack.pop();
		char c = opStack.pop();

		if (c == '+') numStack.push(a+b);
		else if (c == '-') numStack.push(a-b);
		else if (c == '*') numStack.push(a*b);
		else numStack.push(a/b);
	}
}

