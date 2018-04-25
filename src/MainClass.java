import com.olivadevelop.interfaces.ILotery;
import com.olivadevelop.lotery.Bet;
import com.olivadevelop.lotery.LoggerBet;
import com.olivadevelop.lotery.LoteryFactory;

import java.util.List;

public class MainClass {

    private static final LoggerBet logger = new LoggerBet(MainClass.class);

    public static void main(String args[]) {
        System.out.println("Bienvenido a Lotery, el programa secreto de apuestas de La Primitiva!");

        ILotery loteryFactory = LoteryFactory.getInstance();

        List<Bet> retorno = loteryFactory.newRandomBet(10);
        for (Bet bet : retorno) {
            logger.info(bet);
        }
    }
}
