package leetCode.from301to400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {
    Random rand;
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        rand = new Random();
    }
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        } else {
            this.map.put(val,list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (this.map.containsKey(val)) {
            int last = this.list.get(list.size()-1);
            int index = this.map.get(val);
            this.list.set(index,last);
            this.map.put(last,index);
            this.map.remove(val);
            list.remove(list.size()-1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}