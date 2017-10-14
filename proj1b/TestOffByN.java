import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN{

@Test
public void testOff() {
	OffByN a = new OffByN(5);
	boolean b = a.equalChars('a','f');
	assertEquals(b, true);
}

}