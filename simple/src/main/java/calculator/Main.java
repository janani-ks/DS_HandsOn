package calculator;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class SimpleCalculator{
	private static float ans;
	static void setter(float a) {
		SimpleCalculator.ans = a;
	}
	double getter() {
		return ans;
	}
}
class Addition extends SimpleCalculator{
	public float calculate(float a,float b) {
		setter(a+b);
		return a+b;
	}
}
class Subraction extends SimpleCalculator{
    public float calculate(float a,float b) {
    	setter(a-b);
    	return a-b;
	}
}
class Multiplication extends SimpleCalculator{
    public float calculate(float a,float b) {
    	setter(a*b);
    	return a*b;
	}
}
class Division extends SimpleCalculator{
    public float calculate(float a,float b) {
    	setter(a/b);
    	return a/b;
	}
}
public class Main {
	public static void main(String[] args) {
		PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
		Scanner c = new Scanner(System.in);
		p.println("Enter the values and operations ");
		SimpleCalculator s = new SimpleCalculator();
		char[] arr = new char[100];
		int i=0;
		while(i>=0) {
			char o = c.next().charAt(0);
			arr[i]=o;
			if(arr[i]=='='){
				break;
			}
			i++;
		}
		float ans = Float.parseFloat(""+arr[0]);
		int j=1;
		while(j<i) {
		switch(arr[j]){
		case '+':
			Addition a1 = new Addition();
			ans = a1.calculate(ans,Float.parseFloat(""+arr[j+1]));
			break;
		case '-':
			Subraction a2 = new Subraction();
			ans = a2.calculate(ans,Float.parseFloat(""+arr[j+1]));
			break;
		case '*':
			Multiplication a3 = new Multiplication();
			ans = a3.calculate(ans,Float.parseFloat(""+arr[j+1]));
			break;
		case '/':
			Division a4 = new Division();
			ans = a4.calculate(ans,Float.parseFloat(""+arr[j+1]));
			break;
		default:
			break;
		}
		j=j+2;
		}
		p.println("The Answer is = "+s.getter());
}
}
