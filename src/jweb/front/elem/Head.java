package jweb.front.elem;

import jweb.front.content.MetadataContent;

public class Head extends Element {
    public final MetadataContent content;

    protected Head() {
        super("head");
        content = new MetadataContent();
    }

    @Override
    protected Object getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }
}
