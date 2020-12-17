package AI;

import abstractions.IField;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class  Move
{
    int score=-100;
    Point turn;
    IField field;
    ArrayList<Move> branches = new ArrayList<>();

    public  Move(Point turn, IField field, char ch)
    {
        this.field=field;
        if (turn.x!=-1)
            this.field.DoTurn(turn,ch);
        this.turn=turn;
    }

    public  void  RollBAck()
    {
        if (turn.x!=-1)
            this.field.RollBack(turn,'-');
        field=null;
    }

    @Override
    public String toString() {
        String res="";
        for (char[] row:field.Field)
            res+= Arrays.toString(row)+"\n";
        return res;
    }
}