package com.br.zup.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.zup.Models.Conta;

@RunWith(SpringRunner.class)
public class ContaTeste {

	private Conta conta;

	@Before
	public void Preparar() {
		conta = new Conta();
		conta.setId(null);
		conta.setBanco("1000 - Banco do povo");
		conta.setAgencia(1111);
		conta.setConta(55555);
		conta.setDigito(1);

		conta.setSaldoContaCorrente(100D);
		conta.setSaldoContaPoupanca(100D);
	}

	@Test
	public void testarDepositarContaCorrente() {
		conta.depositarContaCorrente(100D);
		assertEquals(200D, conta.getSaldoContaCorrente(), 0D);
	}

	@Test
	public void testarDepositarContaPoupanca() {
		conta.depositarContaPoupanca(100D);
		assertEquals(200D, conta.getSaldoContaPoupanca(), 0D);
	}

	@Test
	public void testarSacarContaCorrente() {
		conta.sacarContaCorrente(100D);
		assertEquals(0D, conta.getSaldoContaCorrente(), 100D);
	}

	@Test
	public void testarSacarContaPoupanca() {
		conta.sacarContaPoupanca(100D);
		assertEquals(0D, conta.getSaldoContaPoupanca(), 100D);

	}

	@Test
	public void testarTransferirContaCorrente() {
		conta.transferirPoupancaParaCorrente(100D);
		assertEquals(200D, conta.getSaldoContaCorrente(), 0D);
	}

	public void testarTransferirContaPoupanca() {
		conta.transferirCorrenteParaPoupanca(0D);
		assertEquals(100D, conta.getSaldoContaPoupanca(), 0);
	}

}
