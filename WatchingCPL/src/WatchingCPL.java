import java.io.*;
import java.lang.*;
import java.util.*;

public class WatchingCPL {
	static int a[];
	static int K;
	static int N;
	static int t1, t2;
	static LinkedList<SubSet> ss;
	
    public static void main (String[] args) throws IOException {
        /* code */
        // Scanner sc = new Scanner(System.in);
        // int test = sc.nextInt();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while(test-->0) {
            String s[] = br.readLine().trim().split(" ");
            // int a = Integer.parseInt(br.readLine().trim());
            N = Integer.parseInt(s[0]);
            K = Integer.parseInt(s[1]);
            a = new int[N+1];
            s = br.readLine().trim().split(" ");
            for(int i=1; i<=N; i++) {
                a[i] = Integer.parseInt(s[i-1]);
            }
            Arrays.sort(a);
            ss = new LinkedList<SubSet>();
//            boolean dp[][] = new boolean[N+1][K+1];
//            
//            for(int i=0; i<=N; i++) {
//            	dp[i][0] = true;
//            }
//            Arrays.sort(a);
//            
//            for(int i=1; i<=N; i++) {
//            	for(int j=1; j<=K; j++) {
//            		if(a[i] >= j) {
//            			dp[i][j] = true;
//            		} else {
//            			dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i]];
//            		}
//            	}
//            }
//            print(dp);
//            
//            if(dp[N][K] == false) {
//            	sb.append("-1\n");
//            } else {
//            	LinkedList<Node> q = new LinkedList<Node>();
//            	Node head = new Node(N, K, 0, a[N], new int[N+1]);
//            	q.add(head);
////            	ArrayList<Integer> set = new ArrayList<Integer>();
//            	int []set = new int[N+1];
//            	while(!q.isEmpty()) {
//            		head = q.peek();
//            		System.out.println("q = "+q+"\thead index = "+head.index+"\tK = "+head.K+"\tcount = "+head.count+"\tdiff = "+head.diff+"\tnum = "+head.num);
//            		print(head.set);
//            		q.poll();
//            		if(head.diff <= 0) {
//            			
//            		}
//            		if(head.index>0) {
//            			if(dp[head.index-1][Math.max(0, head.diff)]) {
////            				set[head.count] = head.num;
//            				head.set[head.count] = head.num;
//            				Node n = new Node(head.index-1, head.diff, head.count+1, a[head.index-1], head.set);
//            				q.addFirst(n);
//            			}
//            			if(dp[head.index-1][Math.max(0, head.K)]) {
////            				set[head.count] = 0;
//            				head.set[head.count] = 0;
//            				Node n = new Node(head.index-1, head.K, head.count, a[head.index-1], head.set);
//            				q.addFirst(n);
//            			}
//            		}
//            	}
            	
            	solve(K,new int[N+1],N,0);
            	ss.sort(new Comparator<SubSet>() {
            		@Override
            		public int compare(SubSet o1, SubSet o2) {
            			return o1.count - o2.count;
            		}
            	});
            	
//            	System.out.println("Sorted List = "+ss);
//            	print(ss.toArray(new SubSet[N+1]));
            	sb.append(findSet()+"\n");
//            }
            
        }
         System.out.print(sb);
    }
    
    static void solve(int K, int []set, int index, int count) {
//    	System.out.println("K = "+K+"\t index = "+index+"\t count = "+count);
//    	System.out.print("Loop Set :- ");
//    	print(set);
    	if(K<=0) {
//    		System.out.println("K = "+K+"\t index = "+index+"\t count = "+count);
//    		print(set);
    		SubSet s = new SubSet();
    		s.count = count;
    		s.set = set.clone();
    		ss.add(s);
    		return;
    	}
//    	for(int i=index; i<=N; i++) {
    	if(index>0) {
    		set[count] = index;
    		solve(K-a[index],set,index-1,count+1);
    		set[count] = 0;
    		solve(K, set, index-1, count);
    	}
//    	}
    }
    
    static int findSet() {
    	for(int i = 0; i< ss.size(); i++) {
    		boolean a[] = new boolean[N+1];
    		SubSet one = ss.get(i);
    		for(int k =0; k<one.count; k++) {
    			a[one.set[k]] = true;
    		}
//    		System.out.print("\nOne Count = "+one.count+"\t One ");
//    		print(one.set);
    		int j = i+1;
//    		boolean allOk = false
    		for(; j<ss.size(); j++) {
    			SubSet two = ss.get(j);
    			boolean allOk2 = true;
//    			System.out.println("\nTwo Count = "+two.count+"\t Two ");
//    			print(two.set);
    			for(int k =0; k<two.count; k++) {
        			if(a[two.set[k]]) {
        				allOk2 = false;
        				break;
        			}
        		}
    			
    			if(allOk2) {
    				return one.count+two.count;	
    			}
    		}
    	}
    	
    	return -1;
    }
    
    static void print(boolean a[][]) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n");
    	for(int i = 0; i<a.length; i++) {
    		for(int j=0; j<a[i].length; j++) {
    			sb.append(a[i][j]+"\t");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    
    static void print(int a[]) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Set :- \n");
    	for(int i = 0; i<a.length; i++) {
//    		for(int j=0; j<a[i].length; j++) {
    			sb.append(a[i]+"\t");
//    		}
//    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    
    static void print(SubSet a[]) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Set :- \n");
    	for(int i = 0; i<a.length; i++) {
//    		for(int j=0; j<a[i].length; j++) {
    			sb.append(a[i].count+"\t");
//    		}
//    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
}

class Node {
	int index;
	int K;
	int count;
	int diff;
	int num;
	int set[];
	Node(int i, int k, int c, int n, int set[]) {
		index = i;
		K = k;
		count = c;
		num = n;
		diff = k-n;
		this.set = set;
	}
}

class SubSet {
	int count;
	int [] set;
}
/*
2
8 38
7 8 19 6 9 5 10 20
4 5
2 10 4 9


1
4 5
2 10 4 9
*/