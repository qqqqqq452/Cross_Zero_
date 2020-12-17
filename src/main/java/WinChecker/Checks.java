package WinChecker;

import abstractions.IField;
import enums.GameStates;

import java.awt.*;

public class Checks {

    private final  Point[] directions = new Point[]
    {
        new Point(1,0),
        new Point(0,1),
        new Point(1,-1),
        new Point(-1,-1)
    };

    public GameStates Check(IField field, Point startPoint, char ch, int toWin)
    {
        for (Point dir : directions)
        {
            int result = checkDirection(startPoint,field,ch,dir);
            if (result>=toWin)
                return  GameStates.win;
        }
        return  field.freeCells==0? GameStates.draw: GameStates.none;
    }

    private  int checkDirection(Point startPoint, IField field, char ch,Point coef)
    {
        int result = 0;
        int swapCount=0;
        Point newPoint = new Point(startPoint.x-coef.x, startPoint.y-coef.y);
        for (int i = 0; i < field.Length && swapCount<2; i++)
        {
            newPoint=new Point(newPoint.x+coef.x, newPoint.y+coef.y);
            if (Checks.IsPointInCorrect(field,newPoint)||
                    field.Get(new Point(newPoint.y, newPoint.x))!=ch)
            {
                i--;
                coef = FlipDirection(coef);
                newPoint = new Point(startPoint.x, startPoint.y);
                swapCount++;
            }
            else  if (field.Get(new Point(newPoint.y, newPoint.x))==ch)
                result++;
        }
        return result;
    }

    public static boolean IsPointInCorrect(IField field,Point value )
    {
        return value==null|| value.x<0 || value.y<0 || value.y >field.Length -1 || value.x >field.Length -1;
    }

    private  Point FlipDirection(Point p)
    {
        return  new Point(-1*p.x,-1*p.y);
    }
}