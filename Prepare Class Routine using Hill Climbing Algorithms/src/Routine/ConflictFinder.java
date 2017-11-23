package Routine;

import Copy.UnoptimizedDeepCopy;

import java.util.*;

/**
 * Created by nafee on 11/10/17.
 */
public abstract class ConflictFinder {

    abstract int getVal(Element element); // it could be class, teacher, room

    private Iterator<Integer> getListValIterator( Iterator<Element> iterator )
    {
        List<Integer> vals = new ArrayList<Integer>();
        while (iterator.hasNext())
        {
            Element element = iterator.next();
            int v = getVal(element);  // this could be class, teacher or room
            vals.add(v);
        }
        return vals.iterator();
    }

    private Iterator<Integer> getConflictCntIterator( Iterator<Integer> iterator )
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (iterator.hasNext() )
        {
            Integer integer = iterator.next();
            map.merge(integer, 1, Integer::sum); // it is a java 8 only feature
        }
        Collection<Integer> conflictCntCollection = map.values();
        Iterator conflictCntIterator = conflictCntCollection.iterator();
        return conflictCntIterator;
    }

    private int getSingleWeightCost( Iterator<Integer> conflictCntIterator )
    {
        int cost = 0;
        while (conflictCntIterator.hasNext())
        {
            int conflict = conflictCntIterator.next();
            cost += Integer.max(conflict-1, 0);
        }
        return cost;
    }





    final int getSingleConflictCost(Iterator<Element> iterator, int weight)
    {
        Iterator<Integer> listValIterator = getListValIterator(iterator);
        Iterator<Integer> conflictCntIterator = getConflictCntIterator(listValIterator);
        int singleWeightCost = getSingleWeightCost(conflictCntIterator);
        return singleWeightCost * weight;
    }


    Iterator<Element> getSingleConflictingElementsIterator(Iterable<Element> elements)
    {
        Iterator<Element> ret;

        Iterator<Integer> listValIterator = getListValIterator( elements.iterator() );
        Map<Integer, Integer> cntMap = new HashMap<>();

        while (listValIterator.hasNext())
        {
            Integer val = listValIterator.next();
            cntMap.merge(val, 1, Integer::sum);
        }
        Set<Element> singleConflictingElements = new HashSet<Element>();

        Iterator<Element> elementIterator = elements.iterator();
        while (elementIterator.hasNext())
        {
            Element element = elementIterator.next();
            int elementVal = getVal(element);
            if ( cntMap.getOrDefault(elementVal, 0) > 1 )
            {
                singleConflictingElements.add(element);
            }
        }

        ret = singleConflictingElements.iterator();
        return ret;
    }


}
