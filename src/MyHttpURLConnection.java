import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyHttpURLConnection  {
//public class MyHttpURLConnection extends HttpURLConnection {
//    private int myConnectTimeout = 0;
//
//    public static void main(String[] args) {
//        try {
//            MyHttpURLConnection conn = new MyHttpURLConnection(new URL("https://www.google.com/"));
//
//            // Demonstrate connect/disconnect
//            conn.connect();
//            conn.disconnect();
//
//            // Demonstrate request properties
//            conn.addRequestProperty("User-Agent", "MyHttpURLConnection");
//
//            // User interaction setting
//            System.out.println("Allow user interaction: " + conn.getAllowUserInteraction());
//
//            // Connect timeout
//            conn.setConnectTimeout(10000);
//            System.out.println("Connect timeout: " + conn.getConnectTimeout());
//
//            // Get content (dummy)
//            System.out.println("Content: " + conn.getContent());
//            System.out.println("Content with classes: " + conn.getContent(new Class<?>[0]));
//
//            // Content encoding
//            System.out.println("Content encoding: " + conn.getContentEncoding());
//
//            // Content length
//            System.out.println("Content length: " + conn.getContentLength());
//            System.out.println("Content length long: " + conn.getContentLengthLong());
//
//            // Content type
//            System.out.println("Content type: " + conn.getContentType());
//
//            // Date
//            System.out.println("Date: " + conn.getDate());
//
//            // Deprecated static methods
//            System.out.println("Default allow user interaction: " + getDefaultAllowUserInteraction());
//            System.out.println("Default request property (deprecated): " + getDefaultRequestProperty("User-Agent"));
//
//            // Using proxy
//            System.out.println("Using proxy: " + conn.usingProxy());
//
//            // InputStream (null in this mock)
//            System.out.println("InputStream: " + conn.getInputStream());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    protected MyHttpURLConnection(URL u) {
//        super(u);
//    }
//
//    @Override
//    public void addRequestProperty(String key, String value) {
//        // call superclass logic or implement your own
//        System.out.println("addRequestProperty: " + key + "=" + value);
//    }
//
//    @Override
//    public void connect() throws IOException {
//        System.out.println("connect() called");
//        connected = true;
//    }
//
//    @Override
//    public void disconnect() {
//        System.out.println("disconnect() called");
//    }
//
//    @Override
//    public boolean getAllowUserInteraction() {
//        return allowUserInteraction;
//    }
//
//    public void setConnectTimeout(int timeout) {
//        this.myConnectTimeout = timeout;
//    }
//
//    @Override
//    public Object getContent() throws IOException {
//        return "Dummy content";
//    }
//
//    @Override
//    public Object getContent(Class<?>[] classes) throws IOException {
//        return "Dummy content for classes";
//    }
//
//    @Override
//    public String getContentEncoding() {
//        return "UTF-8";
//    }
//
//    @Override
//    public int getContentLength() {
//        return -1;
//    }
//
//    @Override
//    public long getContentLengthLong() {
//        return -1L;
//    }
//
//    @Override
//    public String getContentType() {
//        return "text/plain";
//    }
//
//    @Override
//    public long getDate() {
//        return System.currentTimeMillis();
//    }
//
//    @Deprecated
//    public static boolean getDefaultAllowUserInteraction() {
//        return false; // default is usually false
//    }
//
//    @Deprecated
//    public static String getDefaultRequestProperty(String key) {
//        return null;
//    }
//
//    @Override
//    public boolean usingProxy() {
//        return false;
//    }
//
//    @Override
//    public InputStream getInputStream() throws IOException {
//        return null;
//    }

    public static void main(String[] args) {
        try {
//            URL url = new URL("http://www.google.com/");
            URL url = new URL("http://example.com/test.txt ");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // setRequestMethod
            conn.setRequestMethod("GET");

            // set timeouts
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("User-Agent", "JavaHttpClient");

            // addRequestProperty
            conn.addRequestProperty("User-Agent", "MyHttpClient");

            // getAllowUserInteraction
            System.out.println("Allow User Interaction: " + conn.getAllowUserInteraction());

            // getConnectTimeout
            System.out.println("Connect Timeout: " + conn.getConnectTimeout());

            // getDefaultAllowUserInteraction (static)
            System.out.println("Default Allow User Interaction: " + HttpURLConnection.getDefaultAllowUserInteraction());

            // getDefaultRequestProperty (static, deprecated, always null)
            System.out.println("Default Request Property: " + HttpURLConnection.getDefaultRequestProperty("User-Agent"));

            conn.connect();

            // getResponseCode
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // getContent
            Object content = conn.getContent();
            System.out.println("Content (as Object): " + content);

            // 10. getContent with classes
            Object typedContent = conn.getContent(new Class[]{String.class});
            System.out.println("Content (with classes): " + typedContent);

            // 11. getContentEncoding
            System.out.println("Content Encoding: " + conn.getContentEncoding());

            // getContentLength / getContentLengthLong
            System.out.println("Content Length: " + conn.getContentLength());
            System.out.println("Content Length Long: " + conn.getContentLengthLong());

            // getContentType
            System.out.println("Content Type: " + conn.getContentType());

            // getDate
            System.out.println("Date: " + conn.getDate());

            // getInputStream
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responseBody = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Response Body:");
            System.out.println(responseBody.toString());

            // getDefaultUseCaches() (instance method)
            System.out.println("Default Use Caches (instance): " + conn.getDefaultUseCaches());
            System.out.println("Default Use Caches With String (instance): " + conn.getDefaultUseCaches("test"));

            // --- 2. getDefaultUseCaches(String) (static method — not part of public API in standard JDK)
            // Not available in JDK 21 – likely specific to your environment or wrapper. Simulated:
//            System.out.println("Default Use Caches (static/fake): " + HttpURLConnection.getDefaultUseCaches());

            // getDoInput()
            System.out.println("Do Input: " + conn.getDoInput());

            // getDoOutput()
            System.out.println("Do Output: " + conn.getDoOutput());

            // getFollowRedirects() (static)
            System.out.println("Follow Redirects: " + HttpURLConnection.getFollowRedirects());

            // getFileNameMap() (static)
            FileNameMap fileNameMap = HttpURLConnection.getFileNameMap();
            String contentType = fileNameMap.getContentTypeFor("file.txt");
            System.out.println("FileNameMap content type: " + contentType); // e.g., text/plain

            // getExpiration()
            System.out.println("Expiration: " + conn.getExpiration());

            // getHeaderField(int)
            conn.connect();
            String headerFieldWithString = conn.getHeaderField("a");
            String headerFieldWithInt = conn.getHeaderField(0);
            System.out.println("Header Field[0]: " + headerFieldWithString);
            System.out.println("Header Field[1]: " + headerFieldWithInt);
            System.out.println("Header Field[1]: " + headerFieldWithInt);

            //9. getErrorStream()
            InputStream errorStream = conn.getErrorStream();
            if (errorStream != null) {
                System.out.println("Error stream present (non-200 response)");
            } else {
                System.out.println("Error stream is null (likely 200 OK)");
            }

            //getHeaderFieldDate, getHeaderFieldInt, getHeaderFieldKey, getHeaderFieldLong
            System.out.println("Header Field Date (Date): " +
                    conn.getHeaderFieldDate("Date", 0));
            System.out.println("Header Field Int (Content-Length): " +
                    conn.getHeaderFieldInt("Content-Length", -1));
            System.out.println("Header Field Key[0]: " +
                    conn.getHeaderFieldKey(0));
            System.out.println("Header Field Long (Content-Length): " +
                    conn.getHeaderFieldLong("Content-Length", -1L));

            // getHeaderFields
            System.out.println("Header Fields:");
            conn.getHeaderFields().forEach((key, value) ->
                    System.out.println("  " + key + " = " + value));

            // getIfModifiedSince
            System.out.println("If-Modified-Since: " + conn.getIfModifiedSince());

            // getInstanceFollowRedirects
            System.out.println("Instance Follow Redirects: " + conn.getInstanceFollowRedirects());

            // getLastModified
            System.out.println("Last Modified: " + conn.getLastModified());

            // getOutputStream (주의: GET에서는 호출하지 않는 게 안전함)
            conn.setDoOutput(true); // 만약 사용한다면 이걸 먼저 설정해줘야 함
            OutputStream os = conn.getOutputStream();
//             os.write(...); // 예제에서는 생략

            // getResponseMessage() 샘플
            String responseMessage = conn.getResponseMessage();
            System.out.println("Response Message: " + responseMessage);


            // getPermission (권한 관련 정보)
            System.out.println("Permission: " + conn.getPermission());

            // getReadTimeout
            System.out.println("Read Timeout: " + conn.getReadTimeout());

            // getRequestMethod
            System.out.println("Request Method: " + conn.getRequestMethod());

            // getRequestProperties
            System.out.println("Request Properties:");
            conn.getRequestProperties().forEach((k, v) ->
                    System.out.println("  " + k + " = " + v));

            // getRequestProperty
            System.out.println("User-Agent property: " + conn.getRequestProperty("User-Agent"));

            // getURL
            System.out.println("URL: " + conn.getURL());

            // getUseCaches
            System.out.println("Use Caches: " + conn.getUseCaches());


            // 16. disconnect
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
