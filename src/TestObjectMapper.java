import java.util.*;

public class TestObjectMapper {
    public static void main(String[] args) {
        try {
            Map<String, Object> userData = new HashMap<>();
            userData.put("id", "12354");
            userData.put("name", "Jayadeep");
            userData.put("address.city", "Bhimavaram");
            userData.put("address.zip", "534201");
            userData.put("address.state", "Andhra Pradesh");

            User user = ObjectMapper.mapToObject(userData, User.class);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
