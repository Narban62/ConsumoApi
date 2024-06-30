package ec.edu.uce.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ec.edu.uce.model.MarsPhoto;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class MarsPhotosFetcher {

    private static final String API_KEY = "3lEql594lioAuWsbDZ1dIMDmKJnBcsDAkGd0huUw";

    public static List<MarsPhoto> fetchPhotos(String cameraName, String date) {
        List<MarsPhoto> photos = new ArrayList<>();
        try {
            String apiUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + date + "&camera=" + cameraName + "&api_key=" + API_KEY;
            System.out.println("Request URL: " + apiUrl);

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);

                    Gson gson = new Gson();
                    JsonObject jsonResponse = gson.fromJson(result, JsonObject.class);
                    JsonArray jsonPhotos = jsonResponse.getAsJsonArray("photos");

                    for (int i = 0; i < jsonPhotos.size(); i++) {
                        MarsPhoto photo = gson.fromJson(jsonPhotos.get(i), MarsPhoto.class);
                        photos.add(photo);
                    }
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return photos;
    }
}