package ClientQueueManage;

/**
 * @program: JavaTest
 * @description: ${联机客户端响应事件}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 16:34
 **/
public class ClientEvent {
    private Client client;
    public ClientEvent(Client client)
    {
        this.client = client;
    }

    public String getName()
    {
        return client.name;
    }

    public String getIp()
    {
        return client.ip;
    }
}
