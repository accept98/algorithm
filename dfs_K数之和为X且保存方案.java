package review;

import java.util.ArrayList;

/**
 * N����ѡK����������K������ΪX������ж��ַ�����ѡ��ƽ��������һ��
 * @author sunyi
 *
 *	ѡ  or ��ѡ��ע��߽����
 */
public class dfs_K��֮��ΪX�ұ��淽�� {
	static int[] a;  
	static int n; 
	static int X; //��ΪX
	static int K; //K����
	static ArrayList<Integer> p = new ArrayList<Integer>(); //�����
	static ArrayList<Integer> r = new ArrayList<Integer>(); //����
	static int ans = -1; //���ս������ֹ��Ϊ0����
	/**
	 * 
	 * @param k ��ǰ���� �� k������
	 * @param s ��ǰ�Ѿ�ѡ����s������
	 * @param S ��ǰs�����ֵĺ�
	 * @param SQ ��ǰs�����ֵ�ƽ����
	 */
	static void dfs(int k, int s, int S, int SQ) {
		
		if(s == K && S == X) {
			if(SQ > ans) {
				ans = SQ;
//				System.out.println(p);
			}
//			ans = Math.max(ans, SQ);
			return;
		}
		
		if(k==n || s > K || S > X) {
			return;
		}
		
		dfs(k+1, s, S, SQ); //��ѡ
		
		p.add(a[k]);
		dfs(k+1, s+1, S+a[k], SQ+a[k]*a[k]);  //ѡ
		p.remove(p.size()-1);
	}
	
	/**
	 * 
	 * @param k ��ǰ���� �� k������
	 * @param s ��ǰ�Ѿ�ѡ����s������
	 * @param S ��ǰs�����ֵĺ�
	 * @param SQ ��ǰs�����ֵ�ƽ����
	 */
	static void dfswithpath(int k, int s, int S, int SQ, ArrayList<Integer> p) {
		
		if(s == K && S == X) {
			if(SQ > ans) {
				ans = SQ;
				r = new ArrayList<Integer>(p);
			}
//			ans = Math.max(ans, SQ);
			return;
		}
		
		if(k==n || s > K || S > X) {
			return;
		}
		
		dfswithpath(k+1, s, S, SQ, p); //��ѡ
		
		p.add(a[k]);
		dfswithpath(k+1, s+1, S+a[k], SQ+a[k]*a[k], p);  //ѡ
		p.remove(p.size()-1);
	}
	
	
	
	public static void main(String[] args) {
		a = new int[] {2, 3, 3, 4}; n = 4; 
		K = 2; X = 6;
		//Ԥ�ڽ��  2^2+4^2 > 3^2+3^2   =>    [2,2]
//		dfs(0, 0, 0, 0);
		dfswithpath(0, 0, 0, 0, new ArrayList<Integer>());
		System.out.println(r);
		System.out.println(ans);
	}
}
