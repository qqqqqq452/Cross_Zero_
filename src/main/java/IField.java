import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class IField
{
    public   char[][] Field;
    public   Long freeCells;
    public int Length;


    public  abstract  void  DoTurn(Point p , char ch);

    public  abstract  void  RollBack(Point p, char ch);

    public  abstract  char Get(Point p);

    public ArrayList<Point> GetFreeIndexes()
    {
        ArrayList<Point> res = new ArrayList<Point>();
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field.length; j++) {
                if (Field[j][i]=='-' && IsThereNeighboors(new Point(j,i)))
                    res.add(new Point(j,i));
            }
        }
        ArrayList<Point> empty = new ArrayList();
        empty.add(new Point(this.Length/2, this.Length/2));
        return res.size()==0?empty:res;
    }


    public ArrayList<Point> GetFreeIndexes2()
    {
        ArrayList<Point> res1 = new ArrayList<Point>();
        ArrayList<Point> res2 = new ArrayList<Point>();
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field.length; j++) {
                if (Field[j][i]=='A')
                    AddAllNeighboors(new Point(j,i),res1);
                else if (Field[j][i]!='A' &&Field[j][i]!='-'  && IsThereNeighboors(new Point(j,i)))
                    AddAllNeighboors(new Point(j,i),res2);
            }
        }
        ArrayList<Point> empty = new ArrayList();
        empty.add(new Point(this.Length/2, this.Length/2));
        res1.addAll(res2);
        ArrayList<Point> result =(ArrayList<Point>)(res1.stream().distinct().collect(Collectors.toList()));
        return result.size()==0?empty:result;
    }

    private  void AddAllNeighboors(Point p , ArrayList result)
    {
        Point[] directions = new Point[]
                {
                        new Point(1, 0),
                        new Point(-1, 0),
                        new Point(0, 1),
                        new Point(0, -1),
                        new Point(1, -1),
                        new Point(-1, 1),
                        new Point(-1, -1),
                        new Point(1, 1)
                };
        for (Point dir : directions)
        {
            Point newPoint = new Point(p.x+dir.x,p.y+dir.y);
            if (!Checks.IsPointInCorrect(this, newPoint) && Field[p.x+dir.x][p.y+dir.y]=='-')
                result.add(newPoint);
        }
    }

    private boolean IsThereNeighboors(Point point)
    {
        Point[] directions = new Point[]
        {
                new Point(1, 0),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(0, -1),
                new Point(1, -1),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(1, 1)
        };
        for (Point p : directions)
        {
            Point newPoint = new Point(point.x+p.x,point.y+p.y);
            if (!Checks.IsPointInCorrect(this, newPoint) && Field[point.x+p.x][point.y+p.y]!='-')
                return true;
        }
        return false;
    }
}
