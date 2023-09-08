import java.util.Map;

public class Response {
    private int statusCode;
    private String body;
    private Map<String, String> headers;

    // Конструктор для создания объекта Response
    public Response(int statusCode, String body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    // Метод для получения статусного кода ответа
    public int getStatusCode() {
        return statusCode;
    }

    // Метод для получения тела ответа
    public String getBody() {
        return body;
    }

    // Метод для получения заголовков ответа
    public Map<String, String> getHeaders() {
        return headers;
    }

    // Метод для получения значения конкретного заголовка по имени
    public String getHeader(String headerName) {
        return headers.get(headerName);
    }
}
