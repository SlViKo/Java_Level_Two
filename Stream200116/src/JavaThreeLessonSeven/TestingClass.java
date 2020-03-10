package JavaThreeLessonSeven;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TestingClass {

    public static void start(Class cls) {
        performTests(cls);
    }

    private static void performTests(Class cls) throws RuntimeException {

        TestClass testClass = null;
        try {
            testClass = (TestClass)cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Method beforeMethod = null;
        Method afterMethod = null;
        Method[] methods = cls.getMethods();
        List<MethodWithPriority> testingMethods = new ArrayList<>();

        //цикл распределения типом методов и проверки на единственность методов Before и After
        for (Method method : methods)
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null) {
                    throw new RuntimeException("Метод с аннотацией @beforeSuite в классе должен быть только один");
                }
                beforeMethod = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null) {
                    throw new RuntimeException("Метод с аннотацией @AfterSuite в классе должен быть только один");
                }
                afterMethod = method;
            } else if (method.getAnnotation(Test.class) != null){
                Test annotationTst = method.getAnnotation(Test.class);
                testingMethods.add(new MethodWithPriority(method, annotationTst.value()));
            }

        // сортировка коллекции по приоритету
        Collections.sort(testingMethods, (o1, o2) -> o1.compareTo(o2));

            // запуск методов в порядке аннотации
        try {
            if (beforeMethod != null)
                beforeMethod.invoke(testClass);

            for (MethodWithPriority methodWP : testingMethods)
                methodWP.method.invoke(testClass);

            if (afterMethod != null)
                afterMethod.invoke(testClass);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
