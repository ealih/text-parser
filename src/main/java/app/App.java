package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

    public List<String> parse(String text){

        Parser parser = new Parser(text);

        Stack<Node> nodes = new Stack<>();

        Node rootNode = null;

        String prevToken = "";

        while (parser.hasNext()) {
            String token = parser.nextToken();

            switch (token) {

                case "{":
                    Node node = new Node();

                    if(!nodes.isEmpty()){
                        nodes.peek().getTo().add(node);
                        node.setFrom(nodes.peek());
                    }

                    nodes.push(node);
                    break;

                case "}":
                    nodes.pop();
                    break;

                case "|":
                    nodes.pop();

                    Node n = new Node();
                    nodes.peek().getTo().add(n);
                    n.setFrom(nodes.peek());

                    nodes.push(n);
                    break;

                case ".":
                    if(rootNode == null){
                        rootNode = nodes.peek();
                    } else {
                        attachToTree(rootNode, nodes.pop());
                    }

                    endSentence(rootNode,".");

                    nodes.clear();

                    nodes.push(new Node());
                    break;

                case "":
                    break;

                default:

                    if(prevToken.equals("}")) {
                        endSentence(nodes.firstElement(), " "+token);
                    } else {
                        nodes.peek().appendText(token);
                    }

                    break;
            }

            prevToken = token;
        }

        List<String> pathsToRoot = new ArrayList<>();
        findPathsToRoot(rootNode, pathsToRoot);

        return pathsToRoot;
    }

    private void attachToTree(Node rootTreeNode, Node node){

        for(Node n : rootTreeNode.getTo()) {
            if(n.getTo().isEmpty()) {
                clone(node, n);
            } else {
                attachToTree(n, node);
            }
        }
    }

    private void endSentence(Node rootTreeNode, String sign){

        for(Node n : rootTreeNode.getTo()) {
            if(n.getTo().isEmpty()) {
                n.appendText(sign);
            } else {
                endSentence(n, sign);
            }
        }
    }

    private void clone(Node node, Node attachTo) {

        Node clone = new Node();
        clone.setText(node.getText());

        attachTo.getTo().add(clone);
        clone.setFrom(attachTo);

        for(Node n : node.getTo()){
            clone(n, clone);
        }
    }

    private void findPathsToRoot(Node node, List<String> paths){
        for(Node n : node.getTo()) {
            if(n.getTo().isEmpty()) {
                paths.add(n.getPathToRoot());
            } else {
                findPathsToRoot(n, paths);
            }
        }
    }
}
