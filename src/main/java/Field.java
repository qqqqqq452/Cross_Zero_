import java.awt.*;
import java.util.HashSet;

public class Field extends IField {
    public HashSet<Point> freeIndexes;

    public  Field(int size)
    {
        this.Field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.Field[i][j]='-';
                //freeIndexes.add(new Point(i,j));
            }
        }
        this.Length =size;
        freeCells = (long)size*size;
    }

    public void DoTurn(Point turn, char ch)
    {
        this.Field[turn.x][turn.y] = ch;
        this.freeCells--;
        //freeIndexes.remove(turn);
    }

    @Override
    public void RollBack(Point p, char ch) {
        DoTurn(p,ch);
        this.freeCells+=2;
    }

    @Override
    public char Get(Point p) {
        return this.Field[p.x][p.y];
    }
}
