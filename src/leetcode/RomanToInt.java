package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考：leetcode.com
 * 
 * 罗马数字转换成整数
 * 判断相邻2个元素，如果左边的比较大则相加(i+=1)，如果右边的比较大则相减(i+=2)
 * 
 * eg:LVIII --> 58
 * 
 * @author zhaozp
 *
 */
public class RomanToInt {

	public int romanToInt(String s) {
		// 初始化
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0;
		int i = 0;
		while (i < s.length() - 1) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			if (map.get(c1) < map.get(c2)) {
				sum = sum + (map.get(c2) - map.get(c1));
				i += 2;
			} else {
				sum += map.get(c1);
				i++;
			}
		}

		// 如果最后一次是单个则会少计数1次
		if (i == s.length() - 1) {
			char c1 = s.charAt(i);
			sum += map.get(c1);
		}

		return sum;
	}

	public static void main(String[] args) {
		RomanToInt ri = new RomanToInt();
		System.out.println(ri.romanToInt("LVIII"));
	}

}
