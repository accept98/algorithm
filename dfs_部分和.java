package review;

import java.util.ArrayList;

/**
 * N����������ѡ�񼸸�������û�к�Ϊsum�ķ���������У����������ʲô
 * @author sunyi
 *
 */
public class dfs_���ֺ� {
	static int[] a;  
	static int n; 
	static int SUM; //��ΪSUM
	static boolean ans = false; //���ս����Ĭ��û��
	static ArrayList<Integer> p = new ArrayList<Integer>(); //�淽��
	

	 /**
	  * 
	  * @param k  ��ǰ������k������
	  * @param S  ��ǰ�ͻ�ʣ����ٵ�0
	  */
	static void dfs(int k , int S ) {
		
		if(S == 0) {
			ans = true; 
			System.out.println(p);
			return;
		}
		
		if(k==n || S < 0) {
			return;
		}
		
		dfs(k+1, S); //��ѡ
		
		p.add(a[k]);
		dfs(k+1, S-a[k]);  //ѡ
		p.remove(p.size()-1);
	}
	
	
	
	
	
	public static void main(String[] args) {
		a = new int[] {1, 2, 4, 7, 12};   n = 5;   SUM = 13;
		//Ԥ�ڽ�� [2,4,7] , [1,12]

		dfs(0, SUM);
//		System.out.println(p);  ����Ϊ[]������Ϊ����ɺ�Ҫ���ص����ϲ㣬�Ѽ����ȫ����ɾ����
		System.out.println(ans);
	}
}
