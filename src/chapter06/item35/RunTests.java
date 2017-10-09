package chapter06.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Noblel
 */
public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(args[0]);
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;
                try{
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(method + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("INVALID @Test: " + method);
                }
            }

            if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try{
                    method.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", method);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Exception>[] excTypes = method.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", method, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
