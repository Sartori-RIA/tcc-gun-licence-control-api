package br.inf.teorema.erp.resource;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Sartori-Dev on 26/10/2017
 */
public abstract class AbstractTest {

    private String localhost = "http://localhost:8080/teoremaee/api/";
    private String requestProperty = "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)";

    public boolean testIndex(String context) throws IOException {
        URL url = new URL(localhost + context + "?start=0&qnt=100");
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", requestProperty);
        int responseCode = httpURLConnection.getResponseCode();
        return (responseCode == HttpURLConnection.HTTP_OK);
    }

    public boolean testShowById(String context, String id) throws IOException {
        URL url = new URL(localhost + context + "/" + id);
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", requestProperty);
        int responseCode = httpURLConnection.getResponseCode();
        return (responseCode == HttpURLConnection.HTTP_OK);
    }

    public boolean testSearchByProperty(String context, String property, String propertyValue) throws IOException {
        URL url = new URL(localhost + context + "/find/property/" + property + "/value/" + propertyValue);
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", requestProperty);
        int responseCode = httpURLConnection.getResponseCode();
        return (responseCode == HttpURLConnection.HTTP_OK);
    }

    public boolean testUpdate() {
        return true;
    }

    public boolean testDelete() {
        return true;
    }

    public boolean testSave(){
        return true;
    }
}
