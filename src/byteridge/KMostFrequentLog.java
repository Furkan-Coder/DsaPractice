package byteridge;

import java.util.*;
//1.
//You are building a monitoring system for Triotech’s production environment.
//
//        Every minute, thousands of logs are generated. Each log contains a log level:
//
//        "ERROR", "INFO", "WARNING", "DEBUG"
//
//
//You must return the top K most frequent log levels.
//
//If two log levels have the same frequency, return them in lexicographical (alphabetical) order.
//
//        📝 Method Signature
//public List<String> topKFrequent(String[] logs, int k)
//
//📥 Example
//
//Input:
//
//logs = ["ERROR","INFO","ERROR","DEBUG","INFO","ERROR"]
//k = 2
//
//
//Output:
//
//        ["ERROR","INFO"]
//
//        📌 Constraints
//
//1 ≤ logs.length ≤ 100,000
//
//        1 ≤ k ≤ number of unique log levels
//
//Logs contain only uppercase letters
//
//Aim better than O(n log n)
//
//Memory usage should be reasonable
public class KMostFrequentLog {
    public static void main(String[] args) {
        String logs[]={"ERROR","INFO","ERROR","DEBUG","INFO","ERROR","INFO"};
        int k=2;
        List<String>res= topKFrequent(logs,k);
        System.out.println(res);
    }
    public  static List<String>topKFrequent(String[] logs,int k){
        Map<String, Integer> freqMap = new HashMap<>();
        for (String log : logs) {
            freqMap.put(log, freqMap.getOrDefault(log, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
                // higher frequency first
            }
            return a.getKey().compareTo(b.getKey());// alphabetical order
        });
        System.out.println(list);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }
}
