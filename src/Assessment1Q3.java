import java.util.ArrayList;
import java.util.Collections;


public class Assessment1Q3 implements Runnable{
	
	//'bucket' variable of type ArrayList<Integer>
	private ArrayList<Integer> bucket;
	
	//constructor to initialize 'specificBucket' of type ArrayList<Integer>
	Assessment1Q3(ArrayList<Integer> specificBucket){
		this.bucket=specificBucket;
	}
	
	public static int[] bucketSort(int[] numbers, int bucketCount) {
		
		 if (numbers.length <= 1) return numbers;
		 int maxVal = numbers[0];
		 int minVal = numbers[0];

		 for (int i = 1; i < numbers.length; i++) {
		 if (numbers[i] > maxVal) maxVal = numbers[i];
		 if (numbers[i] < minVal) minVal = numbers[i];
		 }

		 double interval = ((double)(maxVal - minVal + 1)) / bucketCount; // range of bucket
		 ArrayList<Integer> buckets[] = new ArrayList[bucketCount];

		 for (int i = 0; i < bucketCount; i++) // initialize buckets (initially empty)
		 buckets[i] = new ArrayList<Integer>();

		 for (int i = 0; i < numbers.length; i++) // distribute numbers to buckets
		 buckets[(int)((numbers[i] - minVal)/interval)].add(numbers[i]);
		 
		 
		 int k = 0;

		 for (int i = 0; i < buckets.length; i++) {
			 //Creates an object of the Class
			 Assessment1Q3 m = new Assessment1Q3(buckets[i]);
			 //creates a thread
			 Thread t = new Thread(m);
			 //Calls the run method of the Thread
			 t.start();
			 //Makes the thread sleep
			 makeThreadSleep();
			 //waits till thread terminates
			 try {
			      t.join();
			   } catch (InterruptedException e) {
			      e.printStackTrace();
			   }

		 for (int j = 0; j < buckets[i].size(); j++) { // update array with the bucket content
			 numbers[k] = buckets[i].get(j);
			 k++;
		 	}
		 }
		 return numbers; 
}
	

	


	public static void main(String[] args){
	
		int [] numbers={10,9,8,7,6,5,4,3,2,1};
		int bucketCount=5;
		
		System.out.println("Original\n");
		
		//Prints the original unsorted array
		for(int i = 0; i < numbers.length;i++)	{
			System.out.print(" "+numbers[i]);
		}
		
		System.out.println("\nModified\n");
		int[] array=bucketSort(numbers,bucketCount);
		
		//Prints the sorted array
		for(int i = 0; i < array.length;i++)	{
			System.out.print(" "+array[i]);
		}
		
		System.out.println("\n");
		
		int [] numbers1={101,91,81,71,61,51,41,31,21,11};
		int bucketCount1=5;
		
		System.out.println("Another Original array\n");
		//Prints the original unsorted array 
		for(int i = 0; i < numbers1.length;i++)	{
			System.out.print(" "+numbers1[i]);
		}
		
		System.out.println("\nModified\n");
		int[] array1=bucketSort(numbers1,bucketCount1);
		
		//Prints the sorted array
		for(int i = 0; i < array.length;i++)	{
			System.out.print(" "+array1[i]);
		}

		
	}
	
	
	public void run() {
		//sorts the bucket under the current thread
		Collections.sort(this.bucket);
	}

	//static method to make the thread sleep
	static void makeThreadSleep(){
	    try {
	    	//Makes the thread sleep for 4 seconds
	        Thread.sleep(4000);
	    } catch (InterruptedException e) {
	        System.out.println(e);
	    }
	}
}
