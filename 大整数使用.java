package review;

import java.math.BigInteger;

public class ������ʹ�� {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("100");
		System.out.println(a);
		BigInteger b = new BigInteger("37");
		System.out.println(b);
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));
		System.out.println(a.mod(b));
		System.out.println(a.gcd(b));
		System.out.println(a.pow(3));
		a = b; //����ֱ�Ӹ�ֵ
		System.out.println(a + " " + b);
	}
}
