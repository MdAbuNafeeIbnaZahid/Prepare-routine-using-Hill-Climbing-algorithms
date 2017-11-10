package Routine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nafee on 11/10/17.
 */
public class Period {

    private List<Element> elements = new ArrayList<Element>();

    public Period() {
    }

    boolean add( Element element )
    {
        boolean bool = elements.add(element);
        return bool;
    }

    boolean doesContain(Element element)
    {
        boolean bool = elements.contains(element);
        return bool;
    }

    boolean remove(Element element)
    {
        boolean bool = elements.remove(element);
        return bool;
    }

    Iterator<Element> getIterator()
    {
        return elements.iterator();
    }
}
