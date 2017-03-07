package li.download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;

public class download {
	
	public static void getInternetRes(String savepath, String resurl, String fileName) {
        URL url = null;
        HttpURLConnection con = null;
        InputStream in=null;
        FileOutputStream out = null;
        try {
            url = new URL(resurl);           
            con = (HttpURLConnection) url.openConnection();
           in=con.getInputStream();
            byte[] data = getByteData(in);//ת��Ϊbyte����
            File file = new File(savepath);
            if (!file.exists()) {
                file.mkdirs();
            }

            File res = new File(file + File.separator + fileName);
            out = new FileOutputStream(res);
            out.write(data);
            System.out.println("downloaded successfully!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out)
                    out.close();
                if (null != in)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
	 public static byte[] getByteData(InputStream in) throws IOException {
	        byte[] b = new byte[1024];
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        int len = 0;
	        while ((len = in.read(b)) != -1) {
	            bos.write(b,0,len);
	        }
	        if(null!=bos){
	            bos.close();
	        }
	        return bos.toByteArray();
	    }
	 public static void main(String[] args) {
		 
		 download.getInternetRes("d:/1.pdf","http://www.madore.org/~david/math/padics.pdf","d.pdf");
	}

}
