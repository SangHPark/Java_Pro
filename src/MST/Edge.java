package MST;

public class Edge implements Comparable<Edge>{
	public int[] node = new int[2];
	public int distance;
	
	public Edge (int[] pnode, int pdistance) {
		this.node = pnode;
		this.distance = pdistance;
	}
	
	@Override
	public int compareTo(Edge target) {
		// TODO Auto-generated method stub
		return this.distance <= target.distance ? -1 : 1;
	}
	
	

}
