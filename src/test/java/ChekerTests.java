import AI.AI;
import Entities.Field;
import org.junit.Test;

import java.io.IOException;

public class ChekerTests {
    /*
    @Test
    public  void  horizontalTest()
    {
        WinChecker.Checks cheker = new WinChecker.Checks();
        char[][] Entities.Field = new char[][]
        {
                new char[]{'x','x','x'},
                new char[]{'0','0','0'},
                new char[]{'0','0','0'}

        };
        enums.GameStates f =cheker.Check(Entities.Field,new Point(0,0),'x',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(1,1),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(0,1),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(2,1),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(0,2),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(1,2),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(2,2),'0',3);
        Assert.assertTrue(f==enums.GameStates.win);
    }

    @Test
    public  void diagonalTest()
    {
        WinChecker.Checks cheker = new WinChecker.Checks();
        char[][] Entities.Field = new char[][]
                {
                        new char[]{'x','0','x'},
                        new char[]{'0','x','0'},
                        new char[]{'x','0','x'}

                };

        char[][] Field2 = new char[][]
                {
                        new char[]{'x','0','0'},
                        new char[]{'0','-','0'},
                        new char[]{'x','x','x'}

                };

        enums.GameStates f =cheker.Check(Entities.Field,new Point(1,1),'x',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(0,2),'x',3);
        Assert.assertTrue(f==enums.GameStates.win);

         f =cheker.Check(Entities.Field,new Point(0,0),'x',3);
        Assert.assertTrue(f==enums.GameStates.win);

        f =cheker.Check(Entities.Field,new Point(2,0),'x',3);
        Assert.assertTrue(f==enums.GameStates.win);
    }

    @Test
    public  void AITest()
    {
        char[][] Entities.Field = new char[][]
                {
                        new char[]{'x','A','x'},
                        new char[]{'x','A','-'},
                        new char[]{'A','x','-'},
                };
        Point ai = new AI.AI().DoTurn(Entities.Field,'x');
        System.out.println(ai);
        System.out.println(AI.AI.Iterations);
        AI.AI.Iterations=0;


        /*Entities.Field = new char[][]
                {
                        new char[]{'A','-','-'},
                        new char[]{'-','x','-'},
                        new char[]{'-','-','-'},
                };
         ai = new AI.AI().DoTurn(Entities.Field,'x');
        System.out.println(ai);
        System.out.println(AI.AI.Iterations);

    }

    @Test
    public  void AI2Test()
    {
        char[][] Entities.Field = new char[][]
                {
                        new char[]{'A','-','x',},
                        new char[]{'x','-','A',},
                        new char[]{'A','x','A',},
                        //new char[]{'-','-','-','-'},
                };
        //enums.GameStates check10 = new WinChecker.Checks().Check(Entities.Field,new Point(1,0),'A',3);
       // enums.GameStates check01 = new WinChecker.Checks().Check(Entities.Field,new Point(0,1),'A',3);
        //new AI.AI().DoTurn(Entities.Field,'x');
       /* long start = System.nanoTime();
        Point ai = new AI.AI().DoTurn(Entities.Field,'x');
        System.out.println(ai);
        System.out.println(AI.AI.Iterations);
        System.out.println("time in work  "+ (System.nanoTime() - start));
        Entities.Field = new char[][]
                {
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                        new char[]{'-','-','-','-','-','-','-','-'},
                       // new char[]{'-','-','-','-','-','-'},
                        //new char[]{'-','-','-','-','-','-'},
                };
        /*int counter =0;
        while (ai!=null)
        {
            ai = new AI.AI2().DoTurn(Entities.Field, 'x');
            if(ai==null)
                break;
            System.out.println(ai);
            Entities.Field[ai.y][ai.x] = 'A';
            counter++;
        }

         */
        //System.out.println(counter);
        /*Entities.Field = new char[][]
                {
                        new char[]{'A','-','-'},
                        new char[]{'-','x','-'},
                        new char[]{'-','-','-'},
                };
         ai = new AI.AI().DoTurn(Entities.Field,'x');
        System.out.println(ai);
        System.out.println(AI.AI.Iterations);

    }
    */

    @Test
    public  void test() throws IOException {
        char[][] field = new char[][]
                {
                        new char[]{'x','x','-',},
                        new char[]{'-','A','A',},
                        new char[]{'-','A','-'},
                        //new char[]{'x','x','-',},
                        //new char[]{'-','-','-','-','-'},
                };

        Field ff = new Field(3);
       ff.freeCells-=5;
       ff.Field=field;
        AI ai = new AI();

        //System.out.println(Files.walkFileTree(pp, );
        //System.out.println(ii);
        //System.out.println(new WinChecker.Checks().Check(ff, new Point(2,0), 'A',3));
        //System.out.println( ai.DoTurn(ff,'x'));

    }
}
