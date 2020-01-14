package com.company.Lambda.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class StreamTestMain {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(list);
        List<String> cites = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cites);

        Set<String> citesSet = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(citesSet);

        List<String> people = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .filter(String::isEmpty)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(people);

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        Optional<Trader> trader = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader1 -> "Milan".equals(trader1.getCity()))
                .findAny();
        System.out.println(trader);

        boolean status = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        int sumCambridge = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sumCambridge);

        Optional<Transaction> transaction = transactions.stream()
                .reduce((transaction1, transaction2) -> transaction1.getValue() >= transaction2.getValue() ? transaction1 : transaction2);
        System.out.println(transaction);

        transaction = transactions.stream()
                .reduce((transaction1, transaction2) -> transaction1.getValue() <= transaction2.getValue() ? transaction1 : transaction2);
        System.out.println(transaction);


        OptionalInt optionalInt = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println(optionalInt);
        System.out.println(optionalInt.orElse(0));

    }
}
