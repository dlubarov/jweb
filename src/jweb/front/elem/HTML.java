package jweb.front.elem;

import jweb.front.content.*;

public class HTML extends Element {
    private Head head;
    private Body body;

    public HTML(Head head, Body body) {
        super("html");
        this.head = head;
        this.body = body;
    }

    public HTML() {
        this(null, null);
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
        attrs.setRaw("xmlns", "http://www.w3.org/1999/xhtml");
    }

    @Override
    public Object getContent() {
        ArbitraryContent content = new ArbitraryContent();
        if (head != null)
            content.add(head);
        if (body != null)
            content.add(body);
        return content;
    }
}
