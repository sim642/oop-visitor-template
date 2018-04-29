package task2;

import nodes.DrawNode;
import nodes.SimpleDrawVisitor;
import nodes.leaf.TextNode;
import sample.DemoImages;

import java.util.ArrayList;
import java.util.List;

public class TextExtractor {

    public static void main(String[] args) {
        extractTexts(DemoImages.DEMO_IMAGE).forEach(System.out::println);
    }

    /**
     * Extracts the texts of all Text nodes from the draw node tree into a list.
     */
    public static List<String> extractTexts(DrawNode node) {
        TextVisitor textVisitor = new TextVisitor();
        node.accept(textVisitor);
        return textVisitor.texts;
    }

    private static class TextVisitor extends SimpleDrawVisitor {

        private final List<String> texts = new ArrayList<>();

        @Override
        public void visit(TextNode text) {
            texts.add(text.getText());
        }
    }
}
