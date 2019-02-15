package app;

public class Parser {

    private String text;
    int position;

    public Parser(String text) {
        this.text = text;
    }

    public boolean hasNext(){
        return position < text.length();
    }

    public String nextToken(){
        if(text.charAt(position) == '{'){
            position++;
            return "{";
        }

        if(text.charAt(position) == '}'){
            position++;
            return "}";
        }

        if(text.charAt(position) == '|'){
            position++;
            return "|";
        }

        if(text.charAt(position) == '.'){
            position++;
            return ".";
        }

        String word = "";

        while (text.charAt(position) != '{'
                && text.charAt(position) != '}'
                && text.charAt(position) != '|'
                && text.charAt(position) != '.'
                ){

                word += String.valueOf(text.charAt(position));

            position++;
        }

        return word.trim();
    }
}
