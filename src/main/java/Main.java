import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testGetIpJsonTest();
        testGetHttpBin();
        testGetHttpBin2();

        testPostHttBin();
    }

    private static void testGetIpJsonTest() {
        System.out.println("\nTesting ip.jsontest.com");
        Gson gson = new Gson();

        try {
            HttpResponse<String> response = Unirest.get("http://ip.jsontest.com/").asString();
            System.out.println(response);
            System.out.println(gson.fromJson(response.getBody(), Ip.class));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private static void testGetHttpBin() {
        System.out.println("\nTesting httpbin.org/ip");
        Gson gson = new Gson();

        try {
            HttpResponse<String> response = Unirest.get("http://httpbin.org/ip").asString();
            System.out.println(response);
            System.out.println(gson.fromJson(response.getBody(), Origin.class));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    private static void testGetHttpBin2() {
        System.out.println("\nTesting httpbin.org/get");
        Gson gson = new Gson();

        try {
            HttpResponse<String> response = Unirest.get("http://httpbin.org/get?x=1").asString();
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private static void testPostHttBin() {

        System.out.println("\nTesting httpbin.org/post");

        Map<String, Object> params = new HashMap<>();
        params.put("email", "first.last@example.com");
        User u = new User();
        u.setName("pippo");
        u.setUser("U001");

        try {
            HttpResponse<String> response = Unirest.post("http://httpbin.org/post").fields(params).asString();
            System.out.println(response);
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
}
