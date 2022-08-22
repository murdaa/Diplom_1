package praktikum.IngredientTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientNameTest {

    private final String testName;
    private final String expected;

    public IngredientNameTest(String testName, String expected) {
        this.testName = testName;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestName() {
        return new Object[][] {
                {" ", " "},
                {"test", "test"},
                {"NameForIngredient", "NameForIngredient"}
        };
    }

    @Test
    public void testNameIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, testName, 1); // создали экземпляр класса
        String actual = ingredient.getName(); // вызвали проверяемый метод
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }
}
