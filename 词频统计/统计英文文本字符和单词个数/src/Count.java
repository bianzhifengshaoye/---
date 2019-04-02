/*
 * 2014��3��22��16:57:40
 * ����һ����Count��ʵ��ͳ���ı��ļ��и����ַ����ַ����ĸ����Ĺ��ܣ�Ҫ��ʵ�֣� 
	a)	���ַ�ͳ�ƣ���������ַ�������
	b)	������ͳ�ƣ�����������ʵ�����

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Count {
	
	public String filename;
	
	public Count(String str){
		filename = str;
	}
	
	//������ͳ���ַ�����
	public void countChar(){
		int a;
		char ch,c;
		int[] num_upper = new int[26];		//���26����д��ĸ�ĸ���
		int[] num_lower = new int[26];		//���26��Сд��ĸ�ĸ�����java��int��ʼ���Զ�Ϊ0�������ֶ�����

		
		try{
			FileReader in = new FileReader(filename);		//�ַ���������
         
			while ((a = in.read()) != -1)
			{
				ch = (char)a;
				for(int i=0; i<26; i++)
				{
					//Сд��ĸ
					c = (char)('a'+i);
					if (ch == c)
					{
						num_lower[i]++;			//�ж����ĸ���ĸ��������Ӧ��ĸ�ĸ�����1
						break;
					}
					
					//��д��ĸ
					c = (char)('A'+i);
					if (ch == c)
					{
						num_upper[i]++;
						break;
					}
				}
			}
			
			//��ӡ���
			System.out.println("�Ը��ַ�����ͳ��,�����ַ������ֱ�Ϊ:");
			for (int i=0; i<26; i++)
			{
				c = (char)('a'+i);
				System.out.print((i+1)%5 == 0 ? c + ":" + num_lower[i] + "\n" : c + ":" + num_lower[i] + "\t");		//ÿ�з�5��
			}
			System.out.println();
			
		
			for (int i=0; i<26; i++)
			{
				c = (char)('A'+i);
				System.out.print((i+1)%5 == 0 ? c + ":" + num_upper[i] + "\n" : c + ":" + num_upper[i] + "\t");
			}
			System.out.println();
		}
		catch (Exception e){
		}
		
	}
	
	//������ͳ�Ƶ��ʸ���
	public void countWord(){
		char ch;
		File myFile=new File(filename);
		 try 
	        {
	            BufferedReader in = new BufferedReader(new FileReader(myFile));
	            String str;
	            StringBuffer str1 = new StringBuffer("");	//���ı��ļ��е��ַ���ȫ�������ڴ��У��˴�����str1�����ȫ���ַ��������ڲ���
	            while ((str = in.readLine()) != null) 
	            {
	            	str1.append(str);
	            }
	            in.close();
	            
	            /*ͳ���ܵĵ��ʸ���*/
	            int sign_w = 1;
	            int number_w = 0;
	            for(int i = 0; i < str1.length(); i++)
	            {
	                ch = str1.charAt(i);
	                if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
	                {
	                    sign_w = 0;
	                }
	                else if(sign_w == 0)
	                {
	                    number_w++;
	                    sign_w = 1;
	                }
	            }
	            
	            System.out.println("\n�Ե��ʽ���ͳ��,��������Ϊ:" + number_w + "��. " + "�������ʵ������ֱ�Ϊ:");	            	            
	            StringBuffer[] word = new StringBuffer[1000];		//��ŵ���
	            for(int i=0; i<1000; i++)
	            {
	            	word[i] = new StringBuffer();		//��ʼ���������ڴ�
	            }
	            
	            
	            /*��ȡ���е���*/
	            sign_w = 1;
	            int k = 0;      
	            for(int i = 0; i < str1.length(); i++)
	            {
	                ch = str1.charAt(i);	              
	                if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
	                {	                	
	                    word[k].append(ch);
	                    sign_w = 0;	                 
	                }
	                else if(sign_w == 0)
	                {
	                    k++;
	                    sign_w = 1;	                 
	                }
	           
	            }
	            
	       
	            /*����ÿ�����ʵĸ���*/
	            for(int i = 0; i < number_w; i++)
	            {	            	
	                /*�жϴ˵����Ƿ��ǰ��ͳ�ƹ��ĵ�����ͬ*/
	                int same = 0;
	                //�ȿ��õ���ǰ������е��ʣ������һ���ģ��������������һ����˵�����µ��ʣ�������һ��
	                for(int j = 0; j < i; j++)
	                {	                   
	                    if((word[i].toString().equals(word[j].toString())))		//����Ҫ��toString()���������򲻶ԣ�Ϊʲô������
	                    {	                    	
	                        same = 1;
	                        break;
	                    }
	                }
	                
	                /*�Ѿ���֤�����µ��ʣ�ͳ�ƴ�û��ͳ�ƹ��ĵ��ʸ����������ң������ж���һ���ĵ��ʣ��Ӷ�ͳ�Ƴ�����*/
	                if(same == 0)
	                {		                
	                    int num = 0;
	                    for(int j = i; j < number_w; j++)
	                    {
	                        if(word[i].toString().equals(word[j].toString()))
	                        {
	                            num++;
	                        }
	                    }
	                   System.out.println( word[i] + ":" + "\t" + num + "��");	                   
	                }
	            }	            	            
	        } 
	        catch (Exception e) 
	        {
	            //e.getStackTrace();
	        }
		
	}
}
