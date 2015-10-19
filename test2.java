
import java.io.*;
import java.util.Random;

public class test2{
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
				out = "������";
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
