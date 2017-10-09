package chapter05.item27;

/**
 * @author Noblel
 */
public class GenericSingletonFactory {
    private static UnaryFunction<Object> IDENTITY_FUNCTION =
            new UnaryFunction<Object>() {
                @Override
                public Object apply(Object arg) {
                    return arg;
                }
            };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String string : strings)
            System.out.println(sameString.apply(string));

        Number[] numbers = {1, 2.0, 3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }

}
