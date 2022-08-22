package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final float delta = (float) 0.01F;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);

    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Test
    public void addIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        //Act
        burger.addIngredient(ingredient);
        //Assert
        assertNotNull(burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        //Act
        burger.removeIngredient(0);
        //Assert
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        //Act
        burger.moveIngredient(0, 1);
        //Assert
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        //Act
        Mockito.when(bun.getPrice()).thenReturn(3F);
        Mockito.when(ingredient.getPrice()).thenReturn(0.5F);
        float expected = 3F * 2 + 0.5F;
        float actual = burger.getPrice();
        //Assert
        assertEquals(expected, actual, delta);
}

    @Test
    public void getReceiptTest() {
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        //Act
        Mockito.when(bun.getName()).thenReturn("test bun");
        Mockito.when(bun.getPrice()).thenReturn(3.0F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("test ingredient");
        Mockito.when(ingredient.getPrice()).thenReturn(0.5F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) + String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        //Assert
        assertEquals(expected, burger.getReceipt());
    }
}
