package leetcode;

import javafx.util.Pair;

public class CountAndSay {

	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String ret = "1";
		for (int i = 2; i <= n; i++) {
			String cur = "";
			int count = 1;
			int j = 1;
			for (; j < ret.length(); j++) {
				if (ret.charAt(j) == ret.charAt(j - 1)) {
					count++;
				} else {
					cur = cur + "" + count + ret.charAt(j - 1);
					count = 1;
				}
			}
			cur = cur + "" + count + ret.charAt(j - 1);
			ret = cur;
		}
		Pair<String, Integer> p = new Pair<>("1", 1);
		return ret;

	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int len_a = a.length();
		int len_b = b.length();
		int i = len_a - 1;
		int j = len_b - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int abit = Integer.valueOf(a.charAt(i));
			int bbit = Integer.valueOf(b.charAt(j));
			int sum = carry + abit + bbit;
			if (sum >= 2) {
				carry = sum / 2;
				sb.append(sum % 2);
			} else {
				sb.append(sum);
			}
			i--;
			j--;
		}

		while (i >= 0) {
			int abit = Integer.valueOf(a.charAt(i));
			int sum = carry + abit;
			if (sum >= 2) {
				carry = sum / 2;
				sb.append(sum % 2);
			} else {
				sb.append(sum);
			}
			i--;
		}

		while (j >= 0) {
			int abit = Integer.valueOf(b.charAt(i));
			int sum = carry + abit;
			if (sum >= 2) {
				carry = sum / 2;
				sb.append(sum % 2);
			} else {
				sb.append(sum);
			}
			j--;
		}
		return sb.toString();
	}

	public int lengthOfLastWord(String s1) {
		String s = s1.trim();
		int len = s.length();
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
			} else {
				if (i != len - 1) {
					break;
				}
			}
		}

		return count;
	}

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int times = 1;
		int sum = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum += digits[i] * times;
			times *= 10;
		}

		sum = sum + 1;
		int[] ans = new int[len + 1];
		for (int i = len; i >= 0; i--) {
			ans[i] = sum % 10;
			sum /= 10;
		}

		if (ans[0] == 0) {
			int[] ans_new = new int[len];
			for (int i = 0, j = 1; j < ans.length; j++, i++) {
				ans_new[i] = ans[j];
			}
			return ans_new;
		} else {
			return ans;
		}

	}

	public int mySqrt(int x) {
		double left = 0;
		double right = x;
		double mid = 0;

		while (left <= right) {
			mid = left + (right - left) / 2;
			double y = mid * mid;
			if (y >= x && y <= x + 0.000001) { // 预设一个精度
				System.out.println(mid);
				return (int) mid;
			} else if (y > x) {
				right = mid;
			} else {
				left = mid;
			}
		}

		return (int) mid;
	}

	
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int end = n%26;
            char c = (char)('A'+end -1);
            sb.append(c);
            n/=26;
        }
        sb.reverse();
        return sb.toString();
    }
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.convertToTitle(28));
		
		
		//System.out.println(cas.mySqrt(1));
		// System.out.println(cas.lengthOfLastWord("b a "));

		// cas.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
	}

}
