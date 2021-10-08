package bba.web;

public class Response {
    private final int responseCode;
    private final String statusLine;

    public Response(int responseCode, String statusLine) {
        this.responseCode = responseCode;
        this.statusLine = statusLine;
    }

    @Override
    public String toString() {
        return responseCode + " " + statusLine;
    }
}
