import java.awt.*;
import java.util.ArrayList;

public abstract class IField
{
     public        char[][] Field;
    public   Long freeCells;
    public int Lenght;


    public  abstract  void  DoTurn(Point p , char ch);

    public  abstract  void  RollBack(Point p, char ch);

    public  abstract  char Get(Point p);

    public ArrayList<Point> GetFreeIndexes()
    {
        ArrayList<Point> res = new ArrayList<Point>();
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field.length; j++) {
                if (Field[j][i]=='-')
                    res.add(new Point(j,i));
            }
        }
        return res;
    }
}
