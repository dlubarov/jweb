package jweb.front.elem;

import jweb.front.cat.*;
import jweb.front.content.ArbitraryContent;

public class Anchor extends Element implements BottomCategory {
    public final ArbitraryContent content;
    public String title = null, href = null;

    public Anchor(TopCategory... children) {
        super("a");
        content = new ArbitraryContent(children);
    }

    @Override
    protected Object getContent() {
        return content;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
        attrs.set("title", title);
        attrs.set("href", href);
    }
}
