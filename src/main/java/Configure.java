import java.util.Scanner;

public class Configure
{
    private  GameState state;

    public void UsersConfig(GameState state)
    {
        this.state=state;
        setSize();
        state.player1 = setPlayer();
        state.player2 = setPlayer();
    }

    public void DefaultConfig(GameState state)
    {
        state.Field = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                state.Field[i][j]='-';
            }
        }
        state.player1 = new Player("P1",'x');
        state.player2 = new Player("P2",'o');

    }

    public  void AIConfig(GameState state)
    {
        this.state=state;
        setSize();
        state.player2 = new Player("P1",'.');
        state.player1 = new AI2();
        state.player1.Name="AI";
        state.player1.Symbol='A';
    }

    private   void setSize()
    {
        System.out.println("введите одну цифру -  размер поля, поле квадратное");
        System.out.println("стандартное значение 3");

        int size=3;
        try { size = new Scanner(System.in).nextInt(); }
        catch (Exception e)
        {
            System.out.println("входные данные не верны \n значение по умолчанию :3");
        }
        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j]='-';
            }
        }

        state.Field=field;
    }

    private  Player setPlayer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите имя первого игрока");
        String name = sc.nextLine();
        System.out.println("введите символ для первого игрока");
        Character symbol = sc.nextLine().charAt(0);
        if (symbol=='-')
            System.out.println("данный символ не поддерживается \n символ будет выбран по умолчанию");
        else if((state.player1!=null && state.player1.Symbol==symbol))
        {
            System.out.println("данный символ совпадает с символом первого игрока \n символ будет выбран по умолчанию");
            symbol = '\u0580';
        }
        return  new Player(name,symbol=='-'?'.':symbol);
    }
}
