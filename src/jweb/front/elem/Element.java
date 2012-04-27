package jweb.front.elem;

import jweb.front.cat.TopCategory;

public abstract class Element implements TopCategory {
    public final String elemName;

    protected Element(String elemName) {
        this.elemName = elemName;
    }

    protected abstract Object getContent();

    protected abstract void populateAttributes(AttributeSet attrs);

    public AttributeSet getAttributes() {
        AttributeSet attrs = new AttributeSet();
        populateAttributes(attrs);
        return attrs;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder("<").append(elemName).append(getAttributes()).append('>');
        if (getContent() != null)
            sb.append(getContent());
        return sb.append("</").append(elemName).append('>').toString();
    }
}
