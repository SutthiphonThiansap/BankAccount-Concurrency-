import java.util.ArrayList;

public class BankTest 
{
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DOPOSITOR = 3;
        int NUM_WITHDRAWER = 3;
        int VALUE = 100;
        int ROUND = 10000;

        //สร้างคนฝาก
        for(int i = 0; i<NUM_DOPOSITOR; i++)
        {
            Thread x = new Thread(new Depositor(a, VALUE, ROUND));
            t.add(x);
        }

        //สร้างคนถอน
        for(int i = 0; i<NUM_WITHDRAWER; i++)
        {
            Thread y = new Thread(new withdraw(a,VALUE,ROUND));
            t.add(y);
        }


        //สั่งทำงาน
        for(Thread thread : t)
        {
            thread.start();
        }

        //ทำงานจนเสร็จ
        try 
        {
            for(Thread thread : t)
            {
                thread.join();
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        
        System.out.println("Expected deposit value : " + ( (NUM_DOPOSITOR * VALUE * ROUND) - (NUM_WITHDRAWER * VALUE * ROUND)));
        System.out.println("Real value : " + a.getBalance());
    }
}
