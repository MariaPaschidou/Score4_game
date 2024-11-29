package main;
import java.util.Scanner;
import java.util.Random;

public class Game {
		
	private int columns;
	private int rows;
	private char[][] array;
	
	public Game() {        //kataskeuasths
		rows=20;
		columns=20;
		array=new char[rows][columns];
	}
	
	Scanner in= new Scanner(System.in); 
	
	public void setRows(int numRow) {                   //setters getters
		rows=numRow;
	}
	
	public void setColumns(int numCol) {
		columns=numCol;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void arxikopoihsh() {              //arxikopoihsh me tyxaia timh tou pinaka
		int i,j;
		for(i=0;i<rows;i++) {
			for(j=0;j<columns;j++) {
				array[i][j]='-';
			}
		}
	}
	
	public int FirstPlayer() {                  //tuxaia epilogh 1ou paikth me thn xrhsh ths random
		int playerOne;
		
		Random tuxaio=new Random();
		playerOne=tuxaio.nextInt(2);
		return playerOne;
	}
	
	Players player=new Players();                   //dhmhourgia antikeimenou enos paikth
	
	public void Insert(Players player, int col) {
		int i;
		
		System.out.print(player.getName() +" your turn. Select column: ");         //diavazei se poia sthlh tha balei to symbolo tou
		col=in.nextInt();
		
		do {
			if (!(col>=1 && col<=columns)) {                                       //den uparxei o arithmos sthlhs pou edwse
				System.out.print("Invalid number of column. Select again: ");
				col=in.nextInt();
			}
		}while (!(col>=1 && col<=columns));
		
		if (!FullCol(col-1)) {         //epitrepth eisagwgh
			for (i=rows-1;i>=0;i--) {
				if (array[i][col-1]=='-') {
					array[i][col-1]=player.getChip();
					break;
				}
			}
		}else {                                  //gemath sthlh, jana zhtaei arithmo column
			do {
				System.out.print("Full column. Select again: ");       
				col=in.nextInt();
			}while (FullCol(col-1));
		}
		printArray();
	} 
	
	public boolean diagonal1() {
		int i,j;
		 
		for(i=0;i<rows-3;i++) {                                          //elenxos gia tis diagwnies parallhla sthn kuria diagwnio, h \
			for (j=0;j<columns-3;j++) {
				if (array[i][j]==array[i+1][j+1] && array[i][j]!='-' && array[i][j]==array[i+2][j+2] && array[i][j]==array[i+3][j+3])
					return true;
			}		
		}
		return false;
	}
	
	public boolean diagonal2() {
		int i,j;
		 
		for(i=3;i<rows;i++) {                                          //elenxos gia tis diagwnies parallhla sthn deutereuousa diagwnio, h /
			for (j=0;j<columns-3;j++) {
				if (array[i][j]==array[i-1][j+1] && array[i][j]!='-' && array[i][j]==array[i-2][j+2] && array[i][j]==array[i-3][j+3])
					return true;
			}		
		}
		return false;
	}
	
	public boolean horizontal() {
		int i,j,counter=0;
		
		for (i=0;i<rows;i++) {                          //jekinaei apo katw kai elenxei olo ton pinaka an exei 4ada stis grammes
			counter=0;
			for (j=0;j<columns-1;j++) {
				if (array[i][j]==array[i][j+1] && array[i][j]!='-')
					counter++;
				else counter=0;
				if (counter==3) return true;
			}
		}
		return false;
	}
	
	public boolean vertical() {
		int i,j,counter=0;
	
		for (j=0;j<columns;j++) {            //jekinaei apo katw kai pairnei mia mia tis seires ths idias sthlhs
			counter=0;
			for (i=0;i<rows-1;i++) {
				if (array[i][j]==array[i+1][j] && array[i][j]!='-') 
					counter++;                         //metraei ta synexomena idia symbola
				else counter=0;
				if (counter==3) return true;              //an exoume 3 idia zeugaria shmainei oti exoume 4ada sthn seira
			}
		}
		return false;
	}
	
	public boolean winner(Players player1, Players player2,int col) {       //elenxei an exoume nikhth
		String onoma;
		if (diagonal1() || diagonal2() || horizontal() || vertical()) {         
			if (player1.getTurn())                                 //elenxei poios epaije teleutaios, ara poios nikhse
				onoma=player1.getName();
			else  
				onoma=player2.getName();
			System.out.print("GAME OVER. THE WINNER IS " +onoma);
			return true;
		}
		return false;
	}
	
	public boolean tie(Players player1, Players player2,int col) {               //elenxei an exoume isopalia
		if (!winner(player1,player2,col) && FullArray()) {     //na mhn exoume nikhth kai tautoxrona gemato tablo
			System.out.print("GAME OVER. WE HAVE A DRAW");
			return true;
		}
		return false;
	}
	
	public boolean FullCol(int col) {                 //elenxei an h sthlh pou epilexthke einai gemath
		 if (array[0][col]!='-') {
			 return true;
		 }else return false;
	}
	
	public boolean FullArray() {                 //elenxei an exei gemisei o pinakas-tablo
		int i;
		for (i=0;i<columns;i++) {
			if (array[0][i]=='-') return false;
		}
		return true;
	}
	
	public void printArray() {
	    int i, j;

	    // Εκτύπωση του πίνακα
	    for (i = 0; i < rows; i++) {
	        System.out.print("| ");
	        for (j = 0; j < columns; j++) {
	            if (array[i][j] == '-') {                   //an einai keno to tablo
	                System.out.print("- ");
	            } else {
	                System.out.print(array[i][j] + " ");     //an den einai keno, ektupvnei to stoixeio-sumbolo
	            }
	        }
	        System.out.println("|");
	    }

	    for (i = 0; i < 2 * columns + 2; i++) {               //katw grammh tou pinaka
	        System.out.print("-");
	    }
	    System.out.println();

	    System.out.print("  ");
	    for (i = 0; i < columns; i++) {
	        if (i + 1 < 10) {                                   //gia monochfia sthlh (<10)
	            System.out.print(i + 1 + " "); 
	        } else {
	            System.out.print(i + 1 + " ");                 //gia dichfio arithmo sthlhs
	        }
	    }
	    System.out.println();
	}
	
}
