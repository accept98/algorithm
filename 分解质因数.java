package review;

public class �ֽ������� {
	static int cnt;
	static void decompose(int x) {
		int f = 2; //��ǰ�ֽ������
		while(x != 1) {
			if(x%f==0) {
				x/=f; cnt++;
				System.out.println(f);
			}else {
				f++;
			}
 		}
	}
	
	public static void main(String[] args) {
		decompose(120);
		System.out.println(cnt);
	}
}
