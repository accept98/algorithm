package review;

import java.util.Arrays;

/**
 * �Ͻ�˹�������·
 * @author sunyi
 *	Arrays.fill()��������߸�ֵ��Ч�ʣ��ں������ڲ�Ҳ����forѭ���ķ�ʽ ʵ�ֵ�
 */
public class ���·dijk {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s��������ľ��룬 d[s]=0
	static boolean[] vis = new boolean[maxn]; //���
	static int[][] G = new int[maxn][maxn];
	static int n, m, s;
	
	static void init() {
		Arrays.fill(d, 0, n, INF);
		Arrays.fill(vis, 0, n, false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) G[i][j]=0;
				else 
					G[i][j]=INF;
			}
		}
	}
	
	/**
	 * dijkstra
	 * @param s  ��� ��0��ʼ
	 * 
	 * 	��һ�ο϶�ѡ���Լ�
	 */
	static void dijk(int s) {
		d[s] = 0;
		
		for (int i = 0; i < n; i++) {
			
			int u = -1, mind = INF;
			
			for (int j = 0; j < n; j++) {
				if(!vis[j] && d[j] < mind) {u=j; mind=d[j];}
			}
			
			if(u==-1) return;
			
			vis[u]=true;
			
			System.out.println("         ���ʵ�ǰ����u = " + u + "   ����s = " + mind);
			
			for (int v = 0; v < n; v++) {
				if(!vis[v] && G[u][v]!=INF && d[u] + G[u][v] < d[v]) {
					d[v]=d[u]+G[u][v];
					System.out.println("�����˶���v = " + v + "   ����s = " + d[v]);
				}
			}
		}
	}
	
	static void printd() {
		for (int i = 0; i < n; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		n = 6; m = 8; s=0;
		init();
		// ����ͼ
		G[0][1] = 1;
		G[0][3] = 4;
		G[0][4] = 4;
		G[1][3] = 2;
		G[2][5] = 1;
		G[3][2] = 2;
		G[3][4] = 3;
		G[4][5] = 3;
		dijk(s);
		printd();
	}
	
}
