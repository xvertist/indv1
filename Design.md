Document: Supporting document describing my class design – Nick Schuler

Public static int prec(char refOp) – Designing this method was fairly easy, utilizing knowledge from our Algorithms class when we worked on a calculator similar to this one. This method returns a value of 1 or 2 based on the precedence of the operation being executed by the calculator.

Private static Boolean isOperator(char c) – This returns true if the char provided matches one of the four operators that are used in this calculator

Private void doOperation(Stack<Double> numStack, Stack<Character> opStack) – This is where all of the math logic lies. Operations are sent here after they have been parsed in the main portion of the calculate method

Public String calculate (String expression) – this is implemented from SimpleCalculator class. This method first checks the string provided for errors, such as entering nothing, a blank space at the beginning or letters, and will return &quot;Invalid Expression&quot; if an error is found. Then the calculator parses through the string character by character, sending the info to the correct stacks to be processed in doOperation. There is also error checking within the parsing logic, that will return &quot;Invalid Expression&quot; if any errors are found. There is also a decimal formatter that rounds to 5 decimal places in both the parsing and at the end before returning the final answer.

The tester class is created using Junit 5- it executes through 6 tests:

The first test is addition to test if the calculator can add numbers properly

The second test is subtract to test if the calculator is able to subtract numbers properly

The third test is multiply to test if the calculator is able to multiply numbers properly

The fourth test is divide to test if the calculator can divide numbers properly

The fifth test is LongEquation to test if the calculator can handle equations using multiple operations and multiple layers of parenthesis properly

The sixth and final test is invalidExpression to test if the calculator is able to detect errors properly
