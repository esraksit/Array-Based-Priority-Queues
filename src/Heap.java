import java.util.concurrent.ThreadLocalRandom;

public class Heap {
	
	
	private final static int CAP=100;
	private int []list= new int [CAP];
	private int size=0;
	
	public void MinHeap() {
		
	}
	
	private static int Parent(int n) {
		return(n-1)/2;
	}
	
	private static int Left(int n) {
		return (2*n)+1;
	}
	
	private static int Right(int n) {
		return(2*n)+2;
	}
	public void insert(int e) {
		
		if(size<CAP) {
			list[size]=e;
			heapUp(size);
			size++;
			
		}
	}
	private void heapUp(int loc) {
		while(loc>0) {
			if(list[loc]<list[Parent(loc)]) {
				int t = list [loc];
				list[loc]=list[Parent(loc)];
				list[Parent(loc)]=t;
				loc=Parent (loc);
			}
			else
				break;
		}
	}
	
	private void heapDown(int loc) {
		while(loc<size) {
			if(Left(loc)<size) {
				break;
			}
			
			else if (Left(loc)<size && Right(loc)>=size) {
				if(list[loc]<list[Left(loc)]) {    break;}
				int t = list[loc];
				list[loc]=list[Left(loc)];
				list[Left(loc)]=t;
				loc=Left(loc);
			}
			
			else if(Right(loc)<size&& (Left(loc)<size)) {
				
			}
			
			if(list[Left(loc)] < list[Right(loc)]) { 
				if(list[loc] < list[Left(loc)]) {
					break;}
				
				
			}
			
		}
	}
	
	public void deleteMin() {
		int itm = list[0];
		list[0]= list[size-1];
		size--;
		heapDown(0);
	}
	
	
	
	
	public void runInsert(int n) {
		long startTime = System.currentTimeMillis(); 
		for (int i =0;i<n;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
			insert(randomNum);
		}
				
		long endTime = System.currentTimeMillis();
		 long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
		 double seconds = (double)estimatedTime/1000; // saniyeye çevirmek için 1000'e bölüyoruz.
		 
		 System.out.println(seconds);
	}
	
	
	public void runDelete(int n) {

		for (int i =0;i<n;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
			insert(randomNum);
		}
		
		long startTime = System.currentTimeMillis(); 
		for (int i =0;i<n;i++) {
			
			deleteMin();
		}
		long endTime = System.currentTimeMillis();
		 long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
		 double seconds = (double)estimatedTime/1000; // saniyeye çevirmek için 1000'e bölüyoruz.
		 
		 System.out.println(seconds);
	}
	
	public void print () {
		for(int i=0;i<size;i++) {
			System.out.println(list[i]);}
	}
}
