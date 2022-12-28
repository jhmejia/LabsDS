import java.util.Scanner;
import java.util.Arrays;
public class Lab2 {
	static int[] heap;
	public static void main(String args[]) {
		Scanner scr = new Scanner(System.in);
		while(true) {
			long swaps = 0;
			int n = scr.nextInt();
			if (n < 0) break;
			int levels = (int)(Math.log(n) / Math.log(2) + 1);
			// Do not allow partial levels
			n = (1 << levels) - 1;
			System.out.println(n + " " + levels);



			// Fill an array and create a heap in it
			//	put your code here

			System.out.println("Creating an array and then making it a heap: ");
			heap = new int[n];
			
			for (int i = 0; i < n; i++)
			{
				heap[i] = n - i;
			}
			long timeBefore = System.nanoTime();
			System.out.println("Swaps = " + heapBuild(levels));
			long timeAfter = System.nanoTime();
			double timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
			System.out.println("Time Elapsed: " + timeElapsed + " seconds");


			
			// Start with an empty heap and add one item at a time
			//	put your code here
			System.out.println("Creating a heap item by item: ");
			swaps = 0;
			timeBefore = System.nanoTime();
			for (int i = 0; i < n; i++)
			{
				
				heap [i] = n;
				swaps += bubbleUp(i);
			}

			timeAfter = System.nanoTime();
			timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
			System.out.println("Swaps = " + swaps);
			System.out.println("Time Elapsed: " + timeElapsed + " seconds");

			System.out.println("-----------------");
		}
		scr.close();
	}
	

	static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	



//build a heap in an array that has been filled with 2^levels-1 items
//return the number of swaps
	static long heapBuild(int levels) {
		long total = 0;
		int end = (1 << levels-1) - 1;
		for(int i=0; i<levels-1; i++) {
			int start = end >> 1;
			for (int j=start; j<end; j++) {
				total += bubbleDown(j);
			}
			end = start;
		}
		return total;
	}
	static long bubbleDown(int p) {
		if (2*p+1 >= heap.length) return 0;
		int leftChild = 2*p + 1;
		int rightChild = 2*p + 2;
		if (heap[leftChild] < heap[rightChild]) {
			if (heap[p] > heap[leftChild]) {
				swap(p,leftChild);
				return 1 + bubbleDown(leftChild);
			}
			return 0;
		}
		if (heap[p] > heap[rightChild]) {
			swap(p,rightChild);
			return 1 + bubbleDown(rightChild);
		}
		return 0;
	}


//reheap after adding an item
//return the number of swaps
	static long bubbleUp(int p) {
		if (p == 0) return 0;
		int parent = (p-1)/2;
		if (heap[parent] < heap[p]) return 0;
		swap(parent,p);
		return 1 + bubbleUp(parent);
	}
}
