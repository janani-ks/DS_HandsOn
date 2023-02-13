package calculator;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
class Calculation{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	float number;
	char op;
	Calculation(){
		p.println("Start Calculation !!");
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
	static LinkedList<Float> s1 = new LinkedList<Float>();
	static LinkedList<Character> s2 = new LinkedList<Character>();
	static boolean empty() {
		boolean b = true;
		if(s2.isEmpty()) 
			b = false;
		return b;
	}
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
				while(empty() && check(arr.get(i).op) <= check(s2.peekLast())) {
					float a = s1.peekLast();
					s1.removeLast();
					ans = c.calculate(s1.peekLast(),a,s2.peekLast());
					s1.removeLast();
					s2.removeLast();
					s1.addLast(ans);
					}
					s2.addLast(arr.get(i).op);
					s1.addLast(arr.get(j).number);
			}
		}
		while(empty()) {
			float a = s1.peekLast();
			s1.removeLast();
			ans = c.calculate(s1.peekLast(),a,s2.peekLast());
			s1.removeLast();
			s2.removeLast();
			s1.addLast(ans);
		}
		Calculation.p.println("The Total is = "+ans);
	}
}
