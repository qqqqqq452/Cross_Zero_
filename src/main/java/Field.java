import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Field {
    public char[][] field ;
    public int freeCelsCOunter;
    public HashSet<Point> freeIndexes;

    public  Field(int size)
    {
        field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j]='-';
                freeIndexes.add(new Point(i,j));
            }
        }
        freeCelsCOunter = size*size;
    }

    public void DoTurn(Point turn, char ch)
    {
        field[turn.y][turn.x] = ch;
        freeCelsCOunter--;
        freeIndexes.remove(turn);
    }
}
