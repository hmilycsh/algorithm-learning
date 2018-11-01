package leetcode;

/**
 * 参考：leetcode.com 
 * 最长公共前缀
 * 
 * @author zhaozp
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";
		String prefix = strs[0];
		for(int i=1;i<strs.length;i++){
			while(!strs[i].startsWith(prefix)){
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = new String[]{"flow","fafda","flqwe"};
		System.out.println(lcp.longestCommonPrefix(strs));

	}

}
