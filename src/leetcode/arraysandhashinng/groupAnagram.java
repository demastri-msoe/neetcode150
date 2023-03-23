package leetcode.arraysandhashinng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outList = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<String>());
            map.get(key).add(s);
        }
        for (String k : map.keySet())
            outList.add(map.get(k));
        return outList;
    }
}
