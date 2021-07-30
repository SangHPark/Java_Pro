package Dijkstra;

public class Element implements Comparable<Element>{
	public int index;
	public int distance;
		
	Element (int index, int distance) {
		this.distance = distance;
		this.index = index;
	}
	
	@Override
	public int compareTo(Element target) {
		// TODO Auto-generated method stub
		return this.distance > target.distance ? 1 : -1;
	}
}
