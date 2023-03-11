import java.util.concurrent.ThreadLocalRandom;

public class ArrayBasedPriorityQueue implements PriorityQueue{
	private int size=-1;
	private int []list = new int[CAP];
	
	private final static int CAP=90000;
	
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
	@Override
	public int size() {
		if(size<0) {
		return 0;}
		else {
			return size+1;
		}
	}
	
	@Override
	public int peek() {
		if(size>=0) {
			return list[0];			
		}
		else {
			return (Integer) null;
		} 
		
	}
	
	
	@Override
	public void insert(int item) {
		 {
			 
			 size++;
			 int i;
		        if (size >= CAP) {
		        	return;
		        }
		        else {
		        	
			        for (i = size-1 ; (i >= 0 && list[i] > item); i--) {
			        	list[i + 1] = list[i];
			        }
			        list[i + 1] = item;
			 
			        return;
		        }   
		 
		        
		    }
		
		
		
	}
	

	@Override
	public void deleteMin() {

		for(int i=0;i<size;i++) {
			list[i]=list[i+1];
		}
		size--;
		
	}

	@Override
	public int min() {
		
		return list[0];
	}

	@Override
	public boolean empty() {
		if(size<0) {
		return true;}
		else {return false;}
	}
	public void print () {
		for(int i=0;i<size+1;i++) {
			System.out.println(list[i]);}
	}

	

}
