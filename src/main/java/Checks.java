import java.awt.*;

public class Checks {

    private final  Point[] directions = new Point[]
    {
        new Point(1,0),
        new Point(0,1),
        new Point(1,-1),
        new Point(-1,-1)
    };

    public GameStates Check(char[][] field, Point startPoint,char ch, int toWin)
    {
        for (int i = 0; i < directions.length; i++)
        {
            int result = checkDirection(startPoint,field,ch,directions[i]);
            if (result>=toWin)
                return  GameStates.win;
        }
        return  IsDraw(field)?GameStates.draw: GameStates.none;
    }

    private  int checkDirection(Point startPoint, char[][] field, char ch,Point coef)
    {
        int result = 0;
        int swapCount=0;
        Point newPoint = new Point(startPoint.x-coef.x, startPoint.y-coef.y);
        for (int i = 0; i < field[0].length && swapCount<2; i++)
        {
            newPoint=new Point(newPoint.x+coef.x, newPoint.y+coef.y);
            if (Checks.IsPointInCorrect(field,newPoint)|| field[newPoint.y][newPoint.x]!=ch)
            {
                i--;
                coef = FlipDirection(coef);
                newPoint = new Point(startPoint.x, startPoint.y);
                swapCount++;
            }
            else  if ( field[newPoint.y][newPoint.x]==ch)
                result++;
        }
        return result;
    }

    private  boolean IsDraw(char[][] field)
    {
        for(char[] row : field)
        {
            for(char ch : row)
                if (ch=='-')
                    return  false;
        }
        return  true;
    }

    public static boolean IsPointInCorrect(char[][] field,Point value )
    {
        return value==null|| value.x<0 || value.y<0 || value.y >field.length-1 || value.x >field[0].length-1;
    }

    private  Point FlipDirection(Point p)
    {
        return  new Point(-1*p.x,-1*p.y);
    }
}