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
	public void testBubbleSortRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone(); 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		bubbleSort.sort(vetorTamPar, -10, -1);

		assertArrayEquals(vetorTamPar, arrayElemsIguaisOrd);

	}

	@Test
	public void testBubbleSortLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone(); 

		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		bubbleSort.sort(vetorTamPar, -1, vetorTamPar.length - 1);

		assertArrayEquals(vetorTamPar, arrayElemsIguaisOrd);

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
	public void testBubbleSortRecursivoRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone(); 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		recursiveBubbleSort.sort(vetorTamPar, -20, -10);

		assertArrayEquals(vetorTamPar, arrayElemsIguaisOrd);
	}

	@Test
	public void testBubbleSortRecursivoLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone(); 

		RecursiveBubbleSort<Integer> recursiveBubbleSort = new RecursiveBubbleSort<Integer>();
		recursiveBubbleSort.sort(vetorTamPar, -1, vetorTamPar.length - 1);

		assertArrayEquals(vetorTamPar, arrayElemsIguaisOrd);

	}

	//BidirecionaBubbleSort

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
	public void testBubbleSortBidirecionalLeftIndexNegativo() 
	{
		Integer[] arrayOrd = vetorTamPar.clone();

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		bidirecionalBubbleSort.sort(vetorTamPar, -1, vetorTamPar.length - 1);

		assertArrayEquals(arrayOrd, vetorTamPar);

	}

	@Test
	public void testBubbleSortBidirecionalRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayOrd = vetorTamPar.clone();

		BidirectionalBubbleSort<Integer> bidirecionalBubbleSort = new BidirectionalBubbleSort<Integer>();
		bidirecionalBubbleSort.sort(vetorTamPar, -20, -1);

		assertArrayEquals(arrayOrd, vetorTamPar);

	}

	@Test
	public void testBubbleSortBidirecionalSegundaMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 4, 11, 22, 23, 26};
		
		BidirectionalBubbleSort<Integer> bidirectionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirectionalBubbleSort.sort(vetorTamImpar, middleIndex,  vetorTamImpar.length - 1);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void testBubbleSortBidirecionalPrimeiraMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {7, 11, 28, 29, 30, 26 , 4 , 22, 23};
		
		BidirectionalBubbleSort<Integer> bidirectionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirectionalBubbleSort.sort(vetorTamImpar, 0,  middleIndex);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}
	@Test
	public void testBubbleSortBidirecionalPrimeiraMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26 **, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {7, 11, 26, 28, 29, 30, 4, 22, 23, 31};
		
		BidirectionalBubbleSort<Integer> bidirectionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirectionalBubbleSort.sort(vetorTamPar, 0,  middleIndex);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}

	@Test
	public void testBubbleSortBidirecionalSegundaMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26 **, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 11, 4, 22, 23, 26, 31};
		
		BidirectionalBubbleSort<Integer> bidirectionalBubbleSort = new BidirectionalBubbleSort<Integer>();

		bidirectionalBubbleSort.sort(vetorTamPar, middleIndex,  vetorTamPar.length - 1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}

	// Insertion Sort
	
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
		Integer[] array = vetorTamPar.clone();

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		insertionSort.sort(array, -20, -10);

		//Provando que vetorTampar não foi modificado
		assertArrayEquals(array, vetorTamPar);

	}

	@Test
	public void testInsertionSortNegativoLeftIndex() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] array = vetorTamPar.clone();

		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		insertionSort.sort(array, -1, vetorTamPar.length - 1);

		//Provando que vetorTampar não foi modificado
		assertArrayEquals(array, vetorTamPar);
	}

	@Test
	public void testInsertionSortSegundaMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 4, 11, 22, 23, 26};
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamImpar, middleIndex,  vetorTamImpar.length - 1);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void testInsertionSortPrimeiraMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {7, 11, 28, 29, 30, 26 , 4 , 22, 23};
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamImpar, 0,  middleIndex);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}
	@Test
	public void testInsertionSortPrimeiraMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26 **, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {7, 11, 26, 28, 29, 30, 4, 22, 23, 31};
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamPar, 0,  middleIndex);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}

	@Test
	public void testInsertionSortSegundaMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, ** 26, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 11, 4, 22, 23, 26, 31};
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

		insertionSort.sort(vetorTamPar, middleIndex,  vetorTamPar.length - 1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}



	//Selection Recursivo

	@Test
	public void testSelectionSortRecursivoArrayTamPar() 
	{
		Integer[] arrayOrdenadoTamPar = {4, 7, 11, 22, 23, 26, 28, 29, 30, 31}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorTamPar, 0, 9);

		assertArrayEquals(vetorTamPar, arrayOrdenadoTamPar);
	}

	@Test
	public void testSelectionSortRecursivoArrayTamImpar() 
	{
		//30, 28, 7, 29, 11, 26, 4, 22, 23
		Integer[] arrayOrdenadoTamImpar = {4, 7, 11, 22, 23, 26, 28, 29, 30}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorTamImpar, 0, 8);

		assertArrayEquals(vetorTamImpar, arrayOrdenadoTamImpar);
	}

	@Test
	public void testSelectionSortRecursivoArrayValoresRepetidos() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsRepOrd = {4, 4, 7, 7, 11, 22, 23, 28, 29}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorValoresRepetidos, 0, 8);

		assertArrayEquals(vetorValoresRepetidos, arrayElemsRepOrd);
	}

	@Test
	public void testSelectionSortRecursivoElementosIguais() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {7, 7, 7, 7, 7, 7}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorValoresIguais, 0, 5);

		assertArrayEquals(vetorValoresIguais, arrayElemsIguaisOrd);
	}

	@Test
	public void testSelectionSortRecursivoArrayCrec() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = {6 , 7 , 8 , 9 , 10}; 

		RecursiveSelectionSort<Integer> recursiveSelectionSort = new RecursiveSelectionSort<Integer>();

		recursiveSelectionSort.sort(vetorOrdCrescente, 0, 4);

		assertArrayEquals(vetorOrdCrescente, arrayElemsIguaisOrd);
	}


	@Test
	public void testSelectionSortRecursivoSegundaMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 4, 11, 22, 23, 26};
		
		RecursiveSelectionSort<Integer> selectionSort = new RecursiveSelectionSort<Integer>();

		selectionSort.sort(vetorTamImpar, middleIndex,  vetorTamImpar.length - 1);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void testSelectionSortRecursivoPrimeiraMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {7, 11, 28, 29, 30, 26 , 4 , 22, 23};
		
		RecursiveSelectionSort<Integer> selectionSort = new RecursiveSelectionSort<Integer>();

		selectionSort.sort(vetorTamImpar, 0,  middleIndex);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}
	@Test
	public void testSelectionSortRecursivoPrimeiraMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26 **, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {7, 11, 26, 28, 29, 30, 4, 22, 23, 31};
		
		RecursiveSelectionSort<Integer> selectionSort = new RecursiveSelectionSort<Integer>();

		selectionSort.sort(vetorTamPar, 0,  middleIndex);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}

	@Test
	public void testSelectionSortRecursivoSegundaMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, ** 26, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 11, 4, 22, 23, 26, 31};
		
		RecursiveSelectionSort<Integer> selectionSort = new RecursiveSelectionSort<Integer>();

		selectionSort.sort(vetorTamPar, middleIndex,  vetorTamPar.length - 1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}


	@Test
	public void testSelectionSortRecursivoRightIndexNegativo() 
	{
		Integer[] arrayOrdenado = vetorTamPar.clone();
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		insertionSort.sort(arrayOrdenado, -20, -10);

		//Não houve mudança, pois a entrada é inválida de alguma forma
		assertArrayEquals(vetorTamPar, arrayOrdenado);

	}


	//SelectionSort


	@Test
	public void testSelectionSortArrayTamPar() 
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
	public void testSelectionSortSegundaMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 4, 11, 22, 23, 26};
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamImpar, middleIndex,  vetorTamImpar.length - 1);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void testSelectionSortPrimeiraMetadeArrayImpar()
	{
		// vetorTamImpar = new Integer[] {30, 28, 7, 29, 11**, 26, 4, 22, 23};
		int middleIndex = (vetorTamImpar.length/2);
		Integer[] arrayOrdenado = {7, 11, 28, 29, 30, 26 , 4 , 22, 23};
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamImpar, 0,  middleIndex);
		
		
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void testSelectionSortPrimeiraMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26 **, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {7, 11, 26, 28, 29, 30, 4, 22, 23, 31};
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamPar, 0,  middleIndex);
		
		
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}
	@Test
	public void testSelectionSortSegundaMetadeArrayPar()
	{
		// vetorTamPar = new Integer[] {30, 28, 7, 29, 11, ** 26, 4, 22, 23, 31};
		int middleIndex = (vetorTamPar.length/2);
		Integer[] arrayOrdenado = {30, 28, 7, 29, 11, 4, 22, 23, 26, 31};
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(vetorTamPar, middleIndex,  vetorTamPar.length - 1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}
	@Test 
	public void testSelectionSortLeftMaiorRight()
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone();
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(arrayElemsIguaisOrd, arrayElemsIguaisOrd.length,  0);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(arrayElemsIguaisOrd, vetorTamPar);
	}
	@Test
	public void testSelectionSortRightIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone();
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();

		selectionSort.sort(arrayElemsIguaisOrd, 0,  -1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(arrayElemsIguaisOrd, vetorTamPar);
		
	}

	@Test
	public void testSelectionSortLeftIndexNegativo() 
	{
		//4, 28, 7, 29, 11, 7, 4, 22, 23
		Integer[] arrayElemsIguaisOrd = vetorTamPar.clone();
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		selectionSort.sort(arrayElemsIguaisOrd, -1,  arrayElemsIguaisOrd.length - 1);
		
		//Se forem iguais nada foi feito
		assertArrayEquals(arrayElemsIguaisOrd, vetorTamPar);

	}


	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}