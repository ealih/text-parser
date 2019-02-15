import app.App;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppTest {

    private static final String SAMPLE_1 = "{This is my {homework|assignment}.}";
    private static final String SAMPLE_2 = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }.}";
    private static final String SAMPLE_3 = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }. Tonight is { baseball | football } game. }";
    private static final String SAMPLE_4 = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }. Tonight is { baseball | football } game. This is my {homework|assignment}.}";

    @Test
    public void testText1(){
        App app = new App();
        List<String> result = app.parse(SAMPLE_1);

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains("This is my homework."));
        Assert.assertTrue(result.contains("This is my assignment."));
    }

    @Test
    public void testText2(){
        App app = new App();
        List<String> result = app.parse(SAMPLE_2);

        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains("Today is Monday and it's working day."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day."));
    }

    @Test
    public void testText3(){
        App app = new App();
        List<String> result = app.parse(SAMPLE_3);

        Assert.assertEquals(6, result.size());
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is baseball game."));
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is football game."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is baseball game."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is football game."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is baseball game."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is football game."));
    }

    @Test
    public void testText4(){
        App app = new App();
        List<String> result = app.parse(SAMPLE_4);

        Assert.assertEquals(12, result.size());
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is baseball game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is baseball game. This is my assignment."));
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is football game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Monday and it's working day. Tonight is football game. This is my assignment."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is baseball game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is baseball game. This is my assignment."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is football game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Friday and it's relaxing day. Tonight is football game. This is my assignment."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is baseball game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is baseball game. This is my assignment."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is football game. This is my homework."));
        Assert.assertTrue(result.contains("Today is Friday and it's easy day. Tonight is football game. This is my assignment."));
    }
}
