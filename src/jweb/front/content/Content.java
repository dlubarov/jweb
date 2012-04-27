package jweb.front.content;

import java.util.*;

import jweb.front.cat.TopCategory;

public class Content<T extends TopCategory> {
    private List<T> children;

    public Content(T... children) {
        this.children = new ArrayList<T>();
        for (T child : children)
            add(child);
    }

    public void add(T child) {
        children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T child : children)
            sb.append(child);
        return sb.toString();
    }
}
