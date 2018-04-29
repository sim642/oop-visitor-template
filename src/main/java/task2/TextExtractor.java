package task2;

import nodes.DrawNode;
import sample.DemoImages;

import java.util.List;

public class TextExtractor {

    public static void main(String[] args) {
        extractTexts(DemoImages.DEMO_IMAGE).forEach(System.out::println);
    }

    public static List<String> extractTexts(DrawNode node) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
