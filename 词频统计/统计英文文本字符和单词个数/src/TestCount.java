/*
 * 2014年3月22日16:57:55
 * 
 * 测试Count和KeywordIdentifier类*/

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
