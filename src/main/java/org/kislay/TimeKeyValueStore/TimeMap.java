package org.kislay.TimeKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    
    public class TimedValue {
        int time;
        String value;
        
        TimedValue(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    private Map<String, List<TimedValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimedValue> timedValueList = this.map.getOrDefault(key, new ArrayList<>());
        timedValueList.add(new TimedValue(timestamp, value));
        this.map.put(key, timedValueList);

    }

    public String get(String key, int timestamp) {
        List<TimedValue> timedValueList = this.map.getOrDefault(key, new ArrayList<>());
        int size = timedValueList.size();
        return doBinarySearch(timedValueList.toArray(new TimedValue[size]), timestamp, size);
    }
    
    String doBinarySearch(TimedValue[] timedValues, int timestamp, int length) {
        int start = 0;
        int end = length - 1;
        String possibleSolution = "";
        while (start <= end) {
            int mid = start + (end - start)/2;
            TimedValue timedValue = timedValues[mid];
            if (timedValue.time == timestamp) {
                return timedValue.value;
            } else if (timedValue.time > timestamp) {
                end = mid - 1;
            } else {
                start = mid + 1;
                possibleSolution = timedValue.value;
            }
        }
        return possibleSolution;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.get("foo", 1);
        timeMap.get("foo", 3);
        timeMap.set("foo", "bar2", 4);
        timeMap.get("foo", 4);
        timeMap.get("foo", 5);
    }
}
