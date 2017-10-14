import org.junit.Test;
import static org.junit.Assert.*;

/** Demos the version of assertEquals with a String message. */
public class AssertEqualsStringDemo {
    @Test
    public void test1() {
        int expected = 5;
        int actual = StdRandom.uniform(9);
        assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
    }

    /**
     * This main method is optional.
     */
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(AssertEqualsStringDemo.class);
    }


    public class DequeOperation {
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