package jweb.front.elem;

import jweb.front.content.FlowContent;

public class Body extends Element {
    private final FlowContent content;

    public Body() {
        super("body");
        content = new FlowContent();
    }

    @Override
    public FlowContent getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }
}
