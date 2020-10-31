package review;

import java.util.Arrays;

/**
 * �Ͻ�˹�������·����
 * 			--- ·��������С
 * 			--- ��Ȩ֮�����
 * 			--- ���·�м���
 * @author sunyi
 * 
 * �����·�ϻ������ٵ�
 * 		if ���벻ͬ���ȽϾ��룬ѡ�����
 *		if ������ͬ���Ƚϻ��ѣ�ѡ��ʡ��
 *	����cost�ĳ�ʼ��
 *		���Գ�ʼ��Ϊ0��Ҳ���Գ�ʼ��ΪINF
 *	INF�ܺý��ͣ�Ĭ������䶼������Ļ��ѣ�ͬʱҲĬ�ϳ����㵽������������ٻ���Ҳ�������
 *  0����Ŀ�����뼸���ߣ���Ӧ�ľͻ����뼸��Ȩ��
 *  		���������0 Ҳ���޹ؽ�Ҫ�ģ���Ϊcost[i][j]Ϊ0��ͬʱ��û�бߴ��ڵģ�Ҳ����û�бߵ�G[i][j]����INF���Ͳ�����뵽���£���Ϊ��һ�����޷�ͨ��G[u][v]!=INF
 *  			c[v] = c[u] + cost[u][v] �ܸ��µıض���u v֮���бߵģ���u v֮��ߵ�Ȩ���������ʱ��϶������ˣ��������Ϊ0�����ĸ�������
 */
public class ���·dijk����1_���� {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s��������ľ��룬 d[s]=0
	static boolean[] vis = new boolean[maxn]; //���
	static int[][] G = new int[maxn][maxn];
	static int n, m, s, e; //�����յ�
	
	static int[][] cost = new int[maxn][maxn]; //����
	
	static int[] c = new int[maxn]; //s������������ٻ���
	
	
	static void init() {
		Arrays.fill(d, 0, n, INF);
		Arrays.fill(vis, 0, n, false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) {
					G[i][j]=0; 
				}
				else {
					G[i][j]=INF; 
				}
			}
		}
		Arrays.fill(c, 0, n, INF);
	}
	
	/**
	 * dijkstra
	 * @param s  ��� ��0��ʼ
	 * 
	 * 	��һ�ο϶�ѡ���Լ�
	 */
	static void dijk(int s) {
		d[s] = 0;
		c[s]=0;
		for (int i = 0; i < n; i++) {
			
			int u = -1, mind = INF;
			
			for (int j = 0; j < n; j++) {
				if(!vis[j] && d[j] < mind) {u=j; mind=d[j];}
			}
			
			if(u==-1) return;
			
			vis[u]=true;
			
			
			for (int v = 0; v < n; v++) {
				if(!vis[v] && G[u][v]!=INF ) {
					if(d[u] + G[u][v] < d[v]) {
						d[v]=d[u]+G[u][v];
						c[v] = c[u] + cost[u][v];
					}else if(d[u] + G[u][v] == d[v]){
						c[v] = c[u] + cost[u][v];
					}
				}
			}
		}
	}
	
	static void printd() {
		for (int i = 0; i < n; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	static void printc() {
		for (int i = 0; i < n; i++) {
			System.out.print(c[i] + " ");
		}
	}
	
	
	public static void main(String[] args) {
		n = 4; m = 5; s=0; e=3;
		init();
		
		G[0][1] = G[1][0] = 1;
		G[1][3] = G[3][1] = 2;
		G[0][3] = G[3][0] = 4;
		G[0][2] = G[2][0] = 2;
		G[2][3] = G[3][2] = 1;
		
		cost[0][1] = cost[1][0] = 20;
		cost[1][3] = cost[3][1] = 30;
		cost[0][3] = cost[3][0] = 10;
		cost[0][2] = cost[2][0] = 20;
		cost[2][3] = cost[3][2] = 20;
		
		
		dijk(s);
		printd();
		
		System.out.println(d[e] + " " + c[e]);
	}
	
}
