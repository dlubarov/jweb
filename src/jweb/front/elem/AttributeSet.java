package jweb.front.elem;

import java.util.*;

public class AttributeSet {
    private final Map<String, String> attrs;

    public AttributeSet() {
        attrs = new HashMap<String, String>();
    }

    public void setRaw(String attr, String value) {
        if (value == null) return;
        attrs.put(attr, value);
    }

    public void set(String attr, String value) {
        if (value == null) return;
        // FIXME: escape value
        setRaw(attr, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : attrs.entrySet()) {
            String k = pair.getKey(), v = pair.getValue();
            sb.append(String.format(" %s=\"%s\"", k, v));
        }
        return sb.toString();
    }
}
