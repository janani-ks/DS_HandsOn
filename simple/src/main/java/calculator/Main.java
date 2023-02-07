package calculator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class SimpleCalculator{
	private static double ans;
	void setter(double a) {
		this.ans = a;
	}
	double getter() {
		return ans;
	}
}
class Addition extends SimpleCalculator{
	public void calculate(double a,double b) {
		setter(a+b);
	}
}
class Subraction extends SimpleCalculator{
    public void calculate(double a,double b) {
    	setter(a-b);
	}
}
class Multiplication extends SimpleCalculator{
    public void calculate(double a,double b) {
    	setter(a*b);
	}
}
class Division extends SimpleCalculator{
    public void calculate(double a,double b) {
    	setter(a/b);
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
			break;
		case '-':
			Subraction a2 = new Subraction();
			a2.calculate(a,b);
			break;
		case '*':
			Multiplication a3 = new Multiplication();
			a3.calculate(a,b);
			break;
		case '/':
			Division a4 = new Division();
			a4.calculate(a,b);
			break;
		default:
			l.info("Invalid Operation");
			break;
		}
		l.log(Level.INFO,()-> "The Answer is = "+s.getter());
}
}
