package nodes.leaf;

import nodes.DrawVisitor;

public class TextNode extends LeafNode {

    private final String text;

    public TextNode(int x, int y, String text) {
        super(x, y);
        this.text = text;
    }

    @Override
    public void accept(DrawVisitor visitor) {
        visitor.visit(this);
    }

    public String getText() {
        return text;
    }
}
