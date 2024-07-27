package sorting.variationsOfBubblesort;

import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class MainTeste 
{
    public static void main(String[] args)
    {
       RecursiveSelectionSort<Integer> b = new RecursiveSelectionSort<Integer>();
       Integer[] array = {0,8,1,5};
       b.sort(array, 0, 3);


    
    }    
}
