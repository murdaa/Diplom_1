package praktikum.BunTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunPriceTest {

    private final float testPrice;
    private final float expected;
    private static final float delta = (float) 0.01F;

    public BunPriceTest(float testPrice, float expected) {
        this.testPrice = testPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestPrice() {
        return new Object[][] {
                {0.0F, 0.0F},
                {1.0F, 1.0F},
                {2.5F, 2.5F},
                {10.05F, 10.05F},
                {333.99999F, 333.9999F}
        };
    }

    @Test
    public void testPriceBun() {
        Bun bun = new Bun("test", testPrice); // создали экземпляр класса
        float actual = bun.getPrice(); // вызвали проверяемый метод
        assertEquals(expected, actual, delta); // сравнили ожидаемый результат с фактическим
    }
}
