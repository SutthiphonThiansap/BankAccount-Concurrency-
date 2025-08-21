public class Depositor  implements Runnable
{
    BankAccount tmp; //บัญชีไหน
    long value; //ฝากเท่าไหร่
    int round; //ฝากกี่รอบ

    public Depositor(BankAccount tmp, long value, int round)
    {
        this.tmp = tmp;
        this.value = value;
        this.round = round;
    }


    @Override
    public void run() 
    {
        for(int i=0; i<round; i++)
        {
            tmp.deposite(value);
        }
    }
}
