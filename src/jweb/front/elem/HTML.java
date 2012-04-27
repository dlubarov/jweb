package jweb.front.elem;

import jweb.front.content.*;

public class HTML extends Element {
    private Head head;
    private Body body;

    protected HTML() {
        super("html");
        head = null;
        body = null;
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
        attrs.setRaw("xmlns", "http://www.w3.org/1999/xhtml");
    }

    @Override
    protected Object getContent() {
        ArbitraryContent content = new ArbitraryContent();
        if (head != null)
            content.add(head);
        if (body != null)
            content.add(body);
        return content;
    }
}
