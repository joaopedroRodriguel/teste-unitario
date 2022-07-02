package com.gugawag.testes.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTeste {

    Conta c1;

    @BeforeEach
    private void configuraConta() {
        c1 = new Conta();
        c1.setNumero("10");
    }


    @Test
    public void deveAlterarNumeroContaNumeroValido() {
        // Config
        String numeroContaValido = "10";

        // executa
        c1.setNumero(numeroContaValido);

        // teste
        Assertions.assertEquals(numeroContaValido, c1.getNumero());
    }


    @Test
    public void deveComecarContaComSaldoZero() {
        // config
        Conta contaNova = new Conta();

        // teste
        Assertions.assertEquals(0.0, contaNova.getSaldo());
    }

//    @Test
//    public void naoDeveriaMudarSaldoSeValorNegativo(){
//        // config
//        Conta contaSaldoPositivo = new Conta();
//        Double saldoPositivo = 100.0;
//        contaSaldoPositivo.setSaldo(saldoPositivo);
//
//        // executar
//
//        Double valorNegativo = -10.0;
//        contaSaldoPositivo.setSaldo(valorNegativo);
//
//        // teste
//        Assertions.assertEquals(saldoPositivo, contaSaldoPositivo.getSaldo());
//    }
//
//    @Test
//    public void naoDeveriaTerSaldoNegativo(){
//        // config
//        Conta contaSaldoPositivo = new Conta();
//        Double saldoPositivo = 100.0;
//        contaSaldoPositivo.setSaldo(saldoPositivo);
//
//        // executar
//
//        Double valorNegativo = -10.0;
//        contaSaldoPositivo.setSaldo(valorNegativo);
//
//        // teste
//        Assertions.assertTrue(contaSaldoPositivo.getSaldo()>=0);
//    }

    @Test
    public void naoDeveDebitarValorMaiorSaldo() {
        // config
        c1.creditar(100.0);

        // executar

        Assertions.assertThrows(SaldoNegativoInvalidoException.class,
                () -> c1.debitar(200.0));
    }

    @Test
    public void deveDebitarValorIgualSaldo() {
        // config
        c1.creditar(100.0);

        // executar
        try {
            c1.debitar(100.0);
        } catch (SaldoNegativoInvalidoException e) {
            Assertions.fail();
        }

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    @Test
    public void naoDeveCreditarValorNegativo() {

        // executar
        c1.creditar(-100.0);

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    //Meus testes

    @Test
    public void naoDeveCreditarValor0() {
        // config
        c1.creditar(0.0);

        //teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    @Test
    public void NaoDeveCreditarValorNull() {
        //config
        c1.creditar(null);

        //teste
        Assertions.assertEquals(0.0, c1.getSaldo());

        //Ao fazer esse teste, verifiquei que por saldo ser do tipo Double, o próprio tipo double já lança
        //uma exceção probindo que passe como parâmetro um valor diferente do tipo númerico,achei interresante.
    }

    @Test
    public void NaoDeveDebitarValorNull() throws SaldoNegativoInvalidoException {
        //config
        c1.debitar(null);

        //teste
        Assertions.assertEquals(0.0, c1.getSaldo());

    }

    @Test
    public void NaoDeveDebitarValor0() throws SaldoNegativoInvalidoException {
        //config
        c1.debitar(0.0);

        //teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }


}
