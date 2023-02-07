package calculator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class SimpleCalculator{
	public static double ans;
}
class Addition extends SimpleCalculator{
    double l;
	public void calculate(double a,double b) {
		l = a+b;
	}
}
class Subraction extends SimpleCalculator{
    double l;
    public void calculate(double a,double b) {
    	l = a-b;
	}
}
class Multiplication extends SimpleCalculator{
    double l;
    public void calculate(double a,double b) {
    	l = a*b;
	}
}
class Division extends SimpleCalculator{
     double l;
    public void calculate(double a,double b) {
    	l = a/b;
	}
}
public class Main {
	public static void main(String[] args) {
		Logger l = Logger.getLogger("com.api.jar");
		Scanner c = new Scanner(System.in);
		l.info("Enter two values ");
		Float a = c.nextFloat();
		Float b = c.nextFloat();
		l.info("Enter the operation ");
		char o = c.next().charAt(0); 
		SimpleCalculator s = new SimpleCalculator();
		switch(o){
		case '+':
			Addition a1 = new Addition();
			a1.calculate(a,b);
			s.ans = a1.l;
			break;
		case '-':
			Subraction a2 = new Subraction();
			a2.calculate(a,b);
			s.ans = a2.l;
			break;
		case '*':
			Multiplication a3 = new Multiplication();
			a3.calculate(a,b);
			s.ans = a3.l;
			break;
		case '/':
			Division a4 = new Division();
			a4.calculate(a,b);
			s.ans = a4.l;
			break;
		default:
			l.info("Invalid Operation");
			break;
		}
		l.log(Level.INFO,()-> "The Answer is = "+s.ans);
}
}
