package review;
/**
 * dijѡ��һ������s��̾���ĵ�u�󣬸���������uΪ�н��ľ���
 * ��������ɺ󣬲�����ȥ��u����� (vis[u]=true)����Ϊu�����ø��µ��Ѿ������ˣ�����Ҫ��V-S��ȥ��
 * �����v�ĸ��¶�������uΪ�н����º��µ�d����֮����и��µ�
 * ��Ȼ�´λ���ѡ��u����㣬��Ϊuʼ����s���
 * 
 * floyd���ñ�ǣ���Ϊ����������������������Ϊ�н��Ļ����Ǿ�û������
 * floyd���ǽ����е��н��ȫ����һ�飬ö�����еĵ�ԣ��ܸ��¾͸��£����ܻ���һ���н��
 * 
 * @author sunyi
 *
 */
public class ���·floyd {
	static int maxn = 1000;
	static int INF = 0x3f3f3f3f;
	static int n, m;
	
	
	static int[][] d = new int[maxn][maxn];
	
	static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(d[i][k]!=INF && d[k][j]!=INF && d[i][k] + d[k][j] < d[i][j]) {
						 d[i][j] = d[i][k] + d[k][j] ;
					}
				}
			}
		}
	}
}
