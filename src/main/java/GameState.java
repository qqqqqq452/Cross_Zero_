import java.awt.*;

public class GameState
{
    public  IPlayer player1;
    public  IPlayer player2;
    public  IField Field;

    public  void Start()
    {
        GameStates haveWinner=GameStates.none;
        while (haveWinner==GameStates.none)
        {
            haveWinner = DoTurn(player1);
            if (haveWinner==GameStates.draw || haveWinner==GameStates.win)
            {
                GameIsWin(player1, haveWinner);
                break;
            }

            haveWinner = DoTurn(player2);
            if (haveWinner==GameStates.draw || haveWinner==GameStates.win)
                GameIsWin(player2,haveWinner);
        }
    }

    private  GameStates DoTurn(IPlayer player)
    {
        Checks winChecker = new Checks();

        System.out.println("ход игрока  "+player.Name);
        Point turn1= GetTurnPoint(player);

        Field.DoTurn(new Point(turn1.y, turn1.x),player.Symbol);
        //Field.Field[turn1.y][turn1.x]=player.Symbol;
        Print();

        GameStates isWin = winChecker.Check(Field, turn1,player.Symbol,3);
        return  isWin;
    }

    private  void GameIsWin(IPlayer winner, GameStates state)
    {
        if (state==GameStates.win)
            System.out.println("\u001B[32m"+winner.Name +"Is Win"+"\u001B[0m");
        else
            System.out.println("\u001B[32m" +"Draw"+"\u001B[0m");
        Print();
    }

    private  Point GetTurnPoint(IPlayer player)
    {
        Point turn =  null;
        boolean turnIsCorrect=false;
        while (turn==null || !turnIsCorrect || Field.Get(new Point(turn.y, turn.x))/*[turn.y][turn.x]*/!='-')
        {
            turn = player.DoTurn(Field, player2.Symbol);
            turnIsCorrect = !Checks.IsPointInCorrect(Field, turn);
            char ch = Field.Get(new Point(turn.y, turn.x));
            if (turn==null || !turnIsCorrect||Field.Get(new Point(turn.y, turn.x))/* Field.Field[turn.y][turn.x]*/!='-')
                System.out.println("входные данные не верны, повторите ввод");
        }
        return turn;

    }

    private  void Print()
    {
        for (char[] chars : Field.Field) {
            for (char ch : chars) {
                if(ch==player1.Symbol)
                    System.out.print("\u001B[31m"+ch+"\u001B[0m");
                else if (ch== player2.Symbol)
                    System.out.print("\u001B[34m"+ch+"\u001B[0m");
                else System.out.print(ch);
            }
            System.out.println("");

            //System.out.println(chars);
        }
    }
}
