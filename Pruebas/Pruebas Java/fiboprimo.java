import java.io.*;
import javax.swing.*;
class fiboprimo
{
	public static void main(String[] lqs)
	{
		int x,y,z,a,cd,b;
		x=0;
		y=1;
		z=1;
		while (x<10000000)
		{

			a=1;
			cd=0;
			b=0;
			while (a<x)
			{
			if(x%a == 0)
				cd++;
			if (cd>2)
				b=1;
			else
				b=2;

			a++;

			}//while (a<x)

			if(b==2)
				System.out.print(x+" ");

				x = y;
				y = z;
				z = x + y;

		}	//  while (x<10000)





	}	//  public static void main(String[] lqs)
}	//  class fiboprimo