package com.olivadevelop.lotery;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bet {

    private List<String> apuesta;
    private Integer complementario;
    private Integer reintegro;

    Bet(List<Integer> apuesta) {
        setApuesta(apuesta);
    }

    public List<String> getApuesta() {
        if (this.apuesta == null) {
            this.apuesta = new ArrayList<>();
        }
        return apuesta;
    }

    void setApuesta(List<Integer> apuesta) {
        Collections.sort(apuesta);
        for (int num : apuesta) {
            this.getApuesta().add(Utils.formatNumber(num));
        }
    }

    public Integer getComplementario() {
        return complementario;
    }

    void setComplementario(Integer complementario) {
        this.complementario = complementario;
    }

    public Integer getReintegro() {
        return reintegro;
    }

    void setReintegro(Integer reintegro) {
        this.reintegro = reintegro;
    }

    @Override
    public String toString() {
        JSONObject retorno = new JSONObject();
        JSONObject bet = new JSONObject();
        bet.put("apuesta", StringUtils.join(apuesta, " "));
        bet.put("complementario", Utils.formatNumber(complementario));
        bet.put("reintegro", reintegro);
        retorno.put(this.getClass().getSimpleName(), bet);
        return retorno.toString();
    }
}
