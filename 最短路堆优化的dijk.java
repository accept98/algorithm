package review;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ���·���Ż���dijk {
	static int maxn = 1000+10;
	static int INF = 0x3f3f3f3f;
	
	static int[] d = new int[maxn]; //s��������ľ��룬 d[s]=0
	static boolean[] vis = new boolean[maxn]; //���
	
	static int n, m, s;
	
	static class Edge { //��
		int to;  //��һ��
		int w;  //Ȩֵ
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

	}
	
	static class Node implements Comparable<Node> {
		int p; //��ǰ��
		int d; //����s����̾���
		
		public Node(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Node node) {
			return this.d - node.d; //����С����ǰ
		}
	}
	
	
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	
	static List<Edge> G[] = new ArrayList[1005];
	
	static void dijk(int s) {
		d[s] = 0;
		
		pq.add(new Node(s, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			int u = cur.p;
			if(vis[u]) continue;
			vis[u] = true;
			List<Edge> neighbors  = G[u];
			for (int i = 0; i < neighbors.size(); i++) {
				Edge next = neighbors.get(i);
				int v = next.to;
				int w = next.w;
				if(d[u]+w<d[v]) {
					d[v]=d[u]+w;
					pq.add(new Node(v, d[v]));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
