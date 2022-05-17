import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMain {

    @Test
    public void testEmptyStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode(""),
                "Zero length string");
    }

    @Test
    public void testPositiveNegativeInput() {
        Assertions.assertEquals(1, Integer.decode("+1"));
        Assertions.assertEquals(1, Integer.decode("1"));
        Assertions.assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    public void testHexInput() {
        Assertions.assertEquals(38, Integer.decode("0x26"));
        Assertions.assertEquals(38, Integer.decode("0x0026"));
        Assertions.assertEquals(-38, Integer.decode("-0x26"));
        Assertions.assertEquals(38, Integer.decode("#26"));
        Assertions.assertEquals(-38, Integer.decode("-#26"));
    }

    @Test
    public void testOctalInput() {
        Assertions.assertEquals(8, Integer.decode("010"));
        Assertions.assertEquals(-8, Integer.decode("-010"));
        Assertions.assertEquals(9, Integer.decode("011"));
        Assertions.assertEquals(-9, Integer.decode("-011"));
    }

    @Test
    public void testSignPosition() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("5+"),
                "Sign character in wrong position");
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("+-5"),
                "Sign character in wrong position");
    }

    @Test
    public void testMaxInput() {
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.MAX_VALUE + ""));
    }

    @Test
    public void testMinInput() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.MIN_VALUE + ""));
    }

    //дополнительно
    @Test
    public void testZeroInput() {
        Assertions.assertEquals(0, Integer.decode("+0"));
        Assertions.assertEquals(0, Integer.decode("0"));
        Assertions.assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void testRandomStringInput() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("Test test"), "For input string: \"Test test\"");
    }
}
