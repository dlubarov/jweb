package jweb.front.elem;

import jweb.front.content.MetadataContent;

public class Head extends Element {
    public final MetadataContent content;

    public Head() {
        super("head");
        content = new MetadataContent();
    }

    @Override
    public MetadataContent getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }
}
