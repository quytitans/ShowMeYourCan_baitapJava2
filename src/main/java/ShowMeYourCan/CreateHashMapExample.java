package ShowMeYourCan;

import java.util.HashMap;
import java.util.Map;

public class CreateHashMapExample {
    public static void main(String[] args) {
        // Tạo một HashMap
        Map<String, Integer> numberMapping = new HashMap<>();

        // Thêm giá Key-Value vào HashMap
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);

        // Thêm cặp Key-Value chỉ khi key không tồn tại trong HashMap
        // hoặc được ánh xạ tới null
        numberMapping.putIfAbsent("Four", 4);

        System.out.println(numberMapping);
    }
}