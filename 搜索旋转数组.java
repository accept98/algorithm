package review;

public class ������ת���� {
	static int[] A = {6,7,0,1,3,4,5};
	static int x = 0;
	static int l, r, len;
	public static void main(String[] args) {
		l = 0; r = A.length-1; len = A.length;
		int res = binarySearch();
		System.out.println(res);
	}
	private static int binarySearch() {
		while(l<=r) {
			int mid = (r-l)/2+l;
			if(A[mid]==x) {
				return mid;
			}
		   if(A[mid]<A[len-1]){ //�������
				if(x>A[mid] && x<=A[len-1]) { //��
					l = mid+1; //��������û��Ҫ��
				}else {
					r = mid;
				}
			}
			else { //�ұ�����
				if(x>=A[0] && x<=A[mid]) { //��
					r = mid; //�ұ������û��Ҫ��
				}else {
					l = mid+1;
				}
			}
		}
		return -1;
	}
}
