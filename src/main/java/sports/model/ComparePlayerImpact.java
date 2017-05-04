package sports.model;

import java.util.Comparator;

/**
 * Created by obinnaasinugo on 4/30/17.
 */
public class ComparePlayerImpact implements Comparator<Object> {

    /**
     * Compare two Player objects.
     */
    @Override
    public int compare(Object o1, Object o2) {
        NbaPlayer p1 = (NbaPlayer) o1;
        NbaPlayer p2 = (NbaPlayer) o2;

        return -1*Double.compare(p1.getImpact(), p2.getImpact());
    }

}

