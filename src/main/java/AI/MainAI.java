package AI;

import abstractions.IField;

import java.awt.*;

public class MainAI extends AI
{
    @Override
    public Point DoTurn(IField field, char playerCh)
    {
        setDeepLvl(field);
        return super.DoTurn(field, playerCh);
    }

    private  void setDeepLvl(IField field)
    {
        if (field.freeCells<=9)
            super.deppLvl=40;//40
        else
            super.deppLvl=3;//4
    }
}
