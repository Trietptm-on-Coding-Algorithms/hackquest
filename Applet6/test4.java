public class test4
{
	public static void main(String []args)
	{

        for(char i = 'a'; i <= 'z'; i++)
        {
			attempt(i);
		}

        for(char i = 'A'; i <= 'Z'; i++)
        {
			attempt(i);
		}

		attempt('.');


	}

	private static void attempt(char a)
	{
        char urlchars[] = {
            '\261', '\320', '\323', '\327', '\336', '\324', '\352', '\232', '\343', '\333',
            '\311'
        };

		String crypturl = new String(urlchars);
		crypturl = decode(crypturl, a + "");

		System.out.println(a + ": " + crypturl);
	}

    private static String decode(String target, String phrase)
    {
        for(; target.length() > phrase.length(); phrase += phrase) { }
        String s1 = "";
        for(int i = 0; i < target.length(); i++)
        {
            s1 = s1 + "" + (char)(int)(Math.pow(Math.log(i), 0.0D) * (double)((target.charAt(i) - phrase.charAt(i) - i) + 5) - Math.pow(Math.log(i), 0.0D));
        }

        return s1;
    }
}


