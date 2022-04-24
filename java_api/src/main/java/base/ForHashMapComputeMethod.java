package base;

import java.util.HashMap;

/** compute() 方法对 hashMap 中指定 key 的值进行重新计算
 *  compute() 方法的语法为：
 *  hashmap.compute(K key, BiFunction remappingFunction)
 */
public class ForHashMapComputeMethod {
    public static void main(String[] args) {
        //创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋子打了10%折扣后的值
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);


    }
}
