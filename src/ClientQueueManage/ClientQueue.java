package ClientQueueManage;

import java.util.ArrayList;

/**
 * @program: JavaTest
 * @description: ${客户端队列}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 17:06
 **/
public class ClientQueue {

    private ArrayList clients = new ArrayList();
    private ArrayList listeners = new ArrayList();

    public void addClientsListeners(ClientListener listener)
    {
        listeners.add(listener);
    }

    public void add(Client client)
    {
        clients.add(client);
        ClientEvent clientEvent = new ClientEvent(client);
        for (int i=0;i<listeners.size();i++)
        {
            ClientListener listener = (ClientListener) listeners.get(i);
            listener.clientAdded(clientEvent);
        }
    }

    public void remove(Client client)
    {
        clients.remove(client);
        ClientEvent event = new ClientEvent(client);
        for (int i=0;i<listeners.size();i++)
        {
            ClientListener listener =(ClientListener) listeners.get(i);
            listener.clientRemoved((event));
        }
    }
}
