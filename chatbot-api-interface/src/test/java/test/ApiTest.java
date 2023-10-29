package test;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.apache.http.client.methods.HttpGet;
import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        //用来发送Http请求和接收响应
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884185151128/topics?scope=all&count=20");

        //Http请求中的附加信息
        get.addHeader("cookie","zsxq_access_token=3AA27790-3C39-D94E-1ACC-D93DC08F4BF4_FB49C5E872E8D1AE; zsxqsessionid=2e4a4892af4296221c117821297a9a7f; abtest_env=product");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }
        else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/188458811425452/comments");

        //Http请求中的附加信息
        post.addHeader("cookie","zsxq_access_token=3AA27790-3C39-D94E-1ACC-D93DC08F4BF4_FB49C5E872E8D1AE; zsxqsessionid=2e4a4892af4296221c117821297a9a7f; abtest_env=product");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"123\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }
        else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }



}
