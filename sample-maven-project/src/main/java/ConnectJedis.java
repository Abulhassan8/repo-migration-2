import redis.clients.jedis.Jedis;

public class ConnectJedis {
    public static void main(String[] args){
        String redisHost = "localhost";
        int portNumber = 6379;

        Jedis jedis = new Jedis(redisHost, portNumber);

        jedis.set("name", "Tom");
        String valueRetrieved = jedis.get("name");

        System.out.println("Value retrieved : " + valueRetrieved);
    }
}
