import org.junit.*;

public class TestArithmetics {

    private static Arithmetics a;

/*
      @Before - ин-ция перед каждым методом теста
      @After - метод выполняется после каждого теста
      @AfterClass - выполнится после всех тестов
      @Ignore - тест не будет выполняться
*/

    @BeforeClass
    public static void runT(){
        a = new Arithmetics();
    }

    @Ignore
    @Test
    public void testAdd(){
        double res = a.add(3, 7);
        if (res != 10) Assert.fail();
    }

    @Test
    public void testAddSec(){
        double res = a.add(3, 7);
        Assert.assertTrue("Hello world!!!", 10 == res);
    }

    @Test
    public void testMult(){
        double res = a.mult(3, 7);
        if (res != 21) Assert.fail();
    }


    @Test
    public void testDiv(){
        Assert.assertTrue(4 == a.division(8, 2));
    }

    @Test
    public void testObject(){
        String s = "mama";
        String d = new String("mama");
        Assert.assertEquals(d, s);
    }

    @Test
    public void test(){
        Arithmetics c = new Arithmetics();
        Arithmetics b = a;
        Assert.assertSame(a, b);
    }
}
