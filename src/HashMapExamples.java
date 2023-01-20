import java.util.HashMap;
import java.util.Map;

public class HashMapExamples {

    public static void main(String[] args) {

        // Create a HashMap object
        Map <Integer,String> map = new HashMap<Integer,String>();

        // Add keys and values (Name, Age)
        map.put(0, "Mango");
        map.put(1, "Apple");
        map.put(2, "Banana");

        System.out.println("Inserting HashMap..");

        /*for(int i=0;i<map.size();i++){
            System.out.println(map.get(i));
            System.out.println(map.keySet());*/

     //   Need advance for loop here
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey()+ " " + m.getValue());
        }
    }
}
