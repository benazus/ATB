/*
	 Berat Biçer
	 19.02.2018
	 email: beratbbicer@gmail.com
*/

import java.io.IOException;
import java.lang.InterruptedException;
import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ATBParallelThreads{
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		
		List<Callable<Long>> list = new ArrayList<Callable<Long>>();
		list.add(new ATBThread1());
		list.add(new ATBThread2());
		list.add(new ATBThread3());
		list.add(new ATBThread4());
		
		list.add(new ATBThread5());
		list.add(new ATBThread6());
		list.add(new ATBThread7());
		list.add(new ATBThread8());
		
		long startTime = System.nanoTime();
		List<Future<Long>> result = executorService.invokeAll(list);
		long endTime = System.nanoTime();
		
		long primeCount = 0;
		for(Future<Long> f : result)
			primeCount += f.get().longValue();
			
		System.out.println("Total Count: " + primeCount + "; Execution Time: " + ((endTime - startTime) / 1000000000) + " seconds.");
		executorService.shutdown();
	}
}

class ATBThread implements Callable<Long>{
	Set<String> set = new HashSet<String>();
	long count = 0;
	
	public Long call(){
		return null;
	}
	
	void BinaryStrings(int size, int ones){
		set.clear();
		long notries = 0;
		while(notries != chooses(size, ones)){
			ArrayList<Integer> loc = new ArrayList<Integer>();
			boolean flag = true;
			while(flag == true && loc.size() < size){
				int location = (int)Math.floor(Math.random() * 28);		
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

			}	
			notries++;		
		}
		System.out.println("BinaryStrings(28, " + ones + "): " + set.size());
	}
	
	int chooses(int n, int r){
		double multiply = 1;
		for(int i = 0; i < n-r; i++)
			multiply = multiply * (n-i)/(n-r-i);		
		return (int)multiply;	
	}
}

class ATBThread1 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 3);
		return new Long(this.count);
	}
}

class ATBThread2 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 5);
		return new Long(this.count);
	}
}

class ATBThread3 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 9);
		return new Long(this.count);
	}
}

class ATBThread4 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 11);
		return new Long(this.count);
	}
}

class ATBThread5 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 15);
		return new Long(this.count);
	}
}

class ATBThread6 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 17);
		return new Long(this.count);
	}
}

class ATBThread7 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 21);
		return new Long(this.count);
	}
}

class ATBThread8 extends ATBThread{
	@Override
	public Long call(){
		if(set.equals(null))
			set = new HashSet<String>();
			
		this.BinaryStrings(28, 27);
		return new Long(this.count);
	}
}
