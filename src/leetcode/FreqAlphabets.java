package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FreqAlphabets {

    public String freqAlphabets(String s) {
        Map<String,Character> map = new HashMap<>();
        for(int i = 1; i <= 26; i++){
            map.put(""+i,(char)('a'+i-1));
        }

        String result = "";
        int N = s.length();
        for(int i = 0; i < N;){
            if(i<N-2 && s.charAt(i+2) == '#'){
                result += map.get(s.substring(i,i+2));
                i = i+3;
                continue;
            }
            result += map.get(s.substring(i,i+1));
            i++;
        }
        return result;

    }
}
