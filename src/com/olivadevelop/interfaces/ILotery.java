package com.olivadevelop.interfaces;

import com.olivadevelop.lotery.Bet;
import com.olivadevelop.lotery.LoggerBet;

import java.util.List;

public interface ILotery {
    LoggerBet logger = new LoggerBet(ILotery.class);

    /**
     * Genera una apuesta conforme los criterios de probabilidad
     *
     * @param joker boolean para decidir si se crea el joker
     * @return Bet apuesta generada
     */
    Bet newBet(boolean joker);

    /**
     * Genera varias apuestas conforme los criterios de probabilidad
     *
     * @param numBets Numero de apuestas a generar
     * @param joker   boolean para decidir si se crea el joker
     * @return List apuestas generadas
     */
    List<Bet> newBet(int numBets, boolean joker);

    /**
     * Genera una apuesta aleatoria
     *
     * @param joker boolean para decidir si se crea el joker
     * @return Bet apuesta generada
     */
    Bet newRandomBet(boolean joker);

    /**
     * Genera varias apuestas
     *
     * @param numBets Numero de apuestas a generar
     * @param joker   boolean para decidir si se crea el joker
     * @return List apuestas generadas
     */
    List<Bet> newRandomBet(int numBets, boolean joker);

    /**
     * Genera el joker de una apuesta
     *
     * @return Integer número Joker de una apuesta
     */
    Integer newJoker();

    /**
     * Genera el reintegro de una apuesta
     *
     * @return Integer número generado
     */
    Integer newRefund();
}
