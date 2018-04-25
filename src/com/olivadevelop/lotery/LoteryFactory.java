package com.olivadevelop.lotery;

import com.olivadevelop.interfaces.ILotery;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

public final class LoteryFactory implements ILotery {
    private static ILotery ourInstance = new LoteryFactory();

    public static ILotery getInstance() {
        return ourInstance;
    }

    private LoteryFactory() {
    }

    @Override
    public Bet newBet() {
        logger.info("Generando apuesta...");
        return null;
    }

    @Override
    public List<Bet> newBet(int numBets) {
        List<Bet> lines = new ArrayList<>(numBets);
        for (int x = 0; x < numBets; x++) {
            lines.add(newBet());
        }
        return lines;
    }

    @Override
    public Bet newRandomBet() {
        logger.info("Generando apuesta...");
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            OptionalInt num = random.ints(1, 1, 50).findFirst();
            if (num.isPresent() && !numbers.contains(num.getAsInt())) {
                numbers.add(num.getAsInt());
            }
        }
        List<String> line = new ArrayList<>();
        for (int num : numbers) {
            line.add(Utils.formatNumber(num));
        }
        Bet bet = new Bet(numbers);

        // Generamos el complementario
        OptionalInt complement;
        do {
            complement = random.ints(1, 1, 50).findFirst();
            if (complement.isPresent() && !numbers.contains(complement.getAsInt())) {
                bet.setComplementario(complement.getAsInt());
            }
        } while (complement.isPresent() && numbers.contains(complement.getAsInt()));

        // Generamos el reintegro
        OptionalInt reinte = random.ints(1, 1, 10).findFirst();
        if (reinte.isPresent()) {
            bet.setReintegro(reinte.getAsInt());
        }
        return bet;
    }

    @Override
    public List<Bet> newRandomBet(int numBets) {
        List<Bet> lines = new ArrayList<>(numBets);
        for (int x = 0; x < numBets; x++) {
            lines.add(newRandomBet());
        }
        return lines;
    }
}
