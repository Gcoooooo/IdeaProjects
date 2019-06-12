package com.jianzhioffer.www;

import java.util.HashMap;
import java.util.Map;

public class No_50_FindFirstCharInDataStream {
    HashMap<Character, Integer> map = new HashMap<>();
    int index = 0; //ָ��ǰ����Ԫ�ص�λ��
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) { //��֮ǰ�Ѿ����ֹ����򽫸��ַ���value��Ϊ-1
            map.put(ch, -1);
        } else { //��֮ǰû�г��ֹ�����洢���ַ������±�
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
