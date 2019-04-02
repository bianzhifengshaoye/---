/*
 * ��Count��Ļ����ϣ�ʵ��һ����KeywordIdentifier������һ��java����Դ�ļ�����������ؼ��ֵĸ�����ע�⣬ע���г��ֵĹؼ��ֲ�����ؼ��ָ�����*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class KeywordIdentifier {
	public String filename;
	public String[] keywords = new String[]{"abstract","assert","boolean","break","byte",
			"case","catch","char","class","const",
			"continue","default","do","double","else",
			"enum","extends","final","finally","float",
			"for","goto","if","implements","import",
			"instanceof","int","interface","long","native",
			"new","package","private","protected","public",
			"return","strictfp","short","static","super",
			"switch","synchronized","this","throw","throws",
			"transient","try","void","volatile","while"};
	
	public KeywordIdentifier(String str)
	{
		filename = str;
	}
	
	//����һ������������ͳ�ƹؼ��ֵĸ���
	public void countKeyWords(){
		char ch;
		File myFile=new File(filename);

		try 
	        {
	            BufferedReader in = new BufferedReader(new FileReader(myFile));
	            String str;
	            StringBuffer str1 = new StringBuffer("");
	            while ((str = in.readLine()) != null) 
	            {	
	            	int flag1 = 0;
	        		int flag2 = 0;
	            	for (int i=0; i<str.length(); i++){
	            		
	            		//������һ��ע��ʱ�Ĵ�����
	            		if (str.charAt(i) == '/' && str.charAt(i+1) == '/')
	            		{
	            			flag2 = 1;
	            			str = str.substring(0, i);
	            			str1.append(str);		//��ȡע��֮ǰ�Ĳ���
	            			
	            		}
	            		//�����ڶ���ע��/**/ʱ�Ĵ�����
	            		else if (str.charAt(i) == '/' && str.charAt(i+1) == '*')
	            		{
	            			flag2 = 1;
	            			while ((str = in.readLine()) != null){		//����ȥ��������
	            				//System.out.println(str);
		            			for (int j=0; j<str.length(); j++){
		            				if (str.charAt(j) == '*' && str.charAt(j+1) == '/'){
		            					flag1 = 1;
		            					//break;
		            				}
		            			}
		            			if (flag1 == 1){
		            				
		            				break;
		            			}	            					
	            			}
	            			if (flag1 == 1){
	            				
	            				break;
	            			}
	            			
	            		}	
	            	}

	               if (flag2 == 0){
            			str1.append(str);
            		}       
	            }

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
	            
	            StringBuffer[] word = new StringBuffer[1000];
	            for(int i=0; i<1000; i++)
	            {
	            	word[i] = new StringBuffer();
	            }
	            
	            /*��ȡ���е���*/
	            sign_w = 1;
	            int k = 0;
	            int j = 0;
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
	                    j = 0;
	                    sign_w = 1;	                 
	                }	           
	            }
	            
	       
	            /*����ÿ�����ʵĸ���*/
	            System.out.println("\n��javaԴ�ļ��еĹؼ��ֽ���ͳ�ƣ����ؼ��ֵ������ֱ�Ϊ:");
	            for(int i = 0; i < number_w; i++)
	            {
	                /*�жϴ˵����Ƿ��ǰ��ͳ�ƹ��ĵ�����ͬ*/
	                int same = 0;
	                for(j = 0; j < i; j++)
	                {	                   
	                    if((word[i].toString().equals(word[j].toString())) == true)
	                    {	                    	
	                        same = 1;
	                        break;
	                    }
	                }
	                
	                /*ͳ�ƴ�û��ͳ�ƹ��ĵ��ʸ���*/
	                if(same == 0)
	                {
	                    int num = 0;
	                    for(j = i; j < number_w; j++)
	                    {
	                        if(word[i].toString().equals(word[j].toString()))
	                        {
	                            num++;
	                        }
	                    }
	                    //System.out.println(word[i] + ":" + num);
	                   //�ж��ǲ��ǹؼ���
	                    for (j=0; j<keywords.length; j++)
	                    {
	                    	if (word[i].toString().equals(keywords[j])){
	                    		System.out.println(word[i] + "  \t��" + num + "��");
	                    	}
	                    	else{
	                    		//System.out.println(keywords[j] + ":" + new Integer(0));
	                    	}
	                    	
	                    }
	                }
	            }	            	            
	        } 
	        catch (Exception e) 
	        {
	            //e.getStackTrace();
	        }
		
	}

}
