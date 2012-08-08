
public class test
{
	String characterset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String []args)
	{
        int passhash = 0x1a98b;
        int trypass = hash(args[0]);

		int position = 16;

		for(char i = 'a'; i <= 'z'; i++)
		{
		String str = "zzzzzzzzzzzzzzz";

        System.out.println("Hash = " + trypass);
        System.out.println("Good = " + passhash);


    }

    private static int hash(String target)
    {
        int hash = 0;
        for(int i = 0; i < target.length(); i++)
        {
            hash += target.charAt(i) * i * i;
        }

        return hash;
    }
}
