import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public  class AI extends IPlayer
{
    public  static  int Iterations=0;
    private  char playerCh;
    private Move Root;

    public Point DoTurn(char[][] field, char playerch)
    {
        Root = new Move(new Point(-1,-1),field,'A');
        this.playerCh =playerch;
        MinMax(Root,1,1);

        Point res = Root.branches.stream().max(Comparator.comparingInt(x -> x.score)).get().turn;

        return  new Point(res.y,res.x);
    }

    private  ArrayList<Point> GetFreeIndexes(char[][] field)
    {
        ArrayList<Point> res = new ArrayList<Point>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i]=='-')
                    res.add(new Point(j,i));
            }
        }
        return res;
    }
//1- ai -1 -human
    private  void MinMax(Move current, int player, int lvl)
    {
        Iterations++;
        ArrayList<Point> availableIndexes = GetFreeIndexes(current.field);
        for (int i = 0; i < availableIndexes.size(); i++)
        {
            Move newMove = new Move(availableIndexes.get(i), current.field,player==1?'A': playerCh);
            int points = getPoints(newMove.field, newMove.turn, player==1?'A': playerCh);
            current.branches.add(newMove);
            if (points==-10)
                MinMax(newMove,player*-1,lvl++);
            else  if (points==0)
                newMove.score=0;
            else if (points==10)
                newMove.score=player==1?10:-10;

            newMove.RollBAck();

            if (newMove.score==10&&  player==1)
            {
                current.score=10;
                break;
            }

            if (newMove.score==-10 && player==-1)
            {
                current.score=-10;
                break;
            }


        }


        if(current.score==-100)
        {
            Move bestMove;
            if (player==1)
                 bestMove = current.branches.stream().max(Comparator.comparingInt(x -> x.score)).get();
            else
                bestMove = current.branches.stream().min(Comparator.comparingInt(x -> x.score)).get();
            current.score=bestMove.score;
        }


    }

    private  int getPoints(char[][] field, Point start, char ch)
    {
        start  =new Point(start.y, start.x);
        GameStates cs = new Checks().Check(field,start,ch,3);
        switch (cs)
        {
            case win:
                return 10;
            case draw:
                return 0;
            case none:
                return -10;
            default:
                throw  new UnsupportedOperationException();
        }
    }
}

 class  Move
{
    int score=-100;
    Point turn;
    char[][] field;
    ArrayList<Move> branches = new ArrayList<>();

    public  Move(Point turn, char[][] field, char ch)
    {
        this.field=field;
        //this.field = new char[field.length][field.length];
       /* for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                    this.field[j][i]=field[j][i];
            }
        }

        */
        if (turn.x!=-1)
            this.field[turn.x][turn.y]= ch;
        this.turn=turn;
    }

    public  void  RollBAck()
    {
        if (turn.x!=-1)
            this.field[turn.x][turn.y]= '-';
    }

    @Override
    public String toString() {
         String res="";
         for (char[] row:field)
             res+=Arrays.toString(row)+"\n";
         return res;
    }
}