package 数据结构不难.ch12图论;

public class Edge<T> implements Comparable<Edge> {
	public T start;
	public T end;
	public int distance;
	
	public Edge (T start, T end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
}
