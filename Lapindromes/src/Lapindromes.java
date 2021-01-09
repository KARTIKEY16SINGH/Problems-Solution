import java.io.*;
import java.lang.*;
import java.util.*;

class Lapindromes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 0; //Integer.parseInt(br.readLine().trim());
        do {
        	test = (int)( Math.random() * 10);
        } while (test <= 0);
        
        StringBuilder sb = new StringBuilder();
        sb.append("Test = "+test+"\n");
        while(test-->0) {
//             char s[] = br.readLine().trim().toCharArray();
            // int a = Integer.parseInt(br.readLine().trim());
//        	 sb.append("\n");
        	 boolean myR = false;
        	 boolean naR = false;
        	 int N = 0;
        	 do {
        		 N = (int)(Math.random()*20);
        	 } while(N <= 1);
        	 sb.append("N = "+N+"\n");
        	 char s[] = new char[N];
//        	 sb.append(s.length+"\n");
        	 for(int i=0; i<s.length; i++) {
        		 s[i] = (char) ('a'+ ((int)(Math.random()*26)));
//        		 sb.append(s[i]);
        	 }
//        	 sb.append("\n\n");
             long f = s[0];
             long r = s[s.length-1];
             for(int i=1; i<(s.length)/2; i++) {
            	 f ^= s[i];
            	 r ^= s[s.length-1-i];
             }
             if((f^r) == 0) {
            	 myR = true;
             } else {
            	 myR = false;
             }
             
             naR = solve(s);
             
             if(naR != myR) {
            	 sb.append("N = "+s.length+"\n");
            	 for(int i=0; i<s.length; i++) {
            		 sb.append(s[i]+" ");
            	 }
            	 sb.append("\n");
            	 
            	 sb.append("myR = "+myR+"\t naR = "+naR+"\n");
            	 break;
             }
        }
        System.out.print(sb);
	}
	
	static boolean solve(char s[]) {
		int a[] = new int[26];
		int length = (s.length/2)+1;
		if((s.length & 1) == 0) {
			length = s.length/2;
		}
		for(int i=0; i<s.length/2; i++) {
			a[s[i] - 'a']++;
		}
		
		for(int i=length; i<s.length; i++) {
			a[s[i] - 'a']--;
		}
		
		for(int i=0; i<26; i++) {
			if(a[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

}
