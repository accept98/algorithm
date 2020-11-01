package review;
/**
 * װ or ��װ��ע���֦����������ݼ��ĸ��Ӷ�
 * @author sunyi
 *
 */
public class dfs_01���� {
	static int n; //��Ʒ��
	static int[] w, c;   //�����ͼ�ֵ
	static int V; //��������
	static int ans; //����ֵ
	/**
	 * 
	 * @param k ��ǰ������k����Ʒ
	 * @param C ��ǰ��ֵ
	 * @param W ��ǰ����
	 */
	static void dfs(int k, int C, int W) {
		if(W>V) {
			return;
		}
		if(k==n) {
			ans = Math.max(ans, C);
			return;
		}
		dfs(k+1, C+c[k], W+w[k]);  //װ
		dfs(k+1, C, W); //��װ
	}
	
	
	/**
	 * ����֦
	 * @param k ��ǰ������k����Ʒ
	 * @param C ��ǰ��ֵ
	 * @param W ��ǰ����
	 */
	static void dfswithcut(int k, int C, int W) {
		if(k==n) {
			ans = Math.max(ans, C);
			return;
		}
		dfs(k+1, C, W); //��װ
		
		if(W+w[k]<=V) { //��ǰ��
			dfs(k+1, C+c[k], W+w[k]);  //װ
		}
	}
	
	
	public static void main(String[] args) {
		n = 5; V = 8;
		w = new int[]{3, 5, 1, 2, 2};
		c = new int[]{4, 5, 2, 1, 3};
//		dfs(0, 0, 0);
//		System.out.println(ans);
		dfswithcut(0, 0, 0);
		System.out.println(ans);
	}
}
