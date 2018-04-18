package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.ContentDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import util.RootProvider;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ContentController {

    private String pcUrl = RootProvider.getRoot() + "/cm/api/contents";

    public List<ContentDto> getAllByPostId(Integer postId) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(pcUrl + "/post/" + postId);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, new TypeToken<ArrayList<ContentDto>>() {
        }.getType());
    }

    public ContentDto getContentById(Integer id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("/" + id);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, ContentDto.class);
    }

    public void addContent(ContentDto contentDto) throws IOException {
        HttpPost httpPost = new HttpPost(pcUrl + "/create");
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(new Gson().toJson(contentDto)));
        httpClient.execute(httpPost);
    }

    public void updateContent(ContentDto contentDto) throws IOException {
        HttpPut httpPut = new HttpPut(pcUrl + "/" + contentDto.getPostId());
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpPut.setHeader("Content-type", "application/json");
        httpPut.setEntity(new StringEntity(new Gson().toJson(contentDto)));
        httpClient.execute(httpPut);
    }
}
