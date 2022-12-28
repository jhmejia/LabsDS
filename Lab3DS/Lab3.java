import java.util.*;
public class Lab3 {
	public static void main(String[] args) {
		int increments[] = null;
		Scanner scr = new Scanner(System.in);
		long swaps;
		
		while(true) {
			int n = scr.nextInt();
			if(n<0) break;
			int[] A = new int[n];
			long seed = scr.nextLong();


			
			
			


			//Insertion sort

            System.out.println("");
            System.out.println("----------------");
            System.out.println("Insertion Sort");


			increments = new int[1];
			increments[0] = 1;


            initArray(A,seed);
			long timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            long timeAfter = System.nanoTime();
            double timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Average Case: " + swaps);
			System.out.println("Time Elapsed (average case): " + timeElapsed + " seconds");

            bestCase(A);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Best Case: " + swaps);
			System.out.println("Time Elapsed (best case): " + timeElapsed + " seconds");

            worstCase(A);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Worst Case: " + swaps);
			System.out.println("Time Elapsed (worst case): " + timeElapsed + " seconds");




			//Lab 3 DS By John Henry Mejia


			//Shell sort with powers of 2 increments\

            System.out.println("");
            System.out.println("----------------");
            System.out.println("Shell sort with powers of 2 increments");
            
            // increments = new int[(int)(Math.log(n) / Math.log(2) + 1)];
            // for (int i = 1; i <= increments.length; i++)
            // {
            //     increments[i-1] = 2^ (i);
            // }
            

            increments = new int[(int)(Math.log(n) / Math.log(2) + 1)];
            int j = 0;
            for (int i = increments.length -1 ; i >-1;  i--)
            {
                increments [j] = (1 << i);
                j++;
            }
            
            initArray(A,seed);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Average Case: " + swaps);
			System.out.println("Time Elapsed (average case): " + timeElapsed + " seconds");

            bestCase(A);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Best Case: " + swaps);
			System.out.println("Time Elapsed (best case): " + timeElapsed + " seconds");

            // worstCase(A);
			// timeBefore = System.nanoTime();		
            // swaps = shellSort(A, increments);
            // timeAfter = System.nanoTime();
            // timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            // System.out.println("Worst Case: " + swaps);
			// System.out.println("Time Elapsed (worst case): " + timeElapsed + " seconds");


			//Shell sort with 2^k-1 increments
            System.out.println("");
            System.out.println("----------------");
           System.out.println("Shell sort with 2^k-1 increments");
            // increments = new int[(int)(Math.log(n) / Math.log(2) + 1)];
            // for (int i = 1; i <= increments.length; i++)
            // {
            //     increments[i-1] = 2^ (i) -1;
            // }
            
            increments = new int[(int)(Math.log(n) / Math.log(2))];
            j = 0;
            for (int i = increments.length -1 ; i >-1;  i--)
            {
                increments [j] = (1 << i);
                j++;
            }


            initArray(A,seed);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Average Case: " + swaps);
			System.out.println("Time Elapsed (average case): " + timeElapsed + " seconds");

            bestCase(A);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Best Case: " + swaps);
			System.out.println("Time Elapsed (best case): " + timeElapsed + " seconds");

            // worstCase(A);
			// timeBefore = System.nanoTime();		
            // swaps = shellSort(A, increments);
            // timeAfter = System.nanoTime();
            // timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            // System.out.println("Worst Case: " + swaps);
			// System.out.println("Time Elapsed (worst case): " + timeElapsed + " seconds");


			//Shell sort with (3^k-1)/2 increments
            System.out.println("");
            System.out.println("----------------");
            System.out.println("Shell sort with (3^k-1)/2 increments");
            // increments = new int[(int)(Math.log(n) / Math.log(2) + 1)];
            // for (int i = 1; i <= increments.length; i++)
            // {
            //     increments[i-1] = (3^i -1)/2;
            // }
            
            increments = new int[(int)(Math.log(n) / Math.log(3))];
            j = 0;
            for (int i = increments.length -1 ; i >-1;  i--)
            {
                increments [j] = (1 << i);
                j++;
            }

            initArray(A,seed);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Average Case: " + swaps);
			System.out.println("Time Elapsed (average case): " + timeElapsed + " seconds");

            bestCase(A);
			timeBefore = System.nanoTime();		
            swaps = shellSort(A, increments);
            timeAfter = System.nanoTime();
            timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            System.out.println("Best Case: " + swaps);
			System.out.println("Time Elapsed (best case): " + timeElapsed + " seconds");

            // worstCase(A);
			// timeBefore = System.nanoTime();		
            // swaps = shellSort(A, increments);
            // timeAfter = System.nanoTime();
            // timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
            // System.out.println("Worst Case: " + swaps);
			// System.out.println("Time Elapsed (worst case): " + timeElapsed + " seconds");

            
}           
		scr.close();
	}
	

    static void bestCase(int[] A) {
        for (int i =0; i < A.length; i++)
        {
            A[i] = i;
        }
    }
    static void worstCase(int[] A) {
        for (int i =0; i < A.length; i++)
        {
            A[i] = A.length - i;
        }
    }
	static void initArray(int[] A, long seed) {
		Random rnd = new Random(seed);
		for (int i=0; i<A.length; i++)
			A[i] = rnd.nextInt();
	}
	
	static long shellSort(int[] A, int increments[]) {
		long swaps = 0;
		for(int i=0; i<increments.length; i++) {
			for (int j=0; j<increments[i]; j++)
				swaps += insertionSort2(A,j,increments[i]);
		}
		return swaps;
	}
	
	static long insertionSort2(int[] A, int start, int incr) {
		long swaps = 0;
		for (int i=start+incr; i<A.length; i+=incr)
				for (int j=i; j>= incr && (A[j]<A[j-incr]); j-=incr) {
					swap(A,j,j-incr);
					swaps++;
				}
		return swaps;
	}
	
	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}

