package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < 0 || rightIndex < 0)
			throw new IllegalArgumentException("Invalid Index");

		int smallerIndex = leftIndex;

		if (leftIndex == rightIndex)
		{}
		else{
			smallerIndex = catchIndexSmallerIndexElement(array, leftIndex, rightIndex);

			Util.swap(array, leftIndex, smallerIndex);
			sort(array, leftIndex + 1, rightIndex);
				
		}
		
	}

	public int catchIndexSmallerIndexElement(T[] array, int leftIndex, int rightIndex)
	{
		int smallerIndex = leftIndex;
		int futureSmaller = leftIndex;
		if (leftIndex == rightIndex + 1)
		{
			smallerIndex = rightIndex;
			futureSmaller = rightIndex;
		}
		else
		{
			if (array[leftIndex].compareTo(array[smallerIndex]) < 0) 
			{ 
				smallerIndex = leftIndex + 1; //erro 
			}
			futureSmaller = catchIndexSmallerIndexElement(array, leftIndex + 1, rightIndex);
		}

		if (array[futureSmaller].compareTo(array[smallerIndex]) < 0)
			smallerIndex = futureSmaller;

		return smallerIndex;
	}

}
