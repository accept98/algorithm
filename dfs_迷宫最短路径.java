package review;

public class dfs_�Թ����·�� {
	static int m, n; // mxn�ľ���
	static int[][] G;
	static boolean[][] vis; //���
	static int ans = 0x3f3f3f3f; //������
	
	static int[] X = {1, -1, 0, 0};
	static int[] Y = {0, 0, 1, -1};
	
	static boolean check(int x, int y) {
		if(x >= m || x < 0 || y >= n || y < 0 || G[x][y]==1 || vis[x][y]) {
			return false;
		}
		return true;
	}
	
	static int sx, sy, ex, ey;
	
	/**
	 * 
	 * @param x
	 * @param y  ��ǰ����λ��(x,y)
	 * @param step ��ǰ�Ѿ����˶��ٲ�
	 */
	static void dfs(int x, int y, int step) {
		if(x==ex && y==ey) {
			ans = Math.min(ans, step);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + X[i], ny = y + Y[i];
			if( check(nx, ny) ) {
				vis[nx][ny]=true;
				dfs(nx, ny, step + 1);
				vis[nx][ny]=false;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		m = 5; n = 4;
		
		G = new int[][]{
				{0,0,1,0}, 
				{0,0,0,0},
				{0,0,1,0}, 
				{0,1,0,0},
				{0,0,0,1},
		};
		
		vis = new boolean[m][n];
		
		sx = 0; sy = 0; ex = 3; ey = 2;
		
		vis[sx][sy] = true;
		dfs(sx, sy, 0);
		System.out.println(ans); //2
	}
	
	
}
