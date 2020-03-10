package JavaThreeLessonSeven;

public class TestClass {

    @Test(value = 5)
    public void Test5() {
        System.out.println("Performed Test №5");
    }
    @Test(value = 3)
    public void Test2(){
        System.out.println("Performed Test №2");
    }
    @Test(value = 7)
    public void Test1(){
        System.out.println("Performed Test №1");
    }
    @BeforeSuite
    public void BeforeAll(){
        System.out.println("This method is performed before all");
    }
    @AfterSuite
    public void AfterAll() {
        System.out.println("This method is performed after all");
    }

}
