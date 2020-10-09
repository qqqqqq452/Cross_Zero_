import java.awt.*;

public abstract class IPlayer
{
    public String Name;
    public  char Symbol;

    public  IPlayer()
    {}



    public abstract Point DoTurn(char[][] field, char playerch);
}
