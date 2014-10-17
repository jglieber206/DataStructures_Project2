import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner ;
public class eBookSort {
	public static ArrayList<String> stringList = new ArrayList<String>();
	public static void main(String[] args) {
		String file = "input.txt";
		Scanner inputStream = null ;
		ArrayList<Integer> index = new ArrayList<Integer>(100) ;
		ArrayList<Storage> list = new ArrayList<Storage>();
		ArrayList<String> str = new ArrayList<String>();
		
		int i  = 0 ;
		try 
		{
			inputStream = new Scanner( new File(file) );

		}   catch (FileNotFoundException e) {
			System.out.print("THE FILE DOES NOT EXSIST!");
			System.exit(0);
		}
		while(inputStream.hasNextLine()) {
			
			String aLine = inputStream.nextLine();
			String[] strArray = aLine.split(" ");
//			System.out.println("first " + strArray[0]);
//			System.out.println("array length" + strArray.length);
			if(strArray.length == 2)
			{
				String aString = strArray[0];
				int aVal = Integer.parseInt(strArray[1]);
				Storage one = new Storage(aString, aVal);
				list.add(one);
//				System.out.println("debug");
			}
//			index.add(line) ;
			i++ ;
		}
		inputStream.close() ;
		for(int m = 0; m < list.size() ; m++)
		{
			System.out.println(list.get(m).getString());
			str.add(list.get(m).getString());
		}
		System.out.println("length is "+str.size());
		QuickSortS(str);
		for(int m = 0; m < str.size() ; m++)
		{
			System.out.println(str.get(m));
		}
//		QuickSort(index,0,index.size() - 1 ) ;
		for (int k = 0; k < index.size() ; k ++) {
//			System.out.println(index.get(k)) ;
		}
	}

	/*
	 * Sorts the strings in storage
	 */
	public static void QuickSortS(ArrayList<String> initialValue){

	    stringList=initialValue;
	    sort(stringList, 1, stringList.size()-1);
//	    System.out.println("debug");
	}

	public static void sort(ArrayList<String> namelist, int i, int j){
		qsort(0, namelist.size()-1);
	    
	}


	private static void qsort(int from, int to){
		int i = from;
		int j = to;
		String pivot = stringList.get((int)((from+(to - from))/2));
		
		while(i <= j)
		{
			while(stringList.get(i).compareTo(pivot) > 0)
			{
				i++;
			}
			while(stringList.get(j).compareTo(pivot) < 0)
			{
				j--;
			}
			if(i <= j)
			{
				swap(i, j);
				i++;
				j--;
			}
		}
		if(from < j)
		{
			qsort(from, j);
		}
		if(i < to)
		{
			qsort(i, to);
		}
	}
	private static void swap (int i, int j){

	    String temp = stringList.get(i);

	    stringList.set(i, stringList.get(j));
	    stringList.set(j, temp);

	}
	
	public static void QuickSort(ArrayList<Integer> arr, int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            QuickSort(arr, left, index - 1);
	      if (index < right)
	            QuickSort(arr, index, right);
	}
	
	public static int partition(ArrayList<Integer> arr, int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = (arr.get(left) + arr.get(right)) / 2;
	     
	      while (i <= j) {
	            while (arr.get(i) < pivot)
	                  i++;
	            while (arr.get(j) > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr.get(i);
	                  arr.set(i, arr.get(j));
	                  arr.set(j, tmp);
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	

}
