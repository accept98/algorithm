package review;

import java.util.ArrayList;

/**
 * N�������Ӽ�����
 * @author sunyi
 *
 *	ѡ  or ��ѡ��ע��߽����
 */
public class dfs_ȫ���Ӽ� {
	static int[] a;  
	static int n; 
	static int cnt;  //�Ӽ�����

	/**
	 * 
	 * @param k ��ǰ������k����
	 * @param p �������ɵ��Ӽ�
	 */
	static void dfs(int k, ArrayList<Integer> p) {
		
		if(k==n ) {
			cnt++;
			System.out.println(p);
			return;
		}
		//ѡ�Ͳ�ѡ��˳��ᵼ�����ɵĽ����һ��
		
		p.add(a[k]);
		dfs(k+1, p);  //ѡ
		p.remove(p.size()-1);
		
		dfs(k+1, p); //��ѡ
		
	}
	
	
	
	public static void main(String[] args) {
		a = new int[] {1, 2, 3}; n = 3; 
		dfs(0, new ArrayList<Integer>());
		System.out.println(cnt);
	}
}
