import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void test1() {
        while (true) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            StudentArrayDeque<Integer> student = new StudentArrayDeque<Integer>();
            ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<Integer>();

            if (numberBetweenZeroAndOne > 0.5) {
                student.addFirst(1);
                DequeOperation firstCommand = new DequeOperation("addFirst", 1);
                solution.addFirst(1);
                Integer a = student.removeFirst();
                Integer b = solution.removeFirst();
                DequeOperation secondCommand = new DequeOperation("addLast");
                assertEquals(firstCommand + "is not equal to" + secondCommand, a, b);
            } else {
                student.addFirst(1);
                solution.addFirst(1);
                Integer a = student.removeLast();
                Integer b = solution.removeLast();
                assertEquals(a, b);
            }
        }

    }


    private class DequeOperation {
        private String opName;
        private boolean hasArgument;
        private int argument;

        /**
         * Constructor for operations with an argument.
         */
        public DequeOperation(String op, int arg) {
            this.opName = op;
            this.hasArgument = true;
            this.argument = arg;
        }

        /**
         * Constructor for operations with no argument.
         */
        public DequeOperation(String op) {
            this.opName = op;
            this.hasArgument = false;
        }

        /**
         * Returns a string representation of this object, e.g.
         * if opName = "addFront" and argument = 10, this method
         * would return "addFront(10)"
         */
        public String toString() {
            String returnString;
            returnString = opName + "(";

            if (hasArgument) {
                returnString = returnString + argument;
            }

            returnString = returnString + ")";
            return returnString;
        }
    }
}