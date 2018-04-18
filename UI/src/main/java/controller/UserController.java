package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.PostDto;
import dto.UserDto;
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
public class UserController {

    private String ucUrl = RootProvider.getRoot() + "/pm/api/users";

    public UserDto getUserById(Integer id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(ucUrl + "/user/" + id);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, UserDto.class);
    }

    public UserDto getUserByUsername(String username) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(ucUrl + "/" + username);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, UserDto.class);
    }

    public List<PostDto> getAllPostsByUserId(Integer userId) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(ucUrl + "/" + userId + "/posts");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, new TypeToken<ArrayList<PostDto>>() {
        }.getType());
    }

    public boolean addUser(UserDto userDto) throws IOException {
        HttpPost httpPost = new HttpPost(ucUrl + "/create");
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpPost.setEntity(new StringEntity(new Gson().toJson(userDto)));
        httpPost.setHeader("Content-type", "application/json");
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() != 201) {
            return false;
        }
        return true;
    }

    public void updateUser(UserDto userDto) throws IOException {
        HttpPut httpPut = new HttpPut(ucUrl + "/" + userDto.getUserId());
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpPut.setEntity(new StringEntity(new Gson().toJson(userDto)));
        httpPut.setHeader("Content-type", "application/json");
        httpClient.execute(httpPut);
    }

    public UserDto login(UserDto userDto) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(ucUrl + "/login");
        httpPost.setEntity(new StringEntity(new Gson().toJson(userDto)));
        httpPost.setHeader("Content-type", "application/json");
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, UserDto.class);
    }
}
