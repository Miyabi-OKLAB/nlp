package soundsample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mecabv2 {
 public static void main(String[] args) {
  try {
	  
   // コマンド結果をProcessで受け取る
   ProcessBuilder ps = new ProcessBuilder("mecab", "C:\\home\\mecab.txt");
   ps.redirectErrorStream(true);
   Process p = ps.start();
   
   //InputStream is = p.getInputStream();
   //try {
	//	while(is.read() >= 0); //標準出力だけ読み込めばよい
	//} finally {
	//	is.close();
	//}
   //System.out.println("戻り値：" + p.exitValue());
   
   // 標準出力
   BufferedReader bReader_i = new BufferedReader(new InputStreamReader(p.getInputStream(),"Shift_JIS"));

   // 標準出力を1行ずつ受け取る一時オブジェクト
   String targetLine;
   
   String str;
   // 形態素解析結果を全て解析する
   while ((str = bReader_i.readLine()) != null) {

    // 形態素解析結果を1行ずつ受け取る
    targetLine = bReader_i.readLine();

    // 最終行まで解析が完了したらループを抜ける
    if (targetLine == null) {
     break;
    } else if (targetLine.equals("EOS")) {
     continue;
    } else {
     // 品詞
     String targetType = targetLine.split("[\t|,]")[1];
     if (targetType.equals("名詞")) {
      // 名詞を表示する
      System.out.println(targetLine);
     }
    }

   }

   // 終了を待つ
   p.waitFor();

  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}