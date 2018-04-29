package nodes.composite;

import nodes.DrawNode;
import nodes.DrawVisitor;

import java.util.List;

/**
 * Represents a group of nodes.
 */
public class GroupNode extends DrawNode {

    private final List<DrawNode> children;

    public GroupNode(List<DrawNode> children) {
        this.children = children;
    }

    @Override
    public void accept(DrawVisitor visitor) {
        visitor.visit(this);
    }

    public List<DrawNode> getChildren() {
        return children;
    }
}
