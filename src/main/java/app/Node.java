package app;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String text;
    private Node from;
    private List<Node> to;

    public Node() {
        to = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public List<Node> getTo() {
        return to;
    }

    public String getPathToRoot () {
        if(from == null) {
            return text;
        } else {
            return from.getPathToRoot() + " " + text;
        }
    }

    public void appendText(String newText){
        if(text == null) {
            text = "";
        }

        text = text + newText;
    }

    @Override
    public String toString() {
        return "app.Node{"+text+", -> "+to.size()+"}";
    }
}
