public class test2
{
    public static void main(String []args)
    {
		System.out.println(decrypt("NpGdw~Vh{|\201z~q"));
    }


    private static String decrypt(String s)
    {
        String s1 = "";
        for(int i = 0; i < s.length(); i++)
        {
            s1 = s1 + "" + (char)(s.charAt(i) - i);
        }

        return s1;
    }
}
