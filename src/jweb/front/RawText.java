package jweb.front;

// Like Text, except that no escaping is done.

public class RawText extends Text {
    public RawText(String value) {
        super(value);
    }

    @Override
    public String toString() {
        // TODO escape
        return value;
    }
}
