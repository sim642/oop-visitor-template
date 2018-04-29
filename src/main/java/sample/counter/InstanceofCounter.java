package sample.counter;

import nodes.DrawNode;
import nodes.composite.GroupNode;
import nodes.composite.ImageNode;
import sample.DemoImages;

public class InstanceofCounter {

    public static void main(String[] args) {
        System.out.println(countNodes(DemoImages.DEMO_IMAGE));
    }

    /**
     * Counts all nodes in the draw node tree.
     */
    public static int countNodes(DrawNode node) {
        int count = 0;

        if (node instanceof GroupNode) {
            GroupNode group = (GroupNode) node;
            for (DrawNode child : group.getChildren()) {
                count += countNodes(child);
            }
        }
        else if (node instanceof ImageNode) {
            ImageNode image = (ImageNode) node;
            count += countNodes(image.getChild());
        }

        return count;
    }
}
