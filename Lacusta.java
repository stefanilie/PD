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
	//int a[][];
	ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> sorted = new ArrayList<ArrayList<Integer>>();
	int nSuma;
	int step;
	Lacusta()
	{
		m=0;
		n=0;
		nSuma = 0;
		step = 0;
	}
	/*
	step - va stoca numarul de elemente adaugate in suma. trebuie sa fie =2m.
	i , j - contorii matricei
	*/
	public static void calc(Lacusta l, int step, int i, int j)
	{
		if(i != l.m-1 && step < 2*l.m)
		{
			l.nSuma += l.a.get(i).get(j);
			System.out.println("+" + l.a.get(i).get(j));
			step++;

			//iau linia urmatoare din matrice si o sortez
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = l.a.get(i+1);
			Collections.sort(temp);
			//l.sorted.add(temp);

			//apoi iau indexul celui mai mic element
			int t1 = temp.get(0);
			t1 = temp.indexOf(t1);

			//si il adaug pe cel de deasupra lui
			l.nSuma += l.a.get(i).get(t1);
			calc(l, l.step, i+1, t1);
		}
		else if(i == l.m-1)
		{
			l.nSuma += l.a.get(i).get(j) + l.a.get(l.m-1).get(l.n-1);
			step++;
			step++;
		}
	}
	public static void main(String[] args)
	{
		File input = new File("intrare.txt");
		File output = new File("iesire.txt");


		try
		{
			Lacusta l = new Lacusta();
			Scanner sc = new Scanner(input);
			m = Integer.parseInt(sc.next());
			System.out.println("S-a citit m="+ m);
			n = Integer.parseInt(sc.next());
			System.out.println("S-a citit n="+ n);
			//l.a[][] = new int[m][n];

			for(int i = 0; i<m; i++)
			{
				ArrayList<Integer> arrTemp = new ArrayList<Integer>();
				for(int j = 0; j<n; j++)
				{
					if(sc.hasNextInt())
					{
						//l.a[i][j] = Integer.parseInt(sc.next());
						arrTemp.add(Integer.parseInt(sc.next()));
					//	System.out.println("S-a citit " + l.a[i][j] + "si s-a adaugat in a[" +
					//	 i + "][" + j + "];");
					}
				}
				l.a.add(arrTemp);
			}

			PrintWriter out = new PrintWriter(output);

			out.print(l.a);
			ArrayList<Integer> arrTemp = new ArrayList<Integer>();
			arrTemp = l.a.get(0);
			Collections.sort(arrTemp);
			calc(l, 0, 0, 0);
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
