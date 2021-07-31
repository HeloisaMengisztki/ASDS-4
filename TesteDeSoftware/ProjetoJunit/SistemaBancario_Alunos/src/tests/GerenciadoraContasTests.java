package tests;

import negocio.Cliente;
import negocio.ContaCorrente;
import negocio.GerenciadoraClientes;
import negocio.GerenciadoraContas;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GerenciadoraContasTests {
    private int idCliente1 = 1;
    private int idCliente2 = 2;

    @Test
    public void transfereValor() {
        ContaCorrente conta1 = new ContaCorrente(1, 2000, true);
        ContaCorrente conta2 = new ContaCorrente(2, 500, true);

        List<ContaCorrente> contasCorrenteDoBanco = new ArrayList<>();
        contasCorrenteDoBanco.add(conta1);
        contasCorrenteDoBanco.add(conta2);

        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contasCorrenteDoBanco);

        gerenciadoraContas.transfereValor(conta1.getId(), 500, conta2.getId());

        assertThat(conta1.getSaldo(), is(1500d));
        assertThat(conta2.getSaldo(), is(1000d));
    }
}
