package li.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
	public static void main(String[] args) {
		URL url=null;
		HttpURLConnection connection=null;
		
		try {
			url=new URL("http://www.madore.org/~david/math/padics.pdf");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection=(HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			InputStream in=connection.getInputStream();
			BufferedInputStream bio=new BufferedInputStream(in);
			FileOutputStream fos=new FileOutputStream("d:/s.pdf");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			byte[] input=new byte[1024];
			while (bio.read(input)!=-1){
				bos.write(input);
				
			}
			System.out.println("≥…π¶œ¬‘ÿ");
			bos.close();
			fos.close();
			bio.close();
			in.close();
			
			 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}
	

}
