package com.pawel.Schronisko_Spring.utils;

import java.util.Set;

public class Ids {

    public static int getNewId(Set<Integer> keys)
    {
        if (keys.isEmpty())
        {
            return 0;
        } else
        {
            Integer lastKey = keys.stream().max((o1,o2)->o1.compareTo(o2)).get();
            return lastKey+1;
        }
    }
}
