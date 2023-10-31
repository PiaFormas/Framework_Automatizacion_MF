package test.util;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

    public class Servicio {

    public static HttpClient.Builder BUILDER = HttpClient.newBuilder();
    public static HashMap<String, String> HEADERS = new HashMap<>();

    public static void addHeader(String key, String value) {
        HEADERS.put(key, value);
    }

    public static String doRequestAndGetResponse(String uri, String method, HttpRequest.BodyPublisher body) throws IOException, InterruptedException {
        HttpResponse<String> response = doRequest(uri, method, body);
        return response.body();
    }

    public static HttpResponse<String> doRequest(String uri, String method, HttpRequest.BodyPublisher body) throws IOException, InterruptedException {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method(method, body);

        if (!HEADERS.isEmpty()) {
            for (String header : HEADERS.keySet()) {
                requestBuilder.header(header, HEADERS.get(header));
            }
        }

        HttpRequest request = requestBuilder.build();

        return BUILDER.build()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }
}