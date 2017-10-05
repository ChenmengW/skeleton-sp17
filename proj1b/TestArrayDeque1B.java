import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B{

@Test
public void test1(){
	while (true) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            StudentArrayDeque<Integer> student = new StudentArrayDeque<Integer>();
            ArrayDequeSolution<Integer> solution =  new ArrayDequeSolution<Integer>();

            if (numberBetweenZeroAndOne <= 0.25) {
                student.addFirst(1); 
                solution.addFirst(1);
                assertEquals(student, solution);
            } 
            else if (numberBetweenZeroAndOne > 0.25 && numberBetweenZeroAndOne <= 0.5){
            	student.addLast(1);
            	solution.addLast(1);
            	assertEquals(student, solution);
            }

            else if (numberBetweenZeroAndOne > 0.5 && numberBetweenZeroAndOne <= 0.75){
            	student.addFirst(1); 
                solution.addFirst(1);
            	Integer a = student.removeFirst();
            	Integer b = solution.removeLast();
            	assertEquals(a, b);
            	assertEquals(student, solution);
            }
            else {
                student.addFirst(1); 
                solution.addFirst(1);
                Integer a = student.removeLast();
                Integer b = solution.removeLast();
                assertEquals(a, b);
                assertEquals(student, solution);
            }
        }

}

}