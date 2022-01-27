package modenJavaInAction.char5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Practice {
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

        // 1
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(tr2011);
        System.out.println();

        // 2
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cities);
        System.out.println();

        // 3
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);
        System.out.println();
/*
        List<String> traders = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .sorted(comparing(Trader::getName))
                .collect(toList());
*/

        // 4
        String tradersName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a , b) -> a + " " + b);
        System.out.println(tradersName);
        System.out.println();

        // 5
        boolean isMilan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(isMilan);
        System.out.println();

        // 6
        List<Integer> CambridgeTrader = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());
        System.out.println(CambridgeTrader);
        System.out.println();

        // 7
        int max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(max);

        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);
        System.out.println();

        // 8
        int min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(min);

        Optional<Integer> smallestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(smallestValue);

        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
    }
}
