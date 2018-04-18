package controller;

import com.google.gson.Gson;
import dto.MessageDto;
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

@Stateless
public class MessageController {

    private String mcUrl = RootProvider.getRoot() + "/pm/api/messages";

    public MessageDto getMessageById(Integer id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("/" + id);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + httpResponse.getStatusLine().getStatusCode());
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        return new Gson().fromJson(response, MessageDto.class);
    }

    public void addMessage(MessageDto messageDto) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(mcUrl + "/create");
        httpPost.setEntity(new StringEntity(new Gson().toJson(messageDto)));
        httpPost.setHeader("Content-type", "application/json");
        httpClient.execute(httpPost);
    }

    public void updateMessage(MessageDto messageDto) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(mcUrl + "/" + messageDto.getPostId());
        httpPut.setEntity(new StringEntity(new Gson().toJson(messageDto)));
        httpPut.setHeader("Content-type", "application/json");
        httpClient.execute(httpPut);
    }
}
