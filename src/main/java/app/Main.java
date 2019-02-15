package app;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //String sample = "{This is my {homework|assignment}.}";
        //String sample = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }.}";
        String sample = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }. Tonight is { baseball | football } game. }";
        //String sample = "{ Today is { Monday { and it's working } | Friday { and it's { relaxing | easy} } day }. Tonight is { baseball | football } game. This is my {homework|assignment}.}";

        if(args.length == 0) {
            System.out.println("Usage: app <text>");
            //System.exit(1);
        }

        App app = new App();
        List<String> combinations = app.parse(sample);

        System.out.println(String.format("Combinations (%d):", combinations.size()));

        for (String entry : combinations) {
            System.out.println(entry);
        }
    }
}
