package leetcode;

/**
 * 参考：leetcode.com
 * 判断一个整数是否回文数字
 * 
 * @author zhaozp
 *
 */
public class PalindromeNumber {

	/**
	 * 判断一个整数是否回文数字
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		// 1.排除掉负数、以0结尾的数(0除外)
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertNumber = 0;
		while (x > revertNumber) {
			revertNumber = revertNumber * 10 + x % 10;
			x = x / 10;
		}
		
		//需要考虑偶数位或者奇数位
		return x == revertNumber || x == revertNumber / 10;
	}

	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(12321));
	}

}
