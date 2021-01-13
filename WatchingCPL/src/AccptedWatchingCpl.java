import java.io.*;
import java.lang.*;
import java.util.*;

class AccptedWatchingCpl {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int rmd = 100, cmd = 50;
		while(test-- > 0) {
//			String s[] = br.readLine().trim().split(" ");
			int N = 0;//Integer.parseInt(s[0]);//0;
			do {
	        	N = (int)( Math.random() * rmd);
	        } while (N <= 1);//Integer.parseInt(s[0]);
			int K = 0;//Integer.parseInt(s[1]);//0;
			do {
	        	K = (int)( Math.random() * rmd);
	        } while (K <= 0); //Integer.parseInt(s[1]);
			
			int a[] = new int[N];
			int suffix[] = new int[N]; // Suffix Array
//			String s1[] = br.readLine().trim().split(" ");
//			sb.append("N = "+N+"\tK = "+K+"\n"+" a[] = \t");
			for(int i=0; i<N; i++) {
				do {
		        	a[i] = (int)( Math.random() * cmd);
		        } while (a[i] <= 0);//Integer.parseInt(s[i]);
//				a[i] = Integer.parseInt(s1[i]);
//				sb.append(a[i]+"\t");
			}
//			sb.append("\n");
			//Sorting array in increasing order
			Arrays.sort(a);
			
			// Filling Suffix Arrays
			suffix[N-1] = a[N-1];
			for(int i=N-2; i>=0; i--) {
				suffix[i] = a[i] + suffix[i+1];
			}
			
			//Creating and filling DP
			int dp[][] = new int[N+1][K+1];
				// Filling Last Row with MAX_VALUE
//			for(int j=1; j<=K; j++) {
//				dp[N-1][j] = a[N-1];
//			}
			
			for(int i=N-1; i>=0; i--) {
				for(int j=1; j<=K; j++) {
					if(j<=a[i]) { 
						dp[i][j] = a[i];
					} else if (dp[i+1][j] == 0) {
						dp[i][j] = suffix[i] >= j ? suffix[i] : 0;
					} else {
						dp[i][j] = Math.min(dp[i+1][j], dp[i+1][Math.max(j-a[i], 0)] + a[i]);
					}
				}
			}
			
			
			
			// Now checking whether we can form second tower or not
			int i = N-1;
			for(; i>=0; i--) {
				if((suffix[i] - dp[i][K]) >= K) {
					break;
				}
			}
			int myR = -1;
			if(i >= 0) {
				myR = N-i;
//				sb.append("MY RESULT = "+ (N-i) + "\n");
			} else {
//				sb.append("MY RESULT = -1\n");
			}
//			sb.append(myR+"\n");
//			WatchingCPL.a = new int[N+1];
//			for( i=1; i<=N; i++) {
//				WatchingCPL.a[i] = a[i-1];
//			}
//			WatchingCPL.K = K;
//			WatchingCPL.N = N;
//			WatchingCPL.ss = new LinkedList<SubSet>();
//			WatchingCPL.solve(K,new int[N+1],N,0);
//			WatchingCPL.ss.sort(new Comparator<SubSet>() {
//        		@Override
//        		public int compare(SubSet o1, SubSet o2) {
//        			return o1.count - o2.count;
//        		}
//        	});
//			int wR = WatchingCPL.findSet();
//			sb.append("WatchingCPL Result = "+WatchingCPL.findSet()+"\n");
			
			int someOneElseCode = SomeOneElseCode.solve(N, a, K);
			if (myR != someOneElseCode) {
				sb.append("N = "+N+"\tK = "+K+"\n"+" a[] = \t");
				for(i=0; i<N; i++) {
					sb.append(a[i]+"\t");
				}
				sb.append("\n");
				for( i=0; i<=K; i++) {
					sb.append(" \t"+i);
				}
				sb.append("\n\n");
				for( i=0; i<N; i++) {
					sb.append(a[i]);
					for(int j=0; j<=K; j++) {
						sb.append("\t"+dp[i][j]);
					}
					sb.append("\n");
				}
				sb.append("\n\nMY RESULT = "+myR+"\t SomeOneElseCode = "+someOneElseCode+"\n");
				break;
			} else {
				sb.append("PASS\n");
			}
		}
		System.out.print(sb);
	}

}
