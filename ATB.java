import java.util.*;
import java.math.BigInteger;

/*
	Berat Biçer
	18.02.2018
	Contact: beratbbicer@gmail.com
*/

public class ATB{
	private Set<String> set = new HashSet<String>();
	private long count = 0;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		ATB a = new ATB();
		ArrayList<Integer> primeSum = new ArrayList<Integer>();
		// 100000000000000000000000000001 is not a prime, skip
		// No prime for sum of digits = 3, skip
		
		// primeSum.add(2); // 0
		// primeSum.add(3); // 0
		primeSum.add(5);
		primeSum.add(7);
		primeSum.add(11);	
		primeSum.add(13);		
		primeSum.add(17);		
		primeSum.add(19);		
		primeSum.add(23);		
		primeSum.add(29);
		
		
		for(int i = 0; i < primeSum.size(); i++){
			a.set.clear();
			a.BinaryStrings(28, primeSum.get(i) - 2); // Generate strings
		}
		System.out.println("Total count: " + a.count);
	}

	// Creates binary strings of length "size", # of 1' s  = "ones" 
	// Strings are stored in a global set
	private void BinaryStrings(int size, int ones){
		set.clear();
		long notries = 0;
		while(notries != chooses(size, ones)){
			ArrayList<Integer> loc = new ArrayList<Integer>(); // Holds indexes of 1s in the string
			boolean flag = true;
			while(flag == true && loc.size() < size){ // generate random indexes
				int location = (int)Math.floor(Math.random() * 28); // a random index from 0 to 27			
				if(loc.contains(location) == false)
					loc.add(location);
				
				if(loc.size() >= ones)
					flag = false;
			} 
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				if(loc.contains(i) == true)
					indexes.add(1);
				else
					indexes.add(0);
			}
			
			BigInteger b = new BigInteger("1" + indexes.toString().replaceAll(", ", "").replaceAll("\\[", "").replaceAll("]", "") + "1");
			if(b.isProbablePrime(5) == true && set.contains(b.toString()) == false){
				set.add(b.toString());
				count++;
				if(count % 1000 == 0)
					System.out.println(count);
			}	
			
			notries++;		
		}
	}
	
	private int chooses(int n, int r){ // Calculates (n chooses r)
	// to avoid overflow; calculation is done step by step, with division
		double multiply = 1;
		for(int i = 0; i < n-r; i++)
			multiply = multiply * (n-i)/(n-r-i);		
		return (int)multiply;	
	}
}