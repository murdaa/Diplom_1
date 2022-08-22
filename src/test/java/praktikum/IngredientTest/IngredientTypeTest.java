package praktikum.IngredientTest;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType testType;
    private final IngredientType expected;

    public IngredientTypeTest(IngredientType testType, IngredientType expected) {
        this.testType = testType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestType() {
        return new Object[][] {
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void testTypeIngredient() {
        Ingredient ingredient = new Ingredient(testType, "test", 1); // создали экземпляр класса
        IngredientType actual = ingredient.getType(); // вызвали проверяемый метод
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }


}
