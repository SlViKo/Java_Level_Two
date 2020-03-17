package JavaThreeLessonSeven;

public class TestClass {

    @Test(value = 5)
    public void Test1() {
        System.out.println("Метод @Test 1");
    }

    @Test(value = 3)
    public void Test2(){
        System.out.println("Метод @Test 2");
    }

    @Test(value = 7)
    public void Test3(){
        System.out.println("Метод @Test 3");
    }

    @Test(value = 7)
    public void Test4(){
        System.out.println("Метод @Test 4");
    }

    @Test(value = 20)
    public void Test5(){
        System.out.println("Метод @Test 5");
    }

    @BeforeSuite
    public void BeforeAll(){
        System.out.println("Метод @BeforeSuite 1");
    }

//    @BeforeSuite
//    public void BeforeAll2(){
//        System.out.println("Метод @BeforeSuite 2");
//    }

    @AfterSuite
    public void AfterAll() {
        System.out.println("Метод @AfterSuite 1");
    }

//    @AfterSuite
//    public void AfterAll2() {
//        System.out.println("Метод @AfterSuite 1");
//    }

}
