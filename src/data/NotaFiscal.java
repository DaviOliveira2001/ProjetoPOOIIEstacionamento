/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author odavi
 */
public class NotaFiscal {
    private String nNota;
    private double horaEntrada;
    private double horaSaida;
    private double valor;
    private String data;
    
    public NotaFiscal(){
        
    }

    public String getnNota() {
        return nNota;
    }

    public void setnNota(String nNota) {
        this.nNota = nNota;
    }

    public double gethoraEntrada() {
        return horaEntrada;
    }

    public void sethoraEntrada(double dataHoraEntrada) {
        this.horaEntrada = dataHoraEntrada;
    }

    public double gethoraSaida() {
        return horaSaida;
    }

    public void sethoraSaida(double dataHoraSaida) {
        this.horaSaida = dataHoraSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
