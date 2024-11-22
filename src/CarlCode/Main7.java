package CarlCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Double> map = new HashMap<Character, Double>() {
            {
                put('A', 4.0);
                put('B', 3.0);
                put('C', 2.0);
                put('D', 1.0);
                put('F', 0.0);
            }
        };

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strarr = str.split("\\s+");
            double sum = 0;
            boolean unknown = false; // 标志是否存在未知字符

            for (String s : strarr) {
                if (map.get(s.charAt(0)) == null) {
                    System.out.println("Unknown");
                    unknown = true;
                    break; // 跳出循环
                }
                sum += map.get(s.charAt(0));
            }

            if (!unknown) { // 如果没有未知字符，输出结果
                System.out.println(String.format("%.2f",sum/ strarr.length));
            }
        }
        sc.close();
    }
}
