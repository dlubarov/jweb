package jweb.front.elem;

import jweb.front.cat.FlowCategory;
import jweb.front.content.*;

public class UnorderedList extends Element implements FlowCategory {
    public final ListItemContent content;

    protected UnorderedList() {
        super("ul");
        content = new ListItemContent();
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }
}
