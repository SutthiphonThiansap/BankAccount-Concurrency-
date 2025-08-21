public class BankAccount 
{
    protected long balance = 0; //ยอดเงินคงเหลือ
    public synchronized void deposite(long amount) //ยอดเงินที่จะฝาก
    {
        balance += amount; //ฝากเงิน เอายอดเงินคงเหลือ + จำนวนเงินที่จะฝาก
    }

    public synchronized void withdraw(long amount) //amount ยอดเงินทีจะถอน
    {
        if(balance >= amount ) //ถ้ายอดเงินคงเหลือ มากกว่าหรือเท่ากับ จำนวนเงินที่จะถอน
        {
            balance -= amount; //ถอนเงิน เอายอดเงินคงเหลือ - จำนวนเงินที่จะถอน
        }
    }

    public synchronized long getBalance()
    {
        return this.balance;
    }
}
