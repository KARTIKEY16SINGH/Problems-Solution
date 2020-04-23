package HackerEarth.cyclicShifts;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CyclicShifts {

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

        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            String str[] = br.readLine().split(" ");
            long N = Long.parseLong(str[0]);
            int m = Integer.parseInt(str[1]);
            char c = str[2].charAt(0);
            String Binary = Long.toBinaryString(N);
            int zero = 16-Binary.length();
            String z = "";
            for(int i=0; i<zero; i++) {
            	z += "0";
            }
            Binary = z + Binary;
            String binary[] = Binary.split("");
//            System.out.println("Binary = "+ binary);
//            System.out.println("Before Swap");
//    		for(int i=0; i<16; i++) {
//    			System.out.print(binary[i]+"  ");
//    		}
//    		System.out.println();
    		if(c == 'L')
    			solve(binary, 16, m);
    		else
    			rotateRight(binary, m);
    		
            String bin = "";
            for(int i=0; i<binary.length; i++) {
            	bin += binary[i];
            }
//            System.out.println("bin = "+bin);
            System.out.println(Integer.valueOf(bin, 2));
            
           
        }

        // Write your code here
        
    }
    
    static void solve(String binary[],int N, int d) {
    	int left = 0;
    	int right = N-1;
    	
    	while(right-left+1 > d) {
    		int A = left+d-1;
    		int B = left+d;
    		
    		int lengthA = A-left+1;
    		int lengthB = right-B+1;
//    		System.out.println("D = "+d+" left = "+left+" Right = "+right+" A = "+A+" B = "+B+" lengthA = "+lengthA+" lengthB = "+lengthB);
    		if(lengthA > lengthB) {
    			int a0 = left + lengthB-1;
    			int a1 = a0+1;
    			swap(binary, left,a0,B,right,lengthB);
    			left = a1;
    			right = right;
    			d = 2*d-(lengthA+lengthB);
    		} else if(lengthB > lengthA) {
    			int b0 = right-lengthA;
    			int b1 = b0 + 1;
    			swap(binary,left, A, b1, right, lengthA);
    			left = left;
    			right = b0;
    		} else {
    			swap(binary, left,A,B,right, lengthA);
    			return;
    		}
//    		System.out.println("D = "+d+" left = "+left+" Right = "+right+" A = "+A+" B = "+B+" lengthA = "+lengthA+" lengthB = "+lengthB);
    		
//    		System.out.println("Swap");
//    		for(int i=0; i<N; i++) {
//    			System.out.print(binary[i]+"  ");
//    		}
//    		System.out.println();
    	}
    }
    
    static void rotateRight(String [] binary, int d) {
    	if(d == 0 || d == 16) {
    		return;
    	}
    	
    	for(int i=0, j = 16-d-1; i<(16-d)/2; i++, j--) {
    		String temp = binary[i];
    		binary[i] = binary[j];
    		binary[j] = temp;
    	}
    	
//		System.out.println("Reverse B");
//		for(int i=0; i<16; i++) {
//			System.out.print(binary[i]+"  ");
//		}
//		System.out.println();
		
		for(int i=16-d, j = 15,k=0; k<d/2; i++, j--,k++) {
    		String temp = binary[i];
    		binary[i] = binary[j];
    		binary[j] = temp;
    	}
		
//		System.out.println("Reverse A");
//		for(int i=0; i<16; i++) {
//			System.out.print(binary[i]+"  ");
//		}
//		System.out.println();
		
		for(int i=0, j = 15; i<16/2; i++, j--) {
    		String temp = binary[i];
    		binary[i] = binary[j];
    		binary[j] = temp;
    	}
		
//		System.out.println("Reverse Whole");
//		for(int i=0; i<16; i++) {
//			System.out.print(binary[i]+"  ");
//		}
//		System.out.println();
    }
    
    static void swap(String [] binary, int left, int a0, int B, int right, int length) {
    	for(int i=0,j=left, k=B; i<length; i++,j++,k++) {
    		String temp = binary[k];
    		binary[k] = binary[j];
    		binary[j] = temp;
    	}
    }
}

