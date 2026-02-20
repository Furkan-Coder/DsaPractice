package byteridge;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        String[][] accounts = {
                {"John", "john@gmail.com", "john@yahoo.com"},
                {"John", "john@yahoo.com", "john123@gmail.com"},
                {"Mary", "mary@gmail.com"}
        };
        List<List<String>> merged = mergeAccounts(accounts);

        for (List<String> acc : merged) {
            System.out.println(acc);
        }
    }

    public static List<List<String>> mergeAccounts(String[][] accounts) {
        int n = accounts.length;
        boolean[] merged = new boolean[n];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged[i]) continue;

            Set<String> emails = new HashSet<>();
            String name = accounts[i][0];

            for (int e = 1; e < accounts[i].length; e++) {
                emails.add(accounts[i][e]);
            }

            for (int j = i + 1; j < n; j++) {
                if (merged[j]) continue;

                boolean common = false;
                for (int e = 1; e < accounts[j].length; e++) {
                    if (emails.contains(accounts[j][e])) {
                        common = true;
                        break;
                    }
                }
                if (common) {
                    for (int e = 1; e < accounts[j].length; e++) {
                        emails.add(accounts[j][e]);
                    }
                    merged[j] = true;
                }
            }
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);

            List<String> sortedEmails = new ArrayList<>(emails);
            Collections.sort(sortedEmails);
            mergedAccount.addAll(sortedEmails);

            result.add(mergedAccount);
        }
        return result;
    }
}
