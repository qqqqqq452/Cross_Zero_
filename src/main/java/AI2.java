import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AI2 extends  IPlayer {

    private final  Point[] directions = new Point[]
            {
                    new Point(1,0),
                    new Point(0,1),
                    new Point(1,-1),
                    new Point(-1,-1)
            };

    @Override
    public Point DoTurn(char[][] field, char playerch) {
        int max = -1;
        Point turn =null;
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field.length; j++)
            {
                int all = getWinLines(field,i,j,playerch);

                if(all!=0&&all>=max) {
                    turn = new Point(j, i);
                    max=all;
                }

                if (max==4)
                    return turn;
            }
        }
        return turn;
    }

    private  boolean checkDirection2(Point startPoint, char[][] field, char playerCh,Point coef,int towin)
    {
        int result = 0;
        int swapCount=0;
        Point newPoint = new Point(startPoint.x-coef.x, startPoint.y-coef.y);
        for (int i = 0; i < field[0].length && swapCount<2; i++)
        {
            newPoint=new Point(newPoint.x+coef.x, newPoint.y+coef.y);
            if (Checks.IsPointInCorrect(field,newPoint)|| field[newPoint.y][newPoint.x]==playerCh)
            {
                i--;
                coef = new Point(coef.x*-1,coef.y*-1);
                newPoint = new Point(startPoint.x, startPoint.y);
                swapCount++;
            }
            else  if (field[newPoint.y][newPoint.x]!=playerCh)
                result++;

            if ((newPoint.x!=startPoint.x || newPoint.y!=startPoint.y)&& field[newPoint.y][newPoint.x]=='A')
                return false;

        }

        return result>=towin;
    }

    private  int getWinLines(char[][] field, int i, int j, char playerch)
    {
        int all=0;
        if (field[i][j]=='-')
        {
            for (Point coef : directions)
            {
                if (checkDirection2(new Point(j, i), field, playerch, coef, 3))
                    all += 1;
            }
        }
        return all;
    }
}
