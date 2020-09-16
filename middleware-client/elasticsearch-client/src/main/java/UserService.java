import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class UserService {

    private static TransportClient client;

    private static volatile UserService singleton;

    private UserService() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static UserService getInstance() {
        if (singleton == null) {
            synchronized (UserService.class) {
                if (singleton == null) {
                    singleton = new UserService();
                }
            }
        }
        return singleton;
    }


    public void addUser(User user) {
        byte[] bytes = JSON.toJSONBytes(user);
        XContentType xContentType = XContentType.JSON;
        IndexResponse indexResponse = client.prepareIndex("test_index", "doc", user.getUserId()).setSource(bytes, xContentType).get();
        System.out.println(indexResponse);
    }

    public void removeUser(String userId) {
        DeleteResponse deleteResponse = client.prepareDelete("test_index", "doc", userId).get();
        System.out.println(deleteResponse);
    }

    public void updateUser(User user) throws ExecutionException, InterruptedException {
        byte[] bytes = JSON.toJSONBytes(user);
        XContentType xContentType = XContentType.JSON;
        UpdateRequest updateRequest = new UpdateRequest("test_index", "doc", user.getUserId())
                .doc(bytes, xContentType);
        UpdateResponse updateResponse = client.update(updateRequest).get();
        System.out.println(updateResponse);
    }

    public User getUser(String userId) {
        GetResponse getResponse = client.prepareGet("test_index", "doc", userId).get();
        byte[] source = getResponse.getSourceAsBytes();
        return JSON.parseObject(source, User.class);
    }
}
