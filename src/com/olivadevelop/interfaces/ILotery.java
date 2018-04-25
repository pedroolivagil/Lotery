package com.olivadevelop.interfaces;

import com.olivadevelop.lotery.Bet;
import com.olivadevelop.lotery.LoggerBet;

import java.util.List;

public interface ILotery {
    LoggerBet logger = new LoggerBet(ILotery.class);

    /**
     * Genera una apuesta conforme los criterios de probabilidad
     *
     * @return Bet apuesta generada
     */
    Bet newBet();

    /**
     * Genera varias apuestas conforme los criterios de probabilidad
     *
     * @param numBets Numero de apuestas a generar
     * @return List apuestas generadas
     */
    List<Bet> newBet(int numBets);

    /**
     * Genera una apuesta aleatoria
     *
     * @return Bet apuesta generada
     */
    Bet newRandomBet();

    /**
     * Genera varias apuestas
     *
     * @param numBets Numero de apuestas a generar
     * @return List apuestas generadas
     */
    List<Bet> newRandomBet(int numBets);
}
