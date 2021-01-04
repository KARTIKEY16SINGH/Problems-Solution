package HackerEarth.ChangesInAString;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class ChangesInAString {

	public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String name = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner sc = new Scanner(System.in);
   //     String name = s.nextLine();                 // Reading input from STDIN
 //       System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
//            int N = Integer.parseInt(br.readLine());
//            String inputString = br.readLine();
//            
//            char c [] = inputString.toCharArray();
////            System.out.println();
////            for(int i=0; i<N; i++){
////                System.out.print(c[i]+" ");
////            }
            int N = 4;
            char c[] = new char[N];
            for(int i=0;i<N; i++) {
            	int r = (int) (Math.random()*100);
            	if(r%2 == 0) {
            		c[i] = 'A';
            	} else {
            		c[i] = 'B';
            	}
            	
            }
            System.out.println();
            for(int i=0; i<N; i++){
            	System.out.print(c[i]+" ");
            }
            System.out.println();
            System.out.println(solve(c,N));
        }
        
        

        // Write your code here

    }
	
	static int solve(char [] ch, int N) {
    	int count[] = new int[2] ;
    	
    	int faulty[] = new int[2];
    	
    	for(int first = -1, middle=0, last = 1; middle<N; middle++, first++, last++) {
    		count[ch[middle] - 'A']++;
    		if(N==1) {
    			return 0;
    		}
    		if(first == -1) {
    			if(ch[middle] == 'B' && ch[last] == 'A') {
    				faulty[1]++;
    			}
    		}else if(last==N) {
    			if(ch[middle] == 'A' && ch[first] == 'B') {
    				faulty[0]++;
    			}
    		} else {
    			if(ch[first]=='A' && ch[middle]=='B' && ch[last]=='A')
    				faulty[1]++;
    			if(ch[first]=='B' && ch[middle]=='A' && ch[last]=='B')
    				faulty[0]++;
    		}
    	}
    	
 level :   	for(int i = 0; i<2; i++) {
    		System.out.println("Count["+i+"] = "+count[i]+"\t faulty["+i+"] = "+faulty[i]);
    	}
    	
    	return faulty[0] >= faulty[1] ? faulty[0] : faulty[1];
    }
}