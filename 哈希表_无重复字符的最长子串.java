package review;

import java.util.HashMap;

public class ��ϣ��_���ظ��ַ�����Ӵ� {
	public static int lengthOfLongestSubstring(String s) {
		int maxlen = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0; 
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++, end++) {
			if(map.containsKey(c[i])) {
				start = Math.max(start, map.get(c[i])+1); //����s��λ��  ����ֹabba�����������
			}
			maxlen = Math.max(maxlen, end-start+1);
			map.put(c[i], end);
//			System.out.println("s = " + start + ", e = " + end);
		}
		
		return maxlen;
    }
	
	public static void main(String[] args) {
		int lengthOfLongestSubstring = lengthOfLongestSubstring("dvdf");
		System.out.println(lengthOfLongestSubstring);
	}
}
