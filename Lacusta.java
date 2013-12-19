import java.util.*;
//import java.io.PrintWriter;
//import java.io.File;
import java.io.*;
/*
5
3 4 5 7 9
6 6 3 4 4
6 3 3 9 6
6 5 3 8 2
*/
class Lacusta
{
	static int m, n;
	int a[][];
	int nSuma;
	int step;
	Lacusta()
	{
		m=0;
		n=0;
		nSuma = 0;
	}
	/*
	step - va stoca numarul de elemente adaugate in suma. trebuie sa fie =2m.
	i , j - contorii matricei
	*/
	public static void calc(Lacusta l, int i, int j)
	{
		if(i > 0 && j > 0)
		{
			int temp = Integer.MAX_VALUE;
            int next = 0;
            for(int k=l.n-1; k>=0 ; k--)
            {
                if(k != i)
                if(l.a[i][k]+l.a[i-1][k]<temp)
                {
                    temp=l.a[i][k]+l.a[i-1][k];
                    next=k;
                }
            }
            l.nSuma += temp;
            System.out.println("+" + temp);

			calc(l, i-1, next);
		}
		if(i == 0)
		{
			l.nSuma += l.a[0][0];
		}
	}
	public static void main(String[] args)
	{
		File input = new File("intrare.txt");
		File output = new File("iesire.txt");
//care e ideea problemei,
//care e relatia de recurenta


		try
		{
			Lacusta l = new Lacusta();
			Scanner sc = new Scanner(input);
			m = Integer.parseInt(sc.next());
			System.out.println("S-a citit m="+ m);
			n = Integer.parseInt(sc.next());
			System.out.println("S-a citit n="+ n);
			l.a = new int[m][n];

			for(int i = 0; i<m; i++)
			{
				for(int j = 0; j<n; j++)
				{
					if(sc.hasNextInt())
					{
						l.a[i][j] = sc.nextInt();
					}
				}
			}

			PrintWriter out = new PrintWriter(output);

			for(int i = 0; i<m; i++)
			{
				for(int j = 0; j<n; j++)
				{
					out.print(l.a[i][j] + " ");
				}
				out.println();
			}

			//out.print(l.a);
			calc(l, l.m-1, l.n-1);
			System.out.println("Suma: " + l.nSuma + ", step: " + l.step);
			out.println("Suma: " + l.nSuma + ", step: " + l.step);

			out.close();
		}
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
        }
        catch(IOException e1) 
        {
        System.out.println("Error during reading/writing");
   		}
   		catch(NumberFormatException e)
   		{
   			System.out.println(e);
   		}
	}
}
