package homework23_12;
/*
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebsiteParser {

    private static HashMap<String, String> urls = new HashMap<>();

    public static void parseWebsite(String url){
        sendGet(url);
    }
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    private void close() throws IOException {
        httpClient.close();
    }

    private static void sendGet(String url){

        HttpGet request = new HttpGet(url);


        try (CloseableHttpResponse response = httpClient.execute(request)) {

            checkURL(response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                checkURL(result);
//                System.out.println(result);
            }

        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void checkURL(String line){
        String tempLine = null;
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(line);

        while (urlMatcher.find())
        {
            tempLine = line.substring(urlMatcher.start(0),
                    urlMatcher.end(0));

            if (tempLine.contains("https://code.edu.az/") && !urls.containsKey(tempLine)
                    && !tempLine.contains("</") && !tempLine.contains("Kataloq")){
                urls.put(tempLine, tempLine);
                System.out.println(tempLine);
                parseWebsite(tempLine);

            }
        }


        containedUrls.forEach(System.out::println);

    }
}

 */

