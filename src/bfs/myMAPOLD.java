package bfs;

public class myMAPOLD {

		int xpos; int ypos;
		int v_cnt;
		int zeroornot;
		boolean visited = false;
		boolean broken = false;
		
		public myMAPOLD (int x, int y, int vc, boolean v, boolean b) {
			this.xpos = x;
			this.ypos = y;
			this.visited = v;
			this.broken = b;
			this.v_cnt = vc;
		}
}
