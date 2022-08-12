package com.framework.automation.utils;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This RestUtil class consists of all required REST reusable methods
 *
 * @since 05-16-2019
 * @version 2.4
 *
 */
public class RestUtil {

    public static Properties config = new Properties();
    static Logger logger = LogManager.getLogger(TestUtil.class);
    static StringBuilder request_sb = new StringBuilder();
    static String requestTimeStamp;
    static String responseTimeStamp;
    static StringBuilder response_sb = new StringBuilder();
    static String env;

    String proxyHost = "";
    String userName = "";
    String password = "";
    int proxyPort = 0;
    MessageTypes dataType;

    static {
        try {
            env = System.getProperty("Env");
            InputStream str = new FileInputStream("config.Properties");
            config.load(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Empty constructor for RestUtil with no arguments
     */
    public  RestUtil(){
    }

    /**
     * Constructor for RestUtil to initialize proxy Host, Port and datatype
     * @param proxyHost, proxyPort, dataType
     */
    public RestUtil(String proxyHost, int proxyPort, MessageTypes dataType){
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.dataType = dataType;
    }

    /**
     * Constructor for RestUtil to initialize proxy Host, Port and username, Password
     * @param proxyHost, proxyPort, dataType, userName, password
     */
    public RestUtil(String proxyHost, int proxyPort, MessageTypes dataType, String userName, String password) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.dataType = dataType;
        this.userName = userName;
        this.password = password;
    }

    /**
     * buildHTTPGetRequest method is used toe build HTTP get request
     *
     * @param -String url, contentType
     * @return RequestBuilder
     * @throws Exception
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    public static RequestBuilder buildHTTPGetRequest(String url,
                                                     String contentType) {
        RequestBuilder requestBuilder = RequestBuilder.get().setUri(url)
                .setHeader(HttpHeaders.CONTENT_TYPE, contentType)
                .setHeader(HttpHeaders.HOST, getHostName(url));
        return requestBuilder;
    }

    /**
     * getHostName method is used to get the host name
     *
     * @param -String url
     * @return String
     * @throws
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    public static String getHostName(String uri) {
        String hostname = null;
        if (uri.startsWith("https://") || uri.startsWith("http://"))
            hostname = uri.split("//")[1].split("/")[0];
        else
            hostname = uri.split("/")[0];
        return hostname;

    }

    /**
     * getHTTPResponse is to receive http response in return
     *
     * @param -Requestbuilder
     * @return Http Response
     * @throws
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    public static HttpResponse getHttpResponse(RequestBuilder requestBuilder) {

        HttpResponse response = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpUriRequest request = requestBuilder.build();
            response = client.execute(request);
            System.out.println("Reached here!!!");
        } catch (ClientProtocolException e) {
            response = null;
            e.printStackTrace();
        } catch (IOException e) {
            response = null;
            e.printStackTrace();
        }
        return response;
    }

    /**
     * readResponseString method is used to read the response string
     *
     * @param -HttpResponse response
     * @return String response string
     * @throws
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    public static String readResponseString(HttpResponse response) {
        StringBuffer result = new StringBuffer();
        String line = null;
        String responseString = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            responseString = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("******* END OF RESPONSE STRING **********");
        return responseString;
    }

    /**
     * getTimeUS method is used to get tge US time
     *
     * @param -String Timezone code
     * @return String time format
     * @throws
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    private static String getTimeUS(String timeZone) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * toByteArray method is convert a file to byte array
     *
     * @param -File file
     * @return Byte array
     * @throws
     * @see -
     * @since 08-05-2019
     * @version 1.2
     *
     */
    public static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    /**
     * buildHTTPREquestForRole is used to build the request for basic auth and json payload
     * @param -String url
     * @return Request Builder
     *
     */
    public static RequestBuilder buildHTTPPostRequestForRole(String url) {
        RequestBuilder requestBuilder = RequestBuilder
                .post()
                .setUri(url)
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION,
                        "Basic a3Jpc2huZW5kdV9zOklBbW1hJDE3MTcy")
                .setHeader(HttpHeaders.HOST, getHostName(url));
        return requestBuilder;
    }

    /**
     * getHttp ResponseforStringreqentry is used to get response fir a string entry
     * @param requestBuilder
     * @param inputString
     * @return HttpResponse
     *
     */
    public static HttpResponse getHttpResponseForStringReqEntity(
            RequestBuilder requestBuilder, String inputString) {
        HttpResponse response = null;
        try {
            long millis = System.currentTimeMillis() % 1000;
            requestTimeStamp = getTimeUS("PST");
            HttpClient client = HttpClientBuilder.create().build();
            StringEntity requestEntity = new StringEntity(inputString);
            HttpUriRequest request = requestBuilder.setEntity(requestEntity)
                    .build();
            response = client.execute(request);
            responseTimeStamp = getTimeUS("PST");
            long millis1 = System.currentTimeMillis() % 1000;
            long diff = millis1 - millis;
            System.out.print("execution time is " + diff + "\n");
        } catch (ClientProtocolException e) {
            response = null;
            e.printStackTrace();
        } catch (IOException e) {
            response = null;
            e.printStackTrace();
        }
        return response;
    }


    /**
     * buildHTTPPostRequest is used to build post request for a requested entry
     * @param url
     * @param requestEntity
     * @return
     *
     */
    public static RequestBuilder buildHTTPPostRequest(String url,
                                                      StringEntity requestEntity) {
        RequestBuilder requestBuilder = RequestBuilder.post().setUri(url)
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .setEntity(requestEntity);
        return requestBuilder;
    }

    //######################################//

    /**
     * getConnection is used for generating and getting the connection
     * @param connURL
     * @param operation
     * @return
     * @throws MalformedURLException
     * @throws IOException
     *
     */
    private HttpURLConnection getConnection(String connURL, String operation)
            throws MalformedURLException, IOException {
        HttpURLConnection connRequest;

        if (proxyHost.trim() != "" && proxyPort > 0) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            connRequest = (HttpURLConnection) new URL(connURL).openConnection(proxy);
        } else {
            connRequest = (HttpURLConnection) new URL(connURL).openConnection();
        }

        if (userName.trim() != "" && password.trim() != "") {
            String auth = userName + ":" + password;
            String authStr = Base64.getEncoder().encodeToString(auth.getBytes());
            // setting Authorization header
            connRequest.setRequestProperty("Authorization", "Basic " + authStr);
        }
        connRequest.setRequestMethod(operation.toUpperCase());
        return connRequest;
    }

    /**
     * adPayload is to add Payload to a request
     * @param connRequest
     * @param inputData
     * @param type
     * @param headers
     * @throws IOException
     *
     */
    private void addPayload(HttpURLConnection connRequest, String inputData, MessageTypes type,
                            HashMap<String, String> headers) throws IOException {
        addPayload(connRequest, inputData.getBytes("UTF-8"), type, headers);
    }

    /**
     * addPayload is used to add payload to a request
     * @param connRequest
     * @param Requestbytes
     * @param type
     * @param headers
     * @throws IOException
     *
     */
    private void addPayload(HttpURLConnection connRequest, byte[] Requestbytes, MessageTypes type,
                            HashMap<String, String> headers) throws IOException {
        if (Requestbytes.length > 0) {
            if (type.equals(MessageTypes.xml)) {
                connRequest.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            } else if (type.equals(MessageTypes.json)) {
                connRequest.setRequestProperty("Accept", "application/" + type.toString().toLowerCase());
                connRequest.setRequestProperty("Content-Type", "application/" + type.toString().toLowerCase() + "; charset=UTF-8");
            }
            else if (type.equals("application/xml")) {
                // connRequest.setRequestProperty("Content-Type",
                // "application/x-hessian");
                connRequest.setRequestProperty("Content-Type", "application/xml;charset=UTF-8");
            }

            if (null != headers && headers.size() > 0) {
                for (String hKey : headers.keySet()) {
                    connRequest.setRequestProperty(hKey, headers.get(hKey));
                }
            }
        }

        if (null != Requestbytes) {
            connRequest.setDoOutput(true);
            OutputStream out = connRequest.getOutputStream();
            out.write(Requestbytes);
            out.flush();
            out.close();
        }

    }

    /**
     * doHTTPPost is used to Post the request usign headers and data
     * @param connURL
     * @param inputData
     * @param needAsArray
     * @param headers
     * @return
     * @throws IOException
     *
     */
    public Object doHttpPost(String connURL, String inputData, boolean needAsArray, HashMap<String, String> headers)
            throws IOException {

        HttpURLConnection connRequest = getConnection(connURL, "POST");
        addPayload(connRequest, inputData, dataType, headers);
        return getResponse(connRequest, needAsArray, false);
    }

    /**
     * doHTTPPost is used to Post the request using headers and data
     * @param connURL
     * @param inputData
     * @param needAsArray
     * @return
     * @throws IOException
     *
     */
    public Object doHttpPost(String connURL, String inputData, boolean needAsArray) throws IOException {
        return doHttpPost(connURL, inputData, needAsArray, null);
    }

    /**
     * doHTTPPost is used to Post the request using headers and data
     * @param connURL
     * @param inputData
     * @param needAsArray
     * @param needAsStream
     * @param headers
     * @return
     * @throws IOException
     *
     */
    public Object doHttpPost(String connURL, byte[] inputData, boolean needAsArray, boolean needAsStream,
                             HashMap<String, String> headers) throws IOException {

        HttpURLConnection connRequest = getConnection(connURL, "POST");
        addPayload(connRequest, inputData, dataType, headers);
        return getResponse(connRequest, needAsArray, needAsStream);
    }

    /**
     * doHttpGet used to get the response using the request
     * @param connURL
     * @param needAsArray
     * @return
     * @throws IOException
     *
     */
    public Object doHttpGet(String connURL, boolean needAsArray) throws IOException {

        HttpURLConnection connRequest = getConnection(connURL, "GET");
        return getResponse(connRequest, needAsArray, false);
    }

    /**
     * getResponse us used for getting Object of response
     * @param connRequest
     * @param needAsArray
     * @param needAsStream
     * @return
     * @throws IOException
     */
    private Object getResponse(HttpURLConnection connRequest, boolean needAsArray, boolean needAsStream)
            throws IOException {
        Object retTable = null;
        connRequest.connect();
        System.out.println("Http Response Code is >>" + connRequest.getResponseCode());
        if (connRequest.getResponseCode() == 200 || connRequest.getResponseCode() == 201) {
            System.out.println("Http call is sucessfull!");
            InputStream inputStream = connRequest.getInputStream();
            if (needAsStream) {
                retTable = inputStream;
            } else {
                retTable = readResponse(inputStream, needAsArray);
            }
        } else if (connRequest.getResponseCode() == 500 || connRequest.getResponseCode() == 422) {
            System.out.println("|||Http Response Code " + connRequest.getResponseCode() + "||");
            retTable = readResponse(connRequest.getErrorStream(), needAsArray);
        }
        return retTable;
    }

    /**
     * Readresponse is used to read the response recieved
     * @param returnData
     * @param needAsArray
     * @return
     * @throws IOException
     */
    private Object readResponse(InputStream returnData, boolean needAsArray) throws IOException {
        ByteArrayOutputStream container = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int read;
        while ((read = returnData.read(buf, 0, 1024)) > 0) {
            container.write(buf, 0, read);
        }
        if (needAsArray) {
            return container.toByteArray();
        } else {
            return new String(container.toByteArray());
        }

    }

}
