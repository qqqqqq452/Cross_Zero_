package AI;

import WinChecker.Checks;
import abstractions.IField;
import abstractions.IPlayer;
import enums.GameStates;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public  class AI extends IPlayer
{
    private  char playerCh;
    private Move Root;
    protected int deppLvl;

    public Point DoTurn(IField field, char playerCh)
    {
        Root = new Move(new Point(-1,-1),field,'A');
        this.playerCh =playerCh;
        MinMax(Root,1,1);

        Point res = Root.branches.stream().max(Comparator.comparingInt(x -> x.score)).get().turn;

        return  new Point(res.y,res.x);
    }


    //1- ai -1 -human
    private  void MinMax(Move current, int player, int lvl)
    {
        if (lvl>=deppLvl) {

            current.score=0;
            return;
        }
        ArrayList<Point> availableIndexes = current.field.GetFreeIndexes2();
        for (int i = 0; i < availableIndexes.size(); i++)
        {
            Move newMove = new Move(availableIndexes.get(i), current.field,player==1?'A': playerCh);
            lvl++;
            int points = getPoints(newMove.field, newMove.turn, player==1?'A': playerCh);
            current.branches.add(newMove);
            if (points==-10)
                MinMax(newMove,player*-1,lvl);
            else  if (points==0)
                newMove.score=0;
            else if (points==10)
                newMove.score=player==1?10:-10;

            newMove.RollBAck();
            lvl--;
            if (( newMove.score)==10&&  player==1)
            {
                current.score=10;
                break;
            }

            if ( newMove.score==-10 && player==-1)
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

    private  int getPoints(IField field, Point start, char ch)
    {
        start  =new Point(start.y, start.x);
        GameStates cs = new Checks().Check(field,start,ch, field.Length);
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

