package contacts;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class Details{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	String name;
	String number;
	String email;
	Details(String n,String n1,String e){
		this.name = n;
		this.number = n1;
		this.email = e;
	}
}
class LinkedList{
	int c;
	class Node{
		Details data;
		Node next;
		public Node(Details d) {
			this.data = d;
			this.next = null;
		}
	}
	
	Node root = null;
	Node tail = null;
	public void addObject(Details d) {
		Node newnode = new Node(d);
		if(root == null) {
			root = newnode;
			tail = newnode;
		}
		else {
			tail.next = newnode;
			tail = newnode;
		}
	}
	public boolean removeByName(String n) {
		Node temp = root;
		Node pre = temp;
		if(root == null) {
			return true;
		}
	    else if(root.data.name.equals(n)) {
	    	root = root.next;
	    	return false;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.name.equals(n)) {
				pre.next = temp.next;
				return false; 
			}
			pre = temp;
			temp = temp.next;
		}
		return true;
		}		
	}
	public boolean removeByNumber(String n) {
		Node temp = root;
		Node pre = temp;
		if(root == null) {
			return true;
		}
	    else if(root.data.number.equals(n)) {
	    	root = root.next;
	    	return false;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.number.equals(n)) {
				pre.next = temp.next;
				return false; 
			}
			pre = temp;
			temp = temp.next;
		}
		return true;
		}		
	}
	public boolean removeByEmail(String n) {
		Node temp = root;
		Node pre = temp;
		if(root == null) {
			return true;
		}
	    else if(root.data.email.equals(n)) {
	    	root = root.next;
	    	return false;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.email.equals(n)) {
				pre.next = temp.next;
				return false;  
			}
			pre = temp;
			temp = temp.next;
		}
		return true;
		}		
	}	
    public Details searchByName(String n) {
    	c = 0;
    	Node temp = root;
		if(root == null) {
			return null;
		}
	    else if(root.data.name.equals(n)) {
	    	return root.data;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.name.equals(n)) {
				return temp.data;  
			}
			c++;
			temp = temp.next;
		}
		return null;
		}		
	}	
    public Details searchByNumber(String n) {
    	c = 0;
    	Node temp = root;
		if(root == null) {
			return null;
		}
	    else if(root.data.number.equals(n)) {
	    	return root.data;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.number.equals(n)){
				return temp.data;  
			}
			temp = temp.next;
			c++;
		}
		return null;
		}		
	}
    public Details searchByEmail(String n) {
    	c = 0;
    	Node temp = root;
		if(root == null) {
			return null;
		}
	    else if(root.data.email.equals(n)) {
	    	return root.data;
	    }
		else {
		while(temp != null  ) {
			if(temp.data.email.equals(n)) {
				return temp.data;  
			}
			temp = temp.next;
			c++;
		}
		return null;
		}		
	}
    public void printList(){
    	int c1=1;
		if(root == null) {
			Details.p.println("List is Empty");
		}
		else {
			Node temp = root;
			while(temp!=null) {
				Details.p.println("Person "+c1+" Details !!");
				Details.p.println("Name = "+temp.data.name);
				Details.p.println("Number = "+temp.data.number);
				Details.p.println("Email Address = "+temp.data.email);
				Details.p.println("\n");
				c1++;
				temp = temp.next;
			}
		}
	}
}
public class Storecontacts {
	static int choice;
	static int count = 1 ;
	static long number1;
	static String number;
	static String name;
	static String email;
	static boolean b ;
	static Scanner s = new Scanner(System.in);
	static Scanner s1 = new Scanner(System.in);
    static Scanner s2 = new Scanner(System.in);
    static Scanner s3 = new Scanner(System.in);
    static LinkedList l = new LinkedList();
    static Details k ;
    static void store() {
    k = null;
    b = true;
    Details.p.println("Enter the Choice like 1,2,3..7 What You Want !!\n1. Add Details \n2. Delete by Name \n3. Delete By Number\n4. Delete By Email\n5. Search By Name\n6. Search By Number\n7. Search By Email" );
	choice = s1.nextInt();
	switch(choice){
	      case 1:
	    	Details.p.println("Enter Person "+count+" Details!!");
	  		Details.p.print("Enter Name = ");
	  		name = s.nextLine();
	  		Details.p.print("Enter Contact Number = ");
	  		number = s3.nextLine();
	  		number1 = Long.valueOf(number);
	  		if(number1 <= 1000000000l || number1 >=10000000000l) {
	  			Details.p.print("Enter correct 10 digit Contact Number = ");
	  			number = s3.nextLine();
	  		}
	  		Details.p.print("Enter Email Address = ");
	  		email = s2.nextLine();	
	  		l.addObject((new Details(name,number,email)));
	  		count++;
	    	break;
	      case 2:
	    	  Details.p.println("Enter the Name");
	    	  String n = s.nextLine();
	    	  b = l.removeByName(n);
	    	  break;
	      case 3:
	    	  Details.p.println("Enter the Number");
	    	  String n1 = s3.nextLine();
	    	  b = l.removeByNumber(n1);
	      	  break;
	      case 4:
	    	  Details.p.println("Enter the Email Address");
	    	  String n3 = s2.nextLine();
	    	  b = l.removeByEmail(n3);
	    	  break;
	      case 5:
	    	  Details.p.println("Enter the Name");
	    	  String n4 = s.nextLine();
	    	  k = l.searchByName(n4);
	    	  break;
	      case 6:
	    	  Details.p.println("Enter the Number");
	    	  String n5 = s3.nextLine();
	    	  k = l.searchByNumber(n5);
	    	  break;
	      case 7:
	    	  Details.p.println("Enter the Email Adress");
	    	  String n6 = s2.nextLine();
	    	  k = l.searchByEmail(n6);
	    	  break;
	      default:
	    	  Details.p.println("Enter the Correct Choice !!");
	    	  break;
	}
	if(b && k==null && (choice>=2 && choice<=7)){
		Details.p.println("There is no Details of the person");
	}
	else if(choice>=5 && choice<=7) {
		Details.p.println("The index of the searched person is "+l.c);
		Details.p.println("Name = "+k.name);
		Details.p.println("Number = "+k.number);
		Details.p.println("Email Address = "+k.email);
	}
	}
	public static void main(String[] args) {
		char str ;
		store();
		while(1>0) {
			store();
			Details.p.println("Do you want to do anyother operation Y/N");
			str = s1.next().charAt(0);
			if(str == 'N')
				break;
		}
		l.printList();
    }
}
