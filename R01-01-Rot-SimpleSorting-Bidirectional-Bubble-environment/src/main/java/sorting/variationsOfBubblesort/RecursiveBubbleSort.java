package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if (rightIndex < 0 || leftIndex < 0 || rightIndex > array.length - 1 || rightIndex <= leftIndex)
		{
			return;
		}

		boolean haveSwap = true;

		if (!haveSwap) {}
		else
		{
			if(passByArrayRecursive(array, leftIndex, rightIndex))
				sort(array, leftIndex, rightIndex);
			else{
				haveSwap = false;
			}
		}

	}

	private boolean passByArrayRecursive(T[] array ,int leftIndex, int rightIndex)
	{
		boolean haveSwap = false;
		boolean trocaFutura = false;
		if (leftIndex == rightIndex)
		{}
		else
		{
			if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0)
			{
				Util.swap(array, leftIndex, leftIndex + 1);
				haveSwap = true;
			}

			trocaFutura = passByArrayRecursive(array, leftIndex + 1, rightIndex);
			
			
		}

		if (trocaFutura)
			haveSwap = trocaFutura;
		return haveSwap;

	}

}
