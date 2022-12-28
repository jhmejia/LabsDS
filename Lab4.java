/* This is a program to explore collision resolution in hashing
* NUMITEMS is the number of items to be inserted
* PRIME1 should be a prime number that is larger than twice NUMITEMS
*        quadratic collision resolution will not work otherwise
* PRIME2 is used in double hashing and must be less than PRIME1
* SEED is the seed for the random number generator
*      it is needed to compare the methods for the same list of pseudo random numbers
*      change the value to get a different sequence
*      change "new Random(SEED)" to "new Random()" to get a different sequence every time
*/


import java.util.*;

public class Lab4 {
	static final int NUMITEMS = 500000;
	static final int PRIME1 = 10000019;
	static final int PRIME2 = 410551;
	static final int SEED = 159637428;
	static Random rand;

	public static void main(String[] args) {
		System.out.println("Linear Probing");
		rand = new Random(SEED);


		long timeBefore = System.nanoTime();	
		HashLinear<Integer> tableLinear = new HashLinear<Integer>(PRIME1);
		hashIt(tableLinear);
		long timeAfter = System.nanoTime();
		double timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;;
		System.out.println("Time Elapsed (Linear Probing): " + timeElapsed + " seconds");

		System.out.println("Quadratic Probing");
		rand = new Random(SEED);
		timeBefore = System.nanoTime();	
		HashQuadratic<Integer> tableQuadratic = new HashQuadratic<Integer>(PRIME1);
		hashIt(tableQuadratic);
		timeAfter = System.nanoTime();
        timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
		System.out.println("Time Elapsed (Quadratic Probing): " + timeElapsed + " seconds");



		System.out.println("Double Hash Probing");
		rand = new Random(SEED);
		timeBefore = System.nanoTime();	
		HashDouble<Integer> tableDouble = new HashDouble<Integer>(PRIME1,PRIME2);
		hashIt(tableDouble);
		timeAfter = System.nanoTime();
        timeElapsed = (timeAfter - timeBefore)/1000000000.0 ;
		System.out.println("Time Elapsed (Double Hash Probing): " + timeElapsed + " seconds");
	}
	
	static void hashIt(Hash<Integer> table) {
		int total = 0;
		for(int i=0; i<NUMITEMS; i++) {
			int item = rand.nextInt();
			int probes = table.insert(item);
// uncomment the following line to see each item being inserted
//			System.out.println(item + " required " + probes + " collision resolutions");
			total = total + probes;
		}
		System.out.println("Hash table created after "+ total + " collision resolutions");
	}
	
	

}

class Hash<E> {
	int capacity;
	E[] table;
	int numCollisions;
	
	public Hash(int size) {
		capacity = size;
		table = (E[])new Object[size];
	}
	
	public int insert(E it) {
		numCollisions = 0;
		int h = Math.abs(it.hashCode()) % capacity;
		if (table[h] == null) {
			table[h] = it;
			return numCollisions;
		}
		if (table[h].equals(it)) return numCollisions;	// don't allow duplicates
		while(table[h] != null && !table[h].equals(it)) {
			numCollisions++;
			h = increment(it, h);
		}
		if (table[h] == null) {
			table[h] = it;
		}
		return numCollisions;
	}

	int increment(E it, int h) {
		return (h + 1) % capacity;
	}
	
}

class HashLinear<E> extends Hash<E> {
	public HashLinear(int size) {
		super(size);
	}
	
}

class HashQuadratic<E> extends Hash<E> {
	public HashQuadratic(int size) {
		super(size);
	}
	
	int increment(E it, int h) {
		return (h + 2 * numCollisions - 1) % capacity;
	}

	
}

class HashDouble<E> extends Hash<E> {
	int mod;
	public HashDouble(int size, int m2) {
		super(size);
		mod = m2;
	}
	
	int increment(E it, int h) {
		int hash2 = mod - (Math.abs(it.hashCode()) % mod);
		return (h + hash2) % capacity;
	}

}