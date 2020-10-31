package review;

import java.util.Arrays;

/**
 * �Ͻ�˹�������·����
 * 			--- ·��������С
 * 			--- ��Ȩ֮�����
 * 			--- ���·�м���
 * @author sunyi
 * 
 * �����·�ϵ�Ȩ��������ͬʱ��¼���·����Ŀ
 * 		if ���벻ͬ���ȽϾ��룬ѡ�����
 *		if ������ͬ���Ƚϵ�Ȩ�ͣ�ѡ����
 *	
 */
public class ���·dijk����2_��Ȩ�����·����Ŀ {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int[] d = new int[maxn]; //s��������ľ��룬 d[s]=0
	static boolean[] vis = new boolean[maxn]; //���
	static int[][] G = new int[maxn][maxn];
	static int n, m, s, e;
	
	static int[] weight = new int[maxn]; //��Ȩ
	
	static int[] w = new int[maxn];
	static int[] num = new int[maxn]; //���·��������ʾ��s������������·����
	
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
		Arrays.fill(num, 0, n, 0);
		Arrays.fill(w, 0, n, 0);
	}
	
	/**
	 * dijkstra
	 * @param s  ��� ��0��ʼ
	 * 
	 * 	��һ�ο϶�ѡ���Լ�
	 */
	static void dijk(int s) {
		d[s] = 0;
		num[s]=1;
		w[s] = weight[s];
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
						w[v] = w[u] + weight[v];
						num[v] = num[u];  //s��u����Ŀ��num[u]������ʱv�ĳ����������̲���u,v֮���бߣ����Ե�v���������u��һ����ͨ��uȥ��v
					}else if(d[u] + G[u][v] == d[v]){
						if(w[v] < w[u]+weight[v]) {
							w[v] = w[u] + weight[v];
						}
						num[v] += num[u]; 
						//s��u����Ŀ��num[u]����s��v����Ŀ��num[v]����u,v֮���бߣ���s��u�ٵ�v��s��v�����·����һ�������Ե�v��������ۼ���u�ģ�����ͨ��uȥ��v
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
	
	static void printnum() {
		for (int i = 0; i < n; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
	static void printw() {
		for (int i = 0; i < n; i++) {
			System.out.print(w[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		n = 5; m = 6; s=0; e=2;
		init();
		
		G[0][1] = G[1][0] = 1;
		G[0][2] = G[2][0] = 2;
		G[0][3] = G[3][0] = 1;
		G[1][2] = G[2][1] = 1;
		G[2][4] = G[4][2] = 1;
		G[3][4] = G[4][3] = 1;
		
		weight[0] = 1;
		weight[1] = 2;
		weight[2] = 1;
		weight[3] = 5;
		weight[4] = 3;
		
		dijk(s);
		
		printd();
		printw();
		printnum();
	}
	
}
