package com.olivadevelop.lotery;

import java.util.OptionalInt;
import java.util.Random;

abstract class Utils {

    static String formatNumber(int number) {
        return formatNumber(number, 2);
    }

    static String formatNumber(int number, int limit) {
        StringBuilder retorno = new StringBuilder();
        retorno.append(number);
        if (retorno.length() < limit) {
            do {
                retorno.insert(0, "0");
            } while (retorno.length() < limit);
        }
        return retorno.toString();
    }


    /**
     * @param minNum número mínimo para generar el aleatorio
     * @param maxNum número más alto para generar el aleatorio, incluido el mismo número
     * @return OptionalInt objeto int
     */
    static OptionalInt getRandomNumber(Integer minNum, Integer maxNum) {
        Random random = new Random();
        return random.ints(1, minNum, maxNum + 1).findFirst();
    }

    static OptionalInt getRandomNumber(Integer maxNum) {
        return getRandomNumber(1, maxNum);
    }

    static OptionalInt getRandomNumber() {
        return getRandomNumber(49);
    }
}
