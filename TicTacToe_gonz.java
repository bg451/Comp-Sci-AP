import java.util.Scanner;

public class TicTacToe_gonz {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Board board = new Board();
    System.out.println(board.toString());

    while(board.check_winner()[0] == 0) {
      for(int i = 1; i < 3; ++i){
        System.out.printf("Player %d: Please enter the row: ", i);
        int x = scanner.nextInt();
        System.out.printf("\nPlayer %d: Please enter the column: ", i);
        int y = scanner.nextInt();
        if(board.bounds_check(x, y))
          board.fill_spot(i, x, y);
        else
          System.out.println("You entered an invalid location, you lose a turn!");
        System.out.println(board.toString());
      }
    }
  String winner = board.check_winner()[1] == 1 ? "Player One" : "Player Two";

  System.out.println(winner + " has won the game!");
  }
}

class Board {

  char[][] board;
  final int rows = 3;
  final int columns = 4;
  Board()
  {
    board = new char[rows][columns];
  }

  public void fill_spot(int player, int x, int y){
    System.out.println("x = " + (x - 1) + " and y = "+ (y - 1));
    if(!(board[x-1][y-1] == 'x' || board[x-1][y-1] == 'o'))
      switch(player) {
        case 1:
          board[x-1][y-1] = 'x';
          break;
        case 2:
          board[x-1][y-1] = 'o';
          break;
        default:
          System.out.println("Player 1 or player 2 only!");
      }
    else
      System.out.println("You cannot steal a spot!");
  }


  public int[] check_winner()
  {
    int[] retval = {0, 0};
    //check the rows
    for(int i = 0; i < columns; ++i)
    {
      if ((board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x')) {
        retval[0] = 1;
        retval[1] = 1;
        return retval;
      }
      if((board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o')){
        retval[0] = 1;
        retval[1] = 2;
        return retval;
      }
    }

    for(int i = 0; i < rows; ++i)
    {
      if((board[i][0] == 'x' && board[i][1] =='x' && board[i][2] == 'x') ||
        (board[i][1] == 'x' && board[i][2] =='x' && board[i][3] == 'x')) {
        retval[0] = 1;
        retval[1] = 1;
        return retval;
      }

      if((board[i][0] == 'o' && board[i][1] =='o' && board[i][2] == 'o') ||
        (board[i][1] == 'o' && board[i][2] =='o' && board[i][3] == 'o')) {
        retval[0] = 1;
        retval[1] = 1;
        return retval;
      }
    }
    return retval;
  }
  public boolean bounds_check(int x, int y)
  {
    if(x - 1 < 0 || x - 1 > rows || y - 1 < 0 || y - 1 > columns)
      return false;
    else
      return true;
  }

  public String toString()
  {
    String yield = " | 1 | 2 | 3 | 4\n";
    for(int x = 0; x < 3; x++)
    {
      yield += (x + 1);
      for(int y = 0; y < 4; y++)
      {
        if((board[x][y] == 'x') || (board[x][y] == 'o'))
          yield +="| " + board[x][y]+ " ";
        else
          yield += "|   ";
      }
      yield += "|\n";
    }
    return yield;
  }

}
