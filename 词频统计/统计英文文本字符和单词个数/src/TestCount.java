/*
 * 2014��3��22��16:57:55
 * 
 * ����Count��KeywordIdentifier��*/

public class TestCount {
	public static void main(String args[])
	{
		Count cu = new Count("test.txt");
		cu.countChar();
		cu.countWord();
		
		KeywordIdentifier key = new KeywordIdentifier("test.java");
		key.countKeyWords();
	}
}
