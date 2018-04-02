import java.util.ArrayList;
import java.util.Collections;


class SortSelector{
	//This method would be overridden in the main method.
	public ArrayList<Integer>  helperSortFunction(ArrayList<Integer> array){
		return null;
	}
}

public class Assessment1Q2 {
	
	
	public static int[] bucketSort(int[] numbers, int bucketCount, SortSelector myHelperSortFn) {
		
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

		//SORTING CODE OR METHOD
		 myHelperSortFn.helperSortFunction(buckets[i]);
			 
		 for (int j = 0; j < buckets[i].size(); j++) { // update array with the bucket content
		 numbers[k] = buckets[i].get(j);
		 k++;
		 }
		 }

		 return numbers;
		 }	
	
	
	public static void main(String[] args){
		//arr is an array
		int[] arr=new int[]{11,31,51,71,91,21,41,61,101,121,111};
		
		//prints the original array
		System.out.println("Original Array:");
		//Prints the original array
		for(int i=0; i<arr.length; i++){
			System.out.print(" "+ arr[i]);
		}
		
		//Creates an instance of the class SortSelector
		SortSelector stsl = new SortSelector(){
			//Overrides the helperSortFunction method of the class SortSelector
			@Override
			public ArrayList<Integer>  helperSortFunction(ArrayList<Integer> array){
				Collections.sort(array);
				return array;
			}
			
		};
		
		//Puts the sorted array into arr1
		int[] arr1=Assessment1Q2.bucketSort(arr, 5, stsl );
		
		//Prints the sorted array
		System.out.println("\nSorted Array:");
		for(int i=0; i<arr1.length;i++)
		{
			System.out.print(" "+arr1[i]);
		}
		
		//another array 'anotherArray'
		int[] anotherArray=new int[]{1,10,2,9,3,8,4,7,5,6};
		
		System.out.println("\nAnother Original Array");
		//Prints the original array
		for(int i=0; i<anotherArray.length; i++){
			System.out.print(" "+ anotherArray[i]);
		}
		
		//Creates an instance of the class SortSelector
		SortSelector stsl1 = new SortSelector(){
			//Overrides the helperSortFunction method of the class SortSelector (uses bubble sort)
			public ArrayList<Integer>  helperSortFunction(ArrayList<Integer> array){
				int temp=0;
				int len = array.size();
				for(int k = 1; k < len; k++){
					for(int j = 0; j < len - k; j++){
						if (array.get(j) > (array.get(j+1))){
						temp=array.get(j);
						array.set(j,array.get(j+1));
						array.set(j+1,temp);
					}
				}
			}
				
			return array;
		}
			
	};
		
		int[] arr2=Assessment1Q2.bucketSort(anotherArray, 5, stsl1 );
		
		System.out.println("\nSorted Array:(Uses Bubble sort and not Collections.sort)");
		//Prints the array sorted using bubble sort.
		for(int i=0; i<arr2.length;i++)
		{
			System.out.print(" "+arr2[i]);
		}
		
		
	}
		
}


