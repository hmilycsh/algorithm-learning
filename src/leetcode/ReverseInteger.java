package leetcode;

/**
 * 参考：leetcode.com 反转整数
 * 
 * @author zhaozp
 *
 */
public class ReverseInteger {

	/**
	 * 反转整数
	 * 
	 * @param x
	 * @return
	 */
	public int reverseInteger(int x) {
		int revertNumber = 0;
		while (x != 0) {
			revertNumber = revertNumber * 10 + x % 10;
			x /= 10;
		}
		return revertNumber;
	}

	public static void main(String[] args) {
		ReverseInteger pn = new ReverseInteger();
		System.out.println(pn.reverseInteger(-11234567));
	}

}
