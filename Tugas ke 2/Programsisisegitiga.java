import java.util.*;
import java.util.Scanner;
import java.lang.*;
public class Programsisisegitiga{
	public static void main (String [] args){
		System.out.println("Program Menghitung Sisi Miring segitiga Siku-siku dengan rumus Phitagoras");
		int a,t;
		double sm;
		Scanner scan=new Scanner(System.in);
		System.out.print("Masukan Panjang Alas : ");
		a=scan.nextInt();
		System.out.print("Masukan Panjang Tinggi : ");
		t=scan.nextInt();
		sm = Math.sqrt((a*a)+(t*t));
		System.out.println();
		System.out.println("Sisi Segitiga dengan Alas " +a+ " dan Tinggi " +t+ " adalah : " +sm);
	}
}