package com.olivadevelop.lotery;

import com.olivadevelop.interfaces.ILotery;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static com.olivadevelop.lotery.Utils.getRandomNumber;

public final class LoteryFactory implements ILotery {
    private static ILotery ourInstance = new LoteryFactory();

    public static ILotery getInstance() {
        return ourInstance;
    }

    private LoteryFactory() {
    }

    /**
     * see {@link ILotery#newBet(boolean)}
     */
    @Override
    public Bet newBet(boolean joker) {
//        logger.info("Apuesta generada...");
        return null;
    }

    /**
     * see {@link ILotery#newBet(int, boolean)}
     */
    @Override
    public List<Bet> newBet(int numBets, boolean joker) {
        logger.info("Generando apuestas...");
        List<Bet> lines = new ArrayList<>(numBets);
        for (int x = 0; x < numBets; x++) {
            lines.add(newBet(joker));
        }
        return lines;
    }

    /**
     * see {@link ILotery#newRandomBet(boolean)}
     */
    @Override
    public Bet newRandomBet(boolean joker) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            OptionalInt num = getRandomNumber();
            if (num.isPresent() && !numbers.contains(num.getAsInt())) {
                numbers.add(num.getAsInt());
            }
        }
        Bet bet = new Bet(numbers);

        // Generamos el complementario
        OptionalInt complement;
        do {
            complement = getRandomNumber();
            if (complement.isPresent() && !numbers.contains(complement.getAsInt())) {
                bet.setComplementario(complement.getAsInt());
            }
        } while (complement.isPresent() && numbers.contains(complement.getAsInt()));

        bet.setReintegro(newRefund());

        if (joker) {
            bet.setJoker(newJoker());
        }
//        logger.info("Apuesta generada...");
        return bet;
    }

    /**
     * see {@link ILotery#newRandomBet(int, boolean)}
     */
    @Override
    public List<Bet> newRandomBet(int numBets, boolean joker) {
        logger.info("Generando apuestas...");
        List<Bet> lines = new ArrayList<>(numBets);
        for (int x = 0; x < numBets; x++) {
            lines.add(newRandomBet(joker));
        }
        return lines;
    }

    /**
     * see {@link ILotery#newJoker()}
     */
    @Override
    public Integer newJoker() {
        List<Integer> joker = new ArrayList<>(7);
        while (joker.size() < 7) {
            OptionalInt num = getRandomNumber(0, 9);
            if (num.isPresent()) {
                joker.add(num.getAsInt());
            }
        }
        return Integer.valueOf(StringUtils.join(joker, ""));
    }

    /**
     * see {@link ILotery#newRefund()}
     */
    @Override
    public Integer newRefund() {
        Integer retorno = -1;
        OptionalInt reinte = getRandomNumber(9);
        if (reinte.isPresent()) {
            retorno = reinte.getAsInt();
        }
        return retorno;
    }
}
