package sample;

import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import nodes.leaf.CircleNode;
import nodes.leaf.RectangleNode;
import nodes.leaf.TextNode;

import java.util.List;

public class TestImages {

    public static final ImageNode DEMO_IMAGE = new ImageNode(
            new GroupNode(List.of(
                    new RectangleNode(10, 10, 100, 50),
                    new GroupNode(List.of(
                            new CircleNode(150, 30, 20),
                            new TextNode(200, 50, "Some text")
                    )),
                    new TextNode(30, 100, "My cool image")
            ))
    );
}
