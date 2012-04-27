package jweb.front.elem;

import jweb.front.content.FlowContent;

public class ListItem extends Element {
    public final FlowContent content;

    protected ListItem() {
        super("li");
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
