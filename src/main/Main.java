package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//orismos twn paiktwn kai twn chip tous
		
		String onomaGiven;
		
		System.out.println("This is Score4");
		
		Players player1=new Players();         //dhmioyrgia newn antikeimenwn(2 paiktwn me ta chip tous)
		Players player2=new Players();
		
		Scanner in= new Scanner(System.in);
		
		System.out.print("Please enter the name of the 1st player: ");
		onomaGiven=in.nextLine();
		player1.setName(onomaGiven);
		System.out.print("Please enter the name of the 2nd player: ");
		onomaGiven=in.nextLine();
		player2.setName(onomaGiven);
		
		System.out.print(player1.getName() + ", please select your chip: ");
		player1.setChip();
		
		player2.remainingChip(player1.getChip());                                    //chip gia 2o paikth,maria
		System.out.print(player2.getName() + ", your chip is: " +player2.getChip() +"\n");
		 
		
		//orismos pinaka(grammwn-sthlwn)
		
		int numRow,numCol,numFirstPl;
		
		Game board=new Game();              //dhmiourgia antikeimenou gia ton pinaka tou paixnidiou
		
		System.out.print("Please enter the number of rows: ");
		do {
			numRow=in.nextInt();
			board.setRows(numRow);
			if (!(numRow>=4 && numRow<=15))
				System.out.print("Incorrect input. Please enter the number of rows: ");
		}while  (!(numRow>=4 && numRow<=15));                        //elenxos egkurothtas gia na dinontai 4-15
		
		System.out.print("Please enter the number of columns: ");
		do {
			numCol=in.nextInt();
			board.setColumns(numCol);
			if (!(numCol>=4 && numCol<=15))
				System.out.print("Incorrect input. Please enter the number of columns: ");
		}while (!(numCol>=4 && numCol<=15));
			
		board.arxikopoihsh();                         
		board.printArray();            //ektupwnei to keno tablo
		
		int col=0;
		
		numFirstPl=board.FirstPlayer();
		if (numFirstPl==0) {                  //enhmerwnei poios tha paixei prwtos(xreiazetai mono gia thn 1h fora)
			player1.setTurn(true);
			board.Insert(player1,col);
		}
		else {
			player2.setTurn(true);
			board.Insert(player2,col);
		}
		
		do {                                         //paizoun enallaj
			player1.InvertTurn();
			player2.InvertTurn();
			if (player1.getTurn()) board.Insert(player1, col); 
			else board.Insert(player2, col);
		}while (!board.winner(player1,player2,col) && !board.tie(player1, player2, col));         //na mhn uparxei nikhths oute isopalia, ara sunexizetai to paixnidi
		
		
		in.close();
	}
}
