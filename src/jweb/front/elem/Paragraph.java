package jweb.front.elem;

import jweb.front.Text;
import jweb.front.cat.FlowCategory;
import jweb.front.content.*;

public class Paragraph extends Element implements FlowCategory {
    public final FlowContent content;

    public Paragraph(FlowCategory... children) {
        super("p");
        content = new FlowContent(children);
    }

    public Paragraph(String text) {
        this(new Text(text));
    }

    @Override
    protected void populateAttributes(AttributeSet attrs) {
    }

    @Override
    protected Object getContent() {
        return content;
    }
}
