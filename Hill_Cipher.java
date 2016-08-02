 import java.io.*;
import java.util.*;
import java.lang.*;
public class Hill_Cipher
{
    public static void main(String[] args) throws IOException
    {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the Key");
		String key=br.readLine();
		key=key.toUpperCase();
		int len=key.length();
		int det=0;
		int idet=0,j;
		if((len!=4)&&(len!=9))
		{
			System.out.println("Key matrix will not have an Inverse\nBecause it is not square(2*2) or (3*3) Matrix");
			System.out.println("exit....");
			System.exit(0);
		}
		double no1=Math.sqrt(len);
		int no=(int)no1;
		int[][] arrkey=new int[no][no];
		int i=0,x,y;
		for(x=0;x<no;x++)
			{
				for(y=0;y<no;y++)
				{
					arrkey[x][y]=key.charAt(i);
					arrkey[x][y]=arrkey[x][y]-65;
					i++;
				}
			}
		if(len==4)
		{
			det=((arrkey[0][0]*arrkey[1][1])-(arrkey[1][0]*arrkey[0][1]));
		}
		if(len==9)
		{
				det=(arrkey[0][0]*(arrkey[1][1]*arrkey[2][2]-arrkey[1][2]*arrkey[2][1])-arrkey[0][1]*(arrkey[1][0]*arrkey[2][2]-arrkey[1][2]*arrkey[2][0])+arrkey[0][2]*(arrkey[1][0]*arrkey[2][1]-arrkey[2][0]*arrkey[1][1]));
		}	
		if(det==0)
		{
			System.out.println("Key matrix will not have a inverse");
			System.out.println("exit....");
			System.exit(0);
		}
		if(det<0)
			{
				det=-(det);
				det=det%26;
				det=(26-det);

			}
				det=det%26;

			for(j=1;j<200;j++)
			{
				if((det*j)%26==1)
				{
					idet=j;
					break;
				}
			}
			if(idet==0)
			{
				System.out.println("There is no multiplicative inverse for determinent so there will be no inverse for the key ");
				System.out.println("exit....");
			System.exit(0);
			}
		if((args[0].equals("-E"))||(args[0].equals("-e")))
			{
			System.out.println("enter the message:");
			String msg=br.readLine();
			int emsglen=msg.length(); 
			if(len==4)
			{
			if(emsglen%2!=0)
			{
				msg=msg.substring(0,emsglen)+'X';
			}}
			
			if(len==9)
			{
				if((emsglen+2)%3==0)
				{
				msg=msg.substring(0,emsglen)+'X';
				msg=msg.substring(0,emsglen+1)+'X';

				}
				if((emsglen+1)%3==0)
				{
				msg=msg.substring(0,emsglen)+'X';
				}
			}
			msg=msg.toUpperCase();
			System.out.println("ENCRYPTED MESSAGE");
			int msglen=msg.length();
			int[] message=new int[msglen];
			int[] emsg=new int[msglen];
			char[] emesg=new char[msglen];
			for(i=0;i<msglen;i++)
				{
					message[i]=msg.charAt(i)-65;
				}
			for(i=0;i<msglen;i++)
			{
			//	System.out.println(message[i]);
			}
			int var=0;
		
				for(i=0;i<msglen-1;i++)
				{
					for(x=0;x<no;x++)
					{
					
						for(y=0;y<no;y++)
						{
						//	System.out.println(emsg[var]+" "+i);
							emsg[var]=emsg[var]+(arrkey[x][y]*message[i]);
							i=i+1;
						}
					//	System.out.println(emsg[var]);
						i=i-no;
						var++;
					}i=i+(no-1);
				}
			
			for(i=0;i<msglen;i++)
			{
				emsg[i]=(emsg[i]%26)+65;
				emesg[i]=(char) emsg[i];
				System.out.print(emesg[i]);
			}
			
		}
		if((args[0].equals("-d"))||(args[0].equals("-D")))
		{
			int[][] adjarr=new int[no][no];
			if(no==2)
			{
			adjarr[0][0]=arrkey[1][1];
			adjarr[0][1]=-arrkey[0][1];
			adjarr[1][0]=-arrkey[1][0];
			adjarr[1][1]=arrkey[0][0];
			}
			if(no==3)
			{
				adjarr[0][0]=(arrkey[1][1]*arrkey[2][2])-(arrkey[2][1]*arrkey[1][2]);
				adjarr[0][1]=-((arrkey[0][1]*arrkey[2][2])-(arrkey[0][2]*arrkey[2][1]));
				adjarr[0][2]=(arrkey[0][1]*arrkey[1][2])-(arrkey[0][2]*arrkey[1][1]);
				adjarr[1][0]=-((arrkey[1][0]*arrkey[2][2])-(arrkey[1][2]*arrkey[2][0]));
				adjarr[1][1]=(arrkey[0][0]*arrkey[2][2])-(arrkey[0][2]*arrkey[2][0]);
				adjarr[1][2]=-((arrkey[0][0]*arrkey[1][2])-(arrkey[0][2]*arrkey[1][0]));
				adjarr[2][0]=(arrkey[1][0]*arrkey[2][1])-(arrkey[1][1]*arrkey[2][0]);
				adjarr[2][1]=-((arrkey[0][0]*arrkey[2][1])-(arrkey[0][1]*arrkey[2][0]));
				adjarr[2][2]=(arrkey[0][0]*arrkey[1][1])-(arrkey[0][1]*arrkey[1][0]);
			}
			for(x=0;x<no;x++)
		{
			for(y=0;y<no;y++)
			{
			if(adjarr[x][y]<0)
				{	
					adjarr[x][y]=-(adjarr[x][y]);
					adjarr[x][y]=adjarr[x][y]%26;
					adjarr[x][y]=26-adjarr[x][y];
				}
					adjarr[x][y]=adjarr[x][y]%26;
			}
		}	
			for(x=0;x<no;x++)
			{
				for(y=0;y<no;y++)
				{
				if(adjarr[x][y]<0)
				{
					adjarr[x][y]=adjarr[x][y]+26;
				}
					adjarr[x][y]=(idet*adjarr[x][y])%26;
				}
			}
			System.out.println("enter the message:");
			String msg=br.readLine();
			msg=msg.toUpperCase();
				int emsglen=msg.length(); 
			int msglen=msg.length();
			int[] message=new int[msglen];
			int[] emsg=new int[msglen];
			char[] emesg=new char[msglen];
			for(i=0;i<msglen;i++)
				{
					message[i]=msg.charAt(i)-65;
				//	System.out.println(message[i]);
				}
				
				int var=0;
				for(i=0;i<msglen-1;i++)
				{
					for(x=0;x<no;x++)
					{
					
						for(y=0;y<no;y++)
						{
						//	System.out.println(emsg[var]+" "+i+" "+x+" "+y+" "+arrkey[x][y]*message[i]);
							emsg[var]=emsg[var]+(adjarr[x][y]*message[i]);
							i=i+1;
						}
					//	System.out.println(emsg[var]);
						i=i-no;
						var++;
					}i=i+(no-1);
				}
				System.out.println("DECRYPTED MESSAGE");
			for(i=0;i<msglen;i++)
			{
				emsg[i]=(emsg[i]%26)+65;
				emesg[i]=(char) emsg[i];
				System.out.print(emesg[i]);
			}
		}System.out.println();
}
}
