package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import negocio.GerenciadoraClientes;
import negocio.IdadeNaoPermitidaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GerenciadoraClientesTest {
    private GerenciadoraClientes gerClientes;
    private int idCliente1 = 1;
    private int idCliente2 = 2;

    @Before
    public void setUp(){
        // criando alguns clientes
        Cliente cliente01 = new Cliente(idCliente1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(idCliente2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);

        // inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        gerClientes = new GerenciadoraClientes(clientesDoBanco);
    }

    @After
    public void tearDown(){
        gerClientes.limpa();
    }

    @Test
    public void testPesquisaCliente() {
        Cliente cliente = gerClientes.pesquisaCliente(1);

        assertThat(cliente.getId(), is(idCliente1));
        assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
    }

    @Test
    public void removeCliente() {
        gerClientes.removeCliente(1);

        assertNull(gerClientes.pesquisaCliente(1));
    }

    @Test
    public void validaIdade()  {
        try {
            gerClientes.validaIdade(1);
            fail("não deu exceção que deveria");
        } catch (IdadeNaoPermitidaException e) {
            assertThat(e.getMessage(), is("A idade do cliente precisa estar entre 18 e 65 anos."));
        }
    }
}