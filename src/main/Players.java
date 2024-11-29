package main;
import java.util.Scanner;

public class Players {
	
	private String name;
	private char symbol;
	private boolean turn;
	
	public Players(){   //kataskeuasths gia thn arxikopoihsh
		name=" ";
		symbol=' ';
		turn=false;
	}
	
	Scanner in= new Scanner(System.in);
	
	public String getName(){                 //epistrefei to onoma
		return name;
	}
	
	public void setName(String onomaGiven) {            //diavazei-orizei to onoma(to dinei o xrhsths)
		name=onomaGiven;
	}
	
	public char getChip() {                    //epistrefei to symbolo pou xrhsimopoiei o paikths
		return symbol;
	}
	
	public void setChip() {           //diavazei-orizei to symbolo(to dinei o xrhsths)
		do {
			symbol=in.nextLine().charAt(0);
			if (symbol!='x' && symbol!='o')
				System.out.print("Wrong, select again ");
		}while (symbol!='x' && symbol!='o');                  //elenxos egkurothtas, prepei to chip na einai 'o' h 'x'
	}
	
	public void remainingChip(char otherChip) {    //kathorizei to chip ths marias, tha einai auto pou den dialeje o john
		if (otherChip=='x')       
			symbol='o';
		else
			symbol='x';
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setTurn(boolean flag) {
		turn=flag;
	}
	
	public void InvertTurn() {           //allazei to boolean turn gia na paixei o epomenos
		if (turn==false) turn=true;
		else turn=false;
	}
}
