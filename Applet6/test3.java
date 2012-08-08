import java.io.*;

public class test3
{
	public static void main(String []args) throws Exception
	{
        int passhash = 0x1a98b;

        BufferedReader in1 = new BufferedReader(new FileReader(new File("English2.txt")));

        while(true)
		{
			String pass1 = in1.readLine();
			if(pass1.length() != 10)
				continue;

			if(pass1.charAt(0) > 't' && pass1.charAt(0) <= 'z')
				continue;

			if(pass1.charAt(1) > 'r' && pass1.charAt(1) < 'y')
				continue;

			if(pass1.charAt(2) > 't' && pass1.charAt(2) <= 'z')
				continue;

			if(pass1.charAt(4) >= 'a' && pass1.charAt(4) < 'd')
				continue;

			if(pass1.charAt(5) > 'r' && pass1.charAt(5) < 'y')
				continue;

//			if(pass1.charAt(5) == '\'')
//				continue;

			if(pass1.charAt(6) >= 'a' && pass1.charAt(6) < 'n')
				continue;

			if(pass1.charAt(7) != 'i')
				continue;

			if(pass1.charAt(8) != 'o')
				continue;

			if(pass1.charAt(9) != 'n')
				continue;

//			System.out.println(pass1);
			BufferedReader in2 = new BufferedReader(new FileReader(new File("English2.txt")));
			while(true)
			{
				String pass2 = in2.readLine();

				if(pass2 == null)
					break;

				if(pass2.length() < 2)
					continue;

				if(pass2.charAt(0) != 's')
					continue;

//				System.out.println(pass2);

//				if(pass2.charAt(0) > 'v')
//					continue;
//
//				if(pass2.charAt(1) < 'e')
//					continue;

				String pass = pass1.substring(0, 1).toUpperCase() + pass1.substring(1) + pass2.substring(0, 1).toUpperCase() + pass2.substring(1);

				int hash = hash(pass);

				if(hash == passhash)
				{

					String crypturl2 = decode(pass);
					String crypturl3 = decode2(pass);

					System.out.format("%9s %s %s %s\n", hash, pass, crypturl2, crypturl3);
				}
			}
		}

//        System.out.println("Good = " + passhash);


    }

    private static int hash(String target)
    {
//		if(1==1)
//			return 0x1a98b;

        int hash = 0;
        for(int i = 0; i < target.length(); i++)
        {
            hash += target.charAt(i) * i * i;
        }

        return hash;
    }

    private static String decode(String phrase)
    {
		String target = new String(new char[]{	'\261', '\320', '\323', '\327', '\336', '\324', '\352', '\232', '\343', '\333', '\311'	});

        for(; target.length() > phrase.length(); phrase += phrase) { }
        String s1 = "";
        for(int i = 0; i < target.length(); i++)
        {
            s1 = s1 + "" + (char)(int)(Math.pow(Math.log(i), 0.0D) * (double)((target.charAt(i) - phrase.charAt(i) - i) + 5) - Math.pow(Math.log(i), 0.0D));
        }

        return s1;
    }

    private static String decode2(String phrase)
    {
		String target = new String(new char[] {181, 211, 213, 216, 222, 211, 232, 151, 223, 214, 195});

        for(; target.length() > phrase.length(); phrase += phrase) { }
        String s1 = "";
        for(int i = 0; i < target.length(); i++)
			s1 += (char)(target.charAt(i) - phrase.charAt(i));

        return s1;
    }
}
