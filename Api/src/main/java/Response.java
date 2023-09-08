import java.util.Map;

public class Response {
    private int statusCode;
    private String body;
    private Map<String, String> headers;


    public Response(int statusCode, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }


    public int getStatusCode() {
        return statusCode;
    }


    public String getBody() {
        return body;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    // Метод для получения значения конкретного заголовка по имени
    public String getHeader(String headerName) {
        return headers.get(headerName);
    }
}
