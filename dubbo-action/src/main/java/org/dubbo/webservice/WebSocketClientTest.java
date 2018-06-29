package org.dubbo.webservice;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@ClientEndpoint
public class WebSocketClientTest {

    private Session session;

    protected boolean start(String unionId) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://192.168.0.135:9999/websocket/14/"+unionId;
        System.out.println("Connecting to " + uri);
        try {
            session = container.connectToServer(WebSocketClientTest.class, URI.create(uri));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WebSocketClientTest webSocketClientTest =new WebSocketClientTest();
        for(int i = 0;i<140000;i++){
            try{
                webSocketClientTest.start(i+"");
            }catch (Exception e){
                e.printStackTrace();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

}
