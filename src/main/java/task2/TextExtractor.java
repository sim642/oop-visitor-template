package task2;

import nodes.DrawNode;
import sample.DemoImages;

import java.util.List;

public class TextExtractor {

    public static void main(String[] args) {
        extractTexts(DemoImages.DEMO_IMAGE).forEach(System.out::println);
    }

    /**
     * Extracts the texts of all Text nodes from the draw node tree into a list.
     */
    public static List<String> extractTexts(DrawNode node) {
        // TODO: implement using visitor
        throw new UnsupportedOperationException("Not implemented");
    }
}
