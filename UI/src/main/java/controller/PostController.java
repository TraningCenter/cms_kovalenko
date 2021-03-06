package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.MessageDto;
import dto.PostDto;
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
public class PostController {

    private String pcUrl = RootProvider.getRoot() + "/pm/api/posts";

    public List<PostDto> getAllPosts() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(pcUrl);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, new TypeToken<ArrayList<PostDto>>() {
        }.getType());
    }

    public PostDto getPostById(Integer id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(pcUrl + "/" + id);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, PostDto.class);
    }

    public PostDto addPost(PostDto postDto) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(pcUrl + "/create");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(new Gson().toJson(postDto)));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() != 201) {
            return null;
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, PostDto.class);
    }

    public void updatePost(PostDto postDto) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(pcUrl + "/" + postDto.getPostId());
        httpPut.setHeader("Content-type", "application/json");
        httpPut.setEntity(new StringEntity(new Gson().toJson(postDto)));
        httpClient.execute(httpPut);
    }

    public List<MessageDto> getPostMessages(Integer postId) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(pcUrl + "/" + postId + "/messages");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, new TypeToken<ArrayList<MessageDto>>() {
        }.getType());
    }
}
