import java.awt.*;
import java.util.Scanner;

public class Player extends IPlayer
{
    public  Player(String Name, char Symbol)
    {
        this.Name=Name;
        this.Symbol=Symbol;
    }

    public Point DoTurn(IField field, char ch)
    {
        Scanner sc = new Scanner(System.in);
        String[] enter =sc.nextLine().split(" ");

        try {
            //System.out.println("readed "+enter[0]+enter[1]);

            return  new Point(Integer.parseInt(enter[0]), Integer.parseInt(enter[1]));
        }

        catch (Exception e)
        {
            //System.out.println(String.join("|", enter) + "LENGHT "+enter.length);
            return  null;
        }

    }
}
