package review;

public class �������Ӽ����ɷ� {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3};
		int n = 3;
		for (int i = 0; i < (1<<n); i++) {   //��������     0~7
			for (int j = 0; j < n; j++) {    // ����jλ
				if (  ((i>>j)&1) == 1) {     //����Ϊ1 
					System.out.print(a[j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * [1,2,3]
	 * 		000   []
	 * 		001   [1]
	 * 		010   [2]  ����2�Σ�ѡ��a[1]=2
	 * 			
	 */
	
	
	
}
