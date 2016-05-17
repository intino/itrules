package sherpa;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class UniRestClient {
    protected String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


    protected String _string(HttpResponse<String> response) throws UnirestException {
        return check(response) ? response.getBody() : null;
    }

    protected Double _double(HttpResponse<Double> response) throws UnirestException {
        return check(response) ? response.getBody() : null;
    }

    private boolean check(HttpResponse<?> response) throws UnirestException {
        if (response.getStatus() != 200) throw new UnirestException(response.getStatus() + ":" + response.getStatusText());
        return true;
    }
}