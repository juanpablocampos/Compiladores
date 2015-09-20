import java.io.*;
import javax.swing.*;
class HoraMilitar
{
	public static void main (String[] lqq)
	{
	int horamilitar, hora, minutos;
	horamilitar=Integer.parseInt(JOptionPane.showInputDialog("Teclee la hora militar:"));
	minutos=horamilitar%100;
	hora=(horamilitar-minutos)/100;

	if(hora<12)
	{
		//Es a.m
		if(hora == 0)
		{
			hora=12;

		}//if(hora == 0)
		System.out.println("son las "+hora+":"+minutos+" am");


	}//if(hora<12)
	else
	{
		if (hora>12)
		hora=hora-12;

				System.out.println("son las "+hora+":"+minutos+" pm");

	}//else

	}//public static void main (String[] lqq)
}//class HoraMilitar