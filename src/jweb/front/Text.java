package jweb.front;

import jweb.front.cat.*;

// Represents a text node.

public class Text implements BottomCategory {
    public final String value;

    public Text(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        // TODO escape
        return value;
    }
}
