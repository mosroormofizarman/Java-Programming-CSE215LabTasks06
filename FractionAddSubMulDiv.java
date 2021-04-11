package cse215_lab_tasks_06;

import java.util.Scanner;

class Fraction{
	private int numerator;
	private int denominator;
	
	public Fraction() {
		
	}
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	public void add(Fraction f) {
		this.numerator = (this.numerator * f.denominator) + (f.numerator * this.denominator);
		this.denominator = (this.denominator * f.denominator);
		
		int commonfactor = gcd(numerator, denominator);
		
		this.numerator /= commonfactor;
		this.denominator /= commonfactor;
		
	}
	public void sub(Fraction f) {
		int onedenominator = (this.denominator * f.denominator);
		int onenumerator = (this.numerator * (onedenominator / this.denominator)) - (f.numerator * (onedenominator / f.denominator));
		this.numerator = onenumerator;
		this.denominator = onedenominator;
		
		int commonfactor = gcd(numerator, denominator);
		
		this.numerator /= commonfactor;
		this.denominator /= commonfactor;
		
	}
	public void multiplication(Fraction f) {
		this.numerator = (this.numerator * f.numerator);
		this.denominator = (this.denominator * f.denominator);
		
		int commonfactor = gcd(numerator, denominator);
		
		this.numerator /= commonfactor;
		this.denominator /= commonfactor;
		
	}
	public void division(Fraction f) {
		this.numerator = (this.numerator * f.denominator);
		this.denominator = (this.denominator * f.numerator);
		
		int commonfactor = gcd(numerator, denominator);
		
		this.numerator /= commonfactor;
		this.denominator /= commonfactor;
		
	}
	public static int gcd(int a, int b) {
		int cf = 1;
		if(a<0 || b<0) {
			a = Math.abs(a);
			b = Math.abs(b);
			
			for(int i=1; i<=a && i<=b; ++i) {
				if((a%i ==0) && (b%i ==0)) {
					cf = i;
				}
			}
		}
		else {
			for(int i=1; i<=a && i<=b; ++i) {
				if((a%i ==0) && (b%i ==0)) {
					cf = i;
				}
			}
		}
		return cf;
	}
}

public class FractionAddSubMulDiv {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x1 = input.nextInt();
		int y1 = input.nextInt();
		int x2 = input.nextInt();
		int y2 = input.nextInt();
		
		Fraction f1 = new Fraction(x1, y1);
		Fraction f2 = new Fraction(x2, y2);
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		f1.add(f2);
		System.out.println(f1.toString());
		
		f1.setNumerator(x1);
		f1.setDenominator(y1);
		f2.setNumerator(x2);
		f2.setDenominator(y2);
		f1.sub(f2);
		System.out.println(f1.toString());
		
		f1.setNumerator(x1);
		f1.setDenominator(y1);
		f2.setNumerator(x2);
		f2.setDenominator(y2);
		f1.multiplication(f2);
		System.out.println(f1.toString());
		
		f1.setNumerator(x1);
		f1.setDenominator(y1);
		f2.setNumerator(x2);
		f2.setDenominator(y2);
		f1.division(f2);
		System.out.println(f1.toString());
		
		input.close();
	}
}
