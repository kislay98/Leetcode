package org.kislay.AccountMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountMerge {
    public class UnionFind<T> {
        private Map<T, T> parent = new HashMap<>();;
        private Map<T, Integer> rank = new HashMap<>();;
        public UnionFind() {}
        public void addElement(T element) {
            if (!parent.containsKey(element)) {
                parent.put(element, element);
                rank.put(element, 0);
            }
        }
        public T find(T element) {
            if (parent.get(element).equals(element)) {
                return element;
            }
            return find(parent.get(element));
        }
        public void union(T x, T y) {
            T rootX = find(x);
            T rootY = find(y);
            if (rootY != rootX) {
                Integer yRank = rank.get(rootY);
                Integer xRank = rank.get(rootX);
                if (xRank > yRank) {
                    parent.put(rootY, rootX);
                } else if (xRank < yRank) {
                    parent.put(rootX, rootY);
                } else {
                    parent.put(rootX, rootY);
                    rank.put(rootY, rank.get(rootY) + 1);
                }
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToAccIdx = new HashMap<>();
        UnionFind<Integer> uf = new UnionFind<>();
        for (int j = 0, accountsSize = accounts.size(); j < accountsSize; j++) {
            List<String> account = accounts.get(j);
            uf.addElement(j);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (emailToAccIdx.containsKey(email)) {
                    uf.union(emailToAccIdx.get(email), j);
                }
                emailToAccIdx.put(email, j);
            }
        }
        Map<Integer, Set<String>> uniqueAccountsToEmails = new HashMap<>();
        for(Map.Entry<String, Integer> emailAccIndex: emailToAccIdx.entrySet()) {
            String email = emailAccIndex.getKey();
            Integer accountIndex = emailAccIndex.getValue();
            Integer uniqueAccountIndex = uf.find(accountIndex);
            Set<String> emails;
            if (uniqueAccountsToEmails.containsKey(uniqueAccountIndex)) {
                emails = uniqueAccountsToEmails.get(uniqueAccountIndex);
            } else {
                emails = new HashSet<>();
            }
            emails.add(email);
            uniqueAccountsToEmails.put(uniqueAccountIndex, emails);
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(Map.Entry<Integer, Set<String>> uniqueAccountToEmails: uniqueAccountsToEmails.entrySet()) {
            List<String> emails = new ArrayList<>(uniqueAccountToEmails.getValue());
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(uniqueAccountToEmails.getKey()).get(0));
            mergedAccount.addAll(emails);
            mergedAccounts.add(mergedAccount);
        }
        return mergedAccounts;
    }

    public static void main(String[] args) {
        AccountMerge accountMerge = new AccountMerge();
        List<String> a1 = List.of("David","David4@m.co","David2@m.co","David4@m.co");
        List<String> a2 = List.of("John","John7@m.co","John5@m.co","John3@m.co");
        List<String> a3 = List.of("Fern","Fern6@m.co","Fern4@m.co","Fern5@m.co");
        List<String> a4 = List.of("Celine","Celine0@m.co","Celine7@m.co","Celine7@m.co");
        List<String> a5 = List.of("Gabe","Gabe8@m.co","Gabe8@m.co","Gabe1@m.co");
        List<String> a6 = List.of("Ethan","Ethan1@m.co","Ethan6@m.co","Ethan6@m.co");
        List<String> a7 = List.of("Celine","Celine4@m.co","Celine8@m.co","Celine6@m.co");
        List<String> a8 = List.of("Celine","Celine0@m.co","Celine0@m.co","Celine4@m.co");
        accountMerge.accountsMerge(List.of(a1,a2,a3,a4,a5,a6,a7,a8));
    }
}
