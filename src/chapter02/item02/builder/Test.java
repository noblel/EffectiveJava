package chapter02.item02.builder;

/**
 * @author Noblel
 */
public class Test {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println(cocaCola.toString());
    }
}
