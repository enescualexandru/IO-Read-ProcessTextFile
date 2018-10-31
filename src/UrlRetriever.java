import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlRetriever {

    private URLConnection conn = null;

    public UrlRetriever(String url) {
        try {
            conn = new URL(url).openConnection();
            conn.connect();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public InputStream getInputStream() {
        try(InputStream inputStream = conn.getInputStream()) {
            return inputStream;
        }catch (IOException e ) {
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }
}


