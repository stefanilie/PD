//Cel mai lung subsir comun dintre 2 vectori. O(m*n)

import java.util.*;

class cmlsc 
{

	private static int maxim (int a, int b)
  {
		if (a > b) return a;
		return b;
	}

  public static void main(String[] args)
  {
		Scanner sc = new Scanner(System.in);
		
		int m, n;
		
    System.out.print("Dimensiunea vectorului 1: ");
    m = sc.nextInt();

    System.out.print("Dimensiunea vectorului 2: ");
		n = sc.nextInt();

		//cei 2 vectori de numere au dimensiuni m, respectiv n
		int[] x = new int[m + 1];
    int[] y = new int[n + 1];
		int[][] a = new int[m + 1][n + 1];

		//citirea valorior vectorilor de la tastatura
		for (int i = 1; i <= m; i++) 
    {
      System.out.print("x[" + i + "]: ");
			x[i] = sc.nextInt();
    }

		for (int i = 1; i <= n; i++) 
    {
      System.out.print("y[" + i + "]: ");
			y[i] = sc.nextInt();
    }
    
    /*
    Comparam element cu element cei doi vectori
    *daca sunt egale, in matrice, elementul format de la adresa adreselor elementelor egale -1, +1.
    *in caz contrar, se ia maximul din matrice dintre elementul din stanga si elementul
    de deasupra elementului care are coordononate i si j curent
    */
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++) 
      {
        a[i][j] = 0;
        if (x[i] == y[j])
          a[i][j] = a[i - 1][j - 1] + 1;
        else
          a[i][j] = maxim(a[i - 1][j], a[i][j - 1]);
      }

    int[] sol;
    int i = 0;
    
    if (n > m)
     sol = new int[n];
    else 
    sol = new int[m];

    while (m != 0 && n != 0)
    {
      if (x[m] == y[n]) 
      {
        sol[i++] = x[m];
        n--;
        m--;
      }
      else
        if (a[m - 1][n] < a[m][n - 1])
          n--;
        else
          m--;
    }

    for (int j = i - 1; j >= 0; j--)
      System.out.print(sol[j] + " ");
  }
}
