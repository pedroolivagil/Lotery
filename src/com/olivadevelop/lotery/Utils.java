package com.olivadevelop.lotery;

abstract class Utils {

    public static String formatNumber(int number) {
        StringBuilder retorno = new StringBuilder();
        retorno.append(number);
        if (retorno.length() < 2) {
            do {
                retorno.insert(0, "0");
            } while (retorno.length() < 2);
        }
        return retorno.toString();
    }
}
