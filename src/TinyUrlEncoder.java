import java.util.*;

public class TinyUrlEncoder {

    static final Random random = new Random();
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter URL");
        String url = sc.nextLine();
        String key = generateKey();
        map.put(key, url);
        System.out.println("Your encode url = https://salilURL/"+key);
        System.out.println("enter salilURL");
        String url1 = sc.nextLine();
        String k = url1.substring(url1.length()-10);
        System.out.println("Your orgingal URL = "+ map.get(k));
    }

    public static String generateKey(){
        int x = random.nextInt(0,7);
        String base16input = UUID.randomUUID().toString().replace("-", "");
        byte[] decoded = HexFormat.of().parseHex(base16input);
        String base64output = Base64.getEncoder().encodeToString(decoded);
        return base64output.replace("=", "").substring(x, 10 + x);
    }
}
