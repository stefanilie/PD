/*
Dat un sir de numere intregi, sa se determine rintr-o singura parcurgere a lui o subsecventa de suma maxima. O(n)
Ex: pentru sirul: -2, 3, -1, 7, 11, -2, 3, -6, 5 subsecventa este: 3, -1, 7, 11 , -2, 3
*/
import java.util.*;

class subsir
{
	public static void main(String[] args) 
	{
		
		int nSumaMax = 0, nStartID = 0, nEndID = 0, nTemp = 0, n;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nr de elemente: ");
		n = sc.nextInt();
		
		int[] array = new int[n];
		
		//citesc elementele vectorului
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "]: ");
			array[i] = sc.nextInt();
		}
		System.out.println();
		
		//la o singura parcurgere verific daca suma curenta este <0,
		//daca da resetez indicii la urmatorul element,
		//daca nu verific cu suma maxima din acel moment si modific suma maxima, daca este cazul.
		for (int i = 0; i < n; i++)
		{
			nTemp += array[i];
			
			if (nTemp < 0)
			{
				nTemp = 0;
				nStartID = i + 1;
				nEndID = i + 1;
			}
			else 
			if (nTemp > nSumaMax)
			{
				nSumaMax = nTemp;
				nEndID = i;
			}
		}
		
		//afisez suma si subsecventa din care este formata suma
		System.out.println("Suma: " + nSumaMax);
		System.out.print("Secventa: ");
		for (int i = nStartID; i <= nEndID; i++)
			System.out.print(array[i] + " ");
	}
}