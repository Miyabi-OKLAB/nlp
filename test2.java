
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
		
		
/*	手書き文字の識別結果 input.txt 読み込み	*/
		try{
			File infile = new File("input.txt");
			BufferedReader inbr = new BufferedReader( new FileReader(infile) );				
			
			while ( ( msg = inbr.readLine() ) != null ) {
				
				in = msg;
				l1 = in.length();		//	入力文字列の長さ取得
				
				System.out.println("入力文 : " + in + "\n");
				
			}
			inbr.close();
		}
		catch(FileNotFoundException e){	System.out.println(e);	}
		catch(IOException e){	System.out.println(e);	}
		
		
/*	応答ファイル読み込み	*/
		try{
			FileInputStream res = new FileInputStream("response.txt");
		    BufferedReader br = new BufferedReader( new InputStreamReader(res) );
			
			System.out.println("応答候補");
			
			while ( ( msg = br.readLine() ) != null ) {
				
	  			String[] stro = msg.split(",");
				l2 = stro[0].length();		// 応答文文字列の長さ取得
				
				for(n=0; n<=l1-l2; n++){
					
					if(stro[0].equals( in.substring(n,n+l2) )){
						
						System.out.println( String.format(stro[1]) );
						
						result[count] = stro[1];
						count++;
						mode = 1;
					}
				}
      		}
			
			System.out.println("\n応答文");
			
/*	一致する応答文がなかった場合	現在未実装	*/
	  		if(mode == 0){
	  			System.out.println("応答が未実装です");
				out = "未実装";
	  		}
			
			
/*	応答文があった場合	*/
	  		else if(mode == 1){
				int ran = rnd.nextInt(count);
				out = result[ran];
				
				System.out.println(out);
	  		}
			
			
/*	output.txt への書き出し	*/
			try{
				FileWriter outfile = new FileWriter( new File("output.txt") );
				
				outfile.write(out);
				
				outfile.close();
			}
			catch(IOException e){	System.out.println(e);	}
						
			br.close();
		}
		catch(Exception e) {	e.printStackTrace();	}
		
		
/*	ログ取り用		普段はコメントアウト	*/
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
