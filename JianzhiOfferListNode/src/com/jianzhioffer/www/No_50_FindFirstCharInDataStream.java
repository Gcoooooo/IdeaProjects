package com.jianzhioffer.www;

import java.util.HashMap;
import java.util.Map;

public class No_50_FindFirstCharInDataStream {
    HashMap<Character, Integer> map = new HashMap<>();
    int index = 0; //指向当前插入元素的位置
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) { //若之前已经出现过，则将该字符的value置为-1
            map.put(ch, -1);
        } else { //若之前没有出现过，则存储该字符及其下标
            map.put(ch, index);
        }
        
        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char result = '#';
        
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() != -1 && en.getValue() < minIndex) {
                minIndex = en.getValue();
                result = en.getKey();
            }
        }
        
        return result;
    }
}
