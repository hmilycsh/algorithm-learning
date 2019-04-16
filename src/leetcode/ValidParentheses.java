package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * @author zhaozp
 *
 */
public class ValidParentheses {

	private static final Map<Character, Character> map = new HashMap<>();
	static {
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else {
				if (i == 0) {
					return false;
				} else {
					if (stack.isEmpty()) {
						return false;
					} else {
						char top = stack.pop();
						if (top != map.get(c)) {
							return false;
						}
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("[]}"));
	}

}
