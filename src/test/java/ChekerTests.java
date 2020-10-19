import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.awt.*;
import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChekerTests {
    /*
    @Test
    public  void  horizontalTest()
    {
        Checks cheker = new Checks();
        char[][] Field = new char[][]
        {
                new char[]{'x','x','x'},
                new char[]{'0','0','0'},
                new char[]{'0','0','0'}

        };
        GameStates f =cheker.Check(Field,new Point(0,0),'x',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(1,1),'0',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(0,1),'0',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(2,1),'0',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(0,2),'0',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(1,2),'0',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(2,2),'0',3);
        Assert.assertTrue(f==GameStates.win);
    }

    @Test
    public  void diagonalTest()
    {
        Checks cheker = new Checks();
        char[][] Field = new char[][]
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

        GameStates f =cheker.Check(Field,new Point(1,1),'x',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(0,2),'x',3);
        Assert.assertTrue(f==GameStates.win);

         f =cheker.Check(Field,new Point(0,0),'x',3);
        Assert.assertTrue(f==GameStates.win);

        f =cheker.Check(Field,new Point(2,0),'x',3);
        Assert.assertTrue(f==GameStates.win);
    }

    @Test
    public  void AITest()
    {
        char[][] Field = new char[][]
                {
                        new char[]{'x','A','x'},
                        new char[]{'x','A','-'},
                        new char[]{'A','x','-'},
                };
        Point ai = new AI().DoTurn(Field,'x');
        System.out.println(ai);
        System.out.println(AI.Iterations);
        AI.Iterations=0;


        /*Field = new char[][]
                {
                        new char[]{'A','-','-'},
                        new char[]{'-','x','-'},
                        new char[]{'-','-','-'},
                };
         ai = new AI().DoTurn(Field,'x');
        System.out.println(ai);
        System.out.println(AI.Iterations);

    }

    @Test
    public  void AI2Test()
    {
        char[][] Field = new char[][]
                {
                        new char[]{'A','-','x',},
                        new char[]{'x','-','A',},
                        new char[]{'A','x','A',},
                        //new char[]{'-','-','-','-'},
                };
        //GameStates check10 = new Checks().Check(Field,new Point(1,0),'A',3);
       // GameStates check01 = new Checks().Check(Field,new Point(0,1),'A',3);
        //new AI().DoTurn(Field,'x');
       /* long start = System.nanoTime();
        Point ai = new AI().DoTurn(Field,'x');
        System.out.println(ai);
        System.out.println(AI.Iterations);
        System.out.println("time in work  "+ (System.nanoTime() - start));
        Field = new char[][]
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
            ai = new AI2().DoTurn(Field, 'x');
            if(ai==null)
                break;
            System.out.println(ai);
            Field[ai.y][ai.x] = 'A';
            counter++;
        }

         */
        //System.out.println(counter);
        /*Field = new char[][]
                {
                        new char[]{'A','-','-'},
                        new char[]{'-','x','-'},
                        new char[]{'-','-','-'},
                };
         ai = new AI().DoTurn(Field,'x');
        System.out.println(ai);
        System.out.println(AI.Iterations);

    }
    */

    @Test
    public  void test()
    {
        char[][] field = new char[][]
                {
                        new char[]{'A','-','-',},
                        new char[]{'A','x','-',},
                        new char[]{'x','-','-',},
                        //ew char[]{'-','-','-','-'},
                };
        Field ff = new Field(3);
        ff.freeCells-=4;
        ff.Field=field;
        AI ai = new AI();
        System.out.println( ai.DoTurn(ff,'x'));

    }
}
