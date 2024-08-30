package org.kislay;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> presenceMap = new HashMap<>();
        boolean containsDuplicate = Boolean.FALSE;
        for (int num: nums) {
            if (Boolean.TRUE.equals(presenceMap.get(num))) {
                containsDuplicate = Boolean.TRUE;
                break;
            }
            presenceMap.put(num, Boolean.TRUE);
        }
        return containsDuplicate;
    }
}
