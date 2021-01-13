//  ########  ########  ########  ########  ########   ######    ######   ########  ########    //
//  #      #  #      #  #      #  #         #         #      #  #      #  #      #  #      #    //
//  #      #  #      #  #      #  #         #         #         #         #      #  #      #    //
//  #      #  #      #  #      #  #         #          #         #        #      #  #      #    //
//  ########  ########  #      #  #####     #####       ####      ####    #      #  ########    //
//  #         ##        #      #  #         #               #         #   #      #  ##          //
//  #         #  #      #      #  #         #                #         #  #      #  #  #        //
//  #         #    #    #      #  #         #         #      #  #      #  #      #  #    #      //
//  #         #      #  ########  #         ########   ######    ######   ########  #      #    //
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SomeOneElseCode
{// IOException
	public static void main (String[] args) throws IOException
	{
		// your code goes here
		try{
		Scanner sc =new Scanner(System.in);
		int test=sc.nextInt();
		while(test--!=0)
		{
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int ar[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        ar[i]=sc.nextInt();
		    }
		    solve(n,ar,k);
		    
		    
		}
		}
		catch(Exception e){
		    return ;
		}
	}
	
	static int solve(int n, int []ar, int k) {
		LinkedHashSet<Integer> hh1 = new LinkedHashSet<Integer>();
		int ssum=0;
//	    for(int i=0;i<n;i++)
//	    {
//	        ar[i]=sc.nextInt();
//	    }
	    Arrays.sort(ar);
	    hh1.add(ar[n-1]);
	    ssum=ar[n-1];
	    int zzaz=-1;
	    
	    for(int i=n-2;i>=0;i--)
	    {
	        LinkedHashSet<Integer> hh2=new LinkedHashSet<Integer>();
	        ssum=ssum+ar[i];
	        Iterator itr=hh1.iterator();
	        while(itr.hasNext()){
	            int pp=(int)(itr.next());
	            hh2.add(pp);
	            hh2.add(ar[i]);
	            hh2.add(pp +ar[i]);
	            if(((pp+ar[i])>=k)&&((ssum-pp-ar[i])>=k)){
	                zzaz=n-i;
	                break;
	            }
	            if(((ar[i])>=k)&&((ssum-ar[i])>=k)){
	                zzaz=n-i;
	                break;
	            }
	        }
	        if(zzaz!=-1){
	            break;
	        }
	        hh1=hh2;
	    }
	    System.out.println(zzaz);
	    return zzaz;
	}
}