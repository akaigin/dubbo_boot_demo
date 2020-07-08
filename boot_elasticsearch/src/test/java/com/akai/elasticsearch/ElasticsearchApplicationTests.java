package com.akai.elasticsearch;

import com.akai.elasticsearch.entities.User;
import com.akai.elasticsearch.repositories.UserRepository;
import com.akai.elasticsearch.services.UserService;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.akai.elasticsearch.utils.ToolUtils;

import java.net.InetAddress;

@SpringBootTest
class ElasticsearchApplicationTests {

    @Autowired
    private UserService userSevice;

    private TransportClient client;

    @Before
    public void getClient() throws Exception{
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert(){
        User user=new User();
        user.setId(ToolUtils.intToLong(1));
        user.setUserName("盲僧");
        user.setName("李青");
        user.setSex("男");
        userSevice.save(user);

        user=new User();
        user.setId(ToolUtils.intToLong(2));
        user.setUserName("探险家");
        user.setName("伊泽瑞尔");
        user.setSex("男");
        userSevice.save(user);
    }

    @Test
    void testDelete(){
        User user=new User();
        user.setId(ToolUtils.intToLong(1));
        userSevice.delete(user);
    }
}
