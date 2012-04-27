package jweb.front.elem;

import jweb.front.content.FlowContent;

public class Body extends Element {
    private final FlowContent content;

    protected Body() {
        super("body");
        content = new FlowContent();
    }

    @Override
    protected Object getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }
}
