package Dijkstra;

public class dEdge implements Comparable<dEdge>{
	public int[] node= new int[2];
	public int distance;
	
	public dEdge(int[] pnode, int pdistance) {
		this.node = pnode;
		this.distance = pdistance;
	}
	
	@Override
	public int compareTo(dEdge target) {
		// TODO Auto-generated method stub
		return this.distance <= target.distance ? -1 : 1;
	}
	
	
	

}
