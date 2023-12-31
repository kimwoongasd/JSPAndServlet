import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
    	String uri = "http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList?serviceKey=6oUCNyNfLRSPWRqYGbhvMIoq0DAa1wDFrEZmcau6aDPC4jJtXtPXAWK%2FeaV6hJsM%2BZavP1lMg6zHnfHeWQD%2Bwg%3D%3D";
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}