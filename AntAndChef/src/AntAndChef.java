import java.io.*;
import java.lang.*;
import java.util.*;

class AntAndChef {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		while(test-- > 0) {
			LinkedList<Integer> sizeList = new LinkedList<Integer>();
			LinkedList<Integer> fPL = new LinkedList<Integer>(); // First positive value occurrence in ith row
			int N = Integer.parseInt(br.readLine().trim());
			
			int matrix[][] = new int[N][];
			
			HashMap<Integer,LinkedList<Ant>> map = new HashMap<Integer, LinkedList<Ant>>();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) { 
				String s[] = br.readLine().trim().split(" ");
				int M = Integer.parseInt(s[0]);
				matrix[i] = new int[4];
				matrix[i][0] = M;
				matrix[i][1] = M;
				boolean positive = false;
				for(int j = 0; j<M; j++) {
					int v = Integer.parseInt(s[j+1]);
//					matrix[i][j+2] = v;
					Ant ant = new Ant();
					ant.value = v;
					ant.row = i;
					ant.col = j;
					int absV = Math.abs(v);
					if (!map.containsKey(absV)) {
						map.put(absV, new LinkedList<Ant>());
					}
					map.get(absV).add(ant);
					if(!positive && v >= 0) {
						positive = true;
						matrix[i][1] = j;
					}
					if(absV > max) {
						max = absV;
					}
					if(absV < min) {
						min = absV;
					}
				}
			}
			long collision = 0;
			Object[] sortedKey = map.keySet().toArray();
					Arrays.sort(sortedKey);
//			for(int i= min; i<=max; i++) {
			for(int k=0; k<sortedKey.length; k++) {
				int i = (int) sortedKey[k];
				if(map.containsKey(i)) {
					LinkedList<Ant> temp = map.get(i);
					collision += temp.size() > 1 ? 1 : 0;
					for(Ant t : temp) {
						if(temp.size() > 1) {
							if(t.value > 0) {
								collision += Math.max(matrix[t.row][0] - (matrix[t.row][1]+matrix[t.row][3] + 1) , 0);
								matrix[t.row][3]++;
							} else {
								collision += t.col;//Math.max(t.col - matrix[t.row][2], 0);
								matrix[t.row][2]++;
							}
						} else {
							if(t.value > 0) {
								collision += matrix[t.row][1] - matrix[t.row][2];
								matrix[t.row][3]++;
							} else {
								collision += matrix[t.row][0] - (matrix[t.row][1]+matrix[t.row][3]);
								matrix[t.row][2]++;
							}
						}
					}
				}
			}
			sb.append(collision+"\n");
		}
		System.out.print(sb);
	}
}

class Ant {
	int value;
	int row;
	int col;
}