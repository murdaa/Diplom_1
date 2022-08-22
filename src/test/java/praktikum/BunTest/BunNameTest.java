package praktikum.BunTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunNameTest {

    private final String testName;
    private final String expected;

    public BunNameTest(String testName, String expected) {
    this.testName = testName;
    this.expected = expected;
        }

    @Parameterized.Parameters
    public static Object[][] getTestName() {
    return new Object[][] {
        {" ", " "},
        {"test", "test"},
        {"NameForBun", "NameForBun"}
    };
    }

    @Test
    public void testNameBun() {
        Bun bun = new Bun(testName, 1); // создали экземпляр класса
        String actual = bun.getName(); // вызвали проверяемый метод
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }
}
