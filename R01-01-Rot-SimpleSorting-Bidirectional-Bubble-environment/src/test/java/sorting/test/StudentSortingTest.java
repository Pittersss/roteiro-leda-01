package sorting.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorOrdenado = {};
	private Integer[] vetorOrdCrescente = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		vetorTamImpar = new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23};
		vetorOrdenado = new Integer[] {1 , 2 , 3 , 4 , 5 , 6};
		vetorValoresIguais = new Integer[] {7,7,7,7,7,7};
		vetorValoresRepetidos = new Integer[] {4, 28, 7, 29, 11, 7, 4, 22, 23};
		vetorOrdCrescente = new Integer[] {10 , 9 , 8 , 7 , 6};

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = null;
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testBubbleSortArrayTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

		bubbleSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(vetorTamPar, arrayOrdenadoTamPar);
	}

	@Test
	public void testBubbleSortArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

		bubbleSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testBubbleSortArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

		bubbleSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testBubbleSortArrayElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

		bubbleSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

		bubbleSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortInvalidRightIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		try{
			bubbleSort.sort(vetorOrdCrescente, 0, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortInvalidLeftIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		try{
			bubbleSort.sort(vetorOrdCrescente, 1, 4);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		try{
			bubbleSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		try{
			bubbleSort.sort(vetorOrdCrescente, 0, -5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortTamParRecursivo() {
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		RecursiveBubbleSort<Integer> RecursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		RecursiveBubbleSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(arrayOrdenadoTamPar, vetorTamPar);
	}

	@Test
	public void testBubbleSortRecursivoArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();

		recursiveBubbleSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testBubbleSortRecursivoArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();

		recursiveBubbleSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testBubbleSortRecursivoArrayElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();

		recursiveBubbleSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortRecursivoArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();

		recursiveBubbleSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortRecursivoInvalidRightIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		try{
			recursiveBubbleSort.sort(vetorOrdCrescente, 0, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortRecursivoInvalidLeftIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		try{
			recursiveBubbleSort.sort(vetorOrdCrescente, 1, 4);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}
	

	@Test
	public void testBubbleSortRecursivoRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		try{
			recursiveBubbleSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortRecursivoLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		try{
			recursiveBubbleSort.sort(vetorOrdCrescente, 0, -5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortBidirecionalTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		bidirecionalBubbleSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(arrayOrdenadoTamPar, vetorTamPar);
	}

	@Test
	public void testBubbleSortBidirecionalArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirecionalBubbleSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testBubbleSortBidirecionalArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirecionalBubbleSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testBubbleSortBidirecinalArrayElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirecionalBubbleSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortBidirecionalArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirecionalBubbleSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortBidirecionalInvalidRightIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		try{
			bidirecionalBubbleSort.sort(vetorOrdCrescente, 0, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortBidirecionalInvalidLeftIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		try{
			bidirecionalBubbleSort.sort(vetorOrdCrescente, 1, 4);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortBidirecionalLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		try{
			bidirecionalBubbleSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testBubbleSortBidirecionalRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		try{
			bidirecionalBubbleSort.sort(vetorOrdCrescente, 0, -5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testInsertionSortArrayTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(vetorTamPar, arrayOrdenadoTamPar);
	}

	@Test
	public void testInsertionSortArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testInsertionSortArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testInsertionSortElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testInsertionSortArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testInsertionSortInvalidRightIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		try{
			insertionSort.sort(vetorOrdCrescente, 0, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testInsertionSortInvalidLeftIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		try{
			insertionSort.sort(vetorOrdCrescente, 1, 4);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}
	}

	@Test
	public void testInsertionSortRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		try{
			recursiveBubbleSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testInsertionSortRecursivoArrayTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(vetorTamPar, arrayOrdenadoTamPar);
	}

	@Test
	public void testInsertionSortRecursivoArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testInsertionSortRecursivoArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testInsertionSortRecursivoElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testInsertionSortRecursivoArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testInsertionSortRecursivoRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		try{
			insertionSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testInsertionSortRecursivoLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		try{
			insertionSort.sort(vetorOrdCrescente, 0, -5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}
	
	@Test
	public void testSelectionSortRecursivoArrayTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(vetorTamPar, arrayOrdenadoTamPar);
	}

	@Test
	public void testSelectionSortArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testSelectionSortArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}
	
	@Test
	public void testSelectionSortElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testSelectionSortArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}

	@Test
	public void testSelectionSortRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		try{
			selectionSort.sort(vetorOrdCrescente, 0, -5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}

	@Test
	public void testSelectionSortLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		try{
			selectionSort.sort(vetorOrdCrescente, -1, 5);
			Assert.fail("Espera-se um erro aqui");
		}
		catch (IllegalArgumentException iae)
		{
			assert (iae.getMessage() == "Invalid Index");
		}

	}


	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}