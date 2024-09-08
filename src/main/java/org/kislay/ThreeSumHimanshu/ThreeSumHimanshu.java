package org.kislay.ThreeSumHimanshu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class ThreeSumHimanshu {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            HashMap<Integer, List<Integer>> mp = new HashMap<>();
            for(int i=0; i<nums.length; ++i) {
                if(mp.get(nums[i]) == null) {
                    mp.put(nums[i], new ArrayList<>(List.of(i)));
                } else {
                    mp.get(nums[i]).add(i);
                }
            }
            for(int i=0;i<nums.length;++i){
                for(int j=i+1; j<nums.length; ++j) {
                    int k = -1*nums[i] - nums[j];;
                    if(mp.get(k) != null) {
                        int ele = 0;
                        for(int e : mp.get(k)) {
                            if(e != i && e > j) {
                                ele = e;
                                break;
                            }
                        }
                        List<Integer> tempList = new ArrayList<>(List.of(nums[i], nums[j], nums[ele]));
                        Collections.sort(tempList);
                        if(ele > i) {
                            boolean add = true;
                            for(List<Integer> x : result) {
                                if(Objects.equals(x.get(0), tempList.get(0)) && Objects.equals(x.get(1), tempList.get(1)) && Objects.equals(x.get(2), tempList.get(2))) {
                                    add = false;
                                    break;
                                }
                            }
                            if(add) {
                                result.add(tempList);
                            }
                        }
                    }
                }
            }
            return result;
        }


}
