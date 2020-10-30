package review;
/**
 * ����������log(n)
 * @author sunyi
 *
 */
public class ������ {
	static int maxn = 1000;
	static int[] a = new int[maxn]; //������
	static int k; 
	static boolean[] isRemoved = new boolean[maxn]; //�Ƿ�ɸ����Ĭ��û�б�ɸ
	/**
	 * ��
	 * @param bound  �߽�
	 */
	static void table(int bound) {
		for (int i = 2; i <= bound; i++) {
			if(!isRemoved[i]) { //ûɸ��
				a[k++]=i;
				for (int j = i*i; j <= bound; j+=i) { //����ɸ��
					isRemoved[j]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		table(100);
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
