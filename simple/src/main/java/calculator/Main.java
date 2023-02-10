package calculator;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
class Calculation{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	float number;
	char op;
	Calculation(){
		p.println("Enter the values and operations ");
	}
    Calculation(float n,char o){
    	this.number = n;
    	this.op = o;
    }
    float calculate(float a,float b,char c){
    	switch(c) {
    	case '+':
    		return a+b;
    	case '-':
    		return a-b;
    	case '*':
    		return a*b;
    	case '/':
    		return a/b;
    	default:
    		return 0;
    	}
    }
}
public class Main {
	static char check(char a) {
		if(a == '+' || a == '-')
			return 1;
		else
			return 2;
	}
	public static void main(String[] arg) {
		Calculation c = new Calculation();
		Scanner s = new Scanner(System.in);
		ArrayList<Calculation> arr = new ArrayList<Calculation>();
		Stack<Float> s1= new Stack<>(); 
		Stack<Character> s2 = new Stack<>(); 
		while(1>0) {
			float n = s.nextFloat();
			char o = s.next().charAt(0);
			arr.add(new Calculation(n,o));
			if(o == '=')
				break;
		}
		float ans = 0;
		s1.add(arr.get(0).number);
		for(int j=1;j<arr.size();j++) {
			int i = j-1;
			if(arr.get(i).op == '+' || arr.get(i).op == '-'|| arr.get(i).op == '/'|| arr.get(i).op == '*') {
				if(s2.isEmpty()) {
					s2.add(arr.get(i).op);
					s1.add(arr.get(j).number);
				}
				else if(check(arr.get(i).op) <= check(s2.peek())) {
					while(s2.isEmpty()!=true && check(arr.get(i).op) <= check(s2.peek())) {
					float a = s1.peek();
					s1.pop();
					ans = c.calculate(s1.peek(),a,s2.peek());
					s1.pop();
					s2.pop();
					s1.add(ans);
					}
					s2.add(arr.get(i).op);
					s1.add(arr.get(j).number);
				}
				else {
					s2.add(arr.get(i).op);
					s1.add(arr.get(j).number);
				}
			}
		}
		while(s2.isEmpty()!=true) {
			float a = s1.peek();
			s1.pop();
			ans = c.calculate(s1.peek(),a,s2.peek());
			s1.pop();
			s2.pop();
			s1.add(ans);
		}
		c.p.println("The Total is = "+ans);
	}
}
