package ClientQueueManage;

/**
 * @program: JavaTest
 * @description: ${客户端监听}
 * @author: Mr.ZeroCamel
 * @create: 2020-05-02 16:38
 **/
public interface ClientListener {
    /**
     * @param event
     */
    void clientAdded(ClientEvent event);

    /**
     * @param event
     */
    void clientRemoved(ClientEvent event);
}
