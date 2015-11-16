//import java.io.*;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Random;

public class response{
	public static void main(String[] args){
		
		int mode = 0;
		int n;
		int l1 = 0;
		int l2 = 0;
		int count = 0;
		
		String msg = new String();
		String in = new String();
		String out = new String();
		String[] result = new String[100];
		
		Random rnd = new Random();
		
		
/*	�菑�������̎��ʌ��� input.txt �ǂݍ���	*/
		try{
			File infile = new File("input.txt");
			BufferedReader inbr = new BufferedReader( new FileReader(infile) );				
			
			while ( ( msg = inbr.readLine() ) != null ) {
				
				in = msg;
				l1 = in.length();		//	���͕�����̒����擾
				
				System.out.println("���͕� : " + in + "\n");
				
			}
			inbr.close();
		}
		catch(FileNotFoundException e){	System.out.println(e);	}
		catch(IOException e){	System.out.println(e);	}
		
		
/*	�����t�@�C���ǂݍ���	*/
		try{
			FileInputStream res = new FileInputStream("response.txt");
		    BufferedReader br = new BufferedReader( new InputStreamReader(res) );
			
			System.out.println("�������");
			
			while ( ( msg = br.readLine() ) != null ) {
				
	  			String[] stro = msg.split(",");
				l2 = stro[0].length();		// ������������̒����擾
				
				for(n=0; n<=l1-l2; n++){
					
					if(stro[0].equals( in.substring(n,n+l2) )){
						
						System.out.println( String.format(stro[1]) );
						
						result[count] = stro[1];
						count++;
						mode = 1;
					}
				}
      		}
			
			System.out.println("\n������");
			
/*	��v���鉞�������Ȃ������ꍇ	���ݖ�����	*/
	  		if(mode == 0){
	  			System.out.println("�������������ł�");
				
				int ran = rnd.nextInt(3);
				
				switch(ran){
					case 0:
						out = "���݂܂���A�킩��܂���B";
						break;
					
					case 1:
						out = "���ƌ������̂��킩��܂���ł����B";
						break;
					
					case 2:
						out = "���̎��ł͓������Ȃ��ł��B�Ⴄ��������肢���܂��B";
						break;
					default:
						out = "�������ł�";
						break;
				}
	  		}
			
			
/*	���������������ꍇ	*/
	  		else if(mode == 1){
				int ran = rnd.nextInt(count);
				out = result[ran];
				
				System.out.println(out);
	  		}
			
			
/*	output.txt �ւ̏����o��	*/
			try{
				FileWriter outfile = new FileWriter( new File("output.txt") );
				outfile.write(out);
				
				outfile.close();
			}
			catch(IOException e){	System.out.println(e);	}
						
			br.close();
		}
		catch(Exception e) {	e.printStackTrace();	}
		
		
/*	���O���p		���i�̓R�����g�A�E�g	*/
		/*
		try{
			FileWriter logfile = new FileWriter( new File("log.txt"), true );
			
			logfile.write(in + "\r\n");
			logfile.write(out + "\r\n");
			
			logfile.close();
		}
		catch(IOException e){	System.out.println(e);	}
		*/
		
    }
}
