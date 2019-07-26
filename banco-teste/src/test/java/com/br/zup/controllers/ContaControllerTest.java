package com.br.zup.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.zup.Models.Conta;
import com.br.zup.services.ContaService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContaController.class)
public class ContaControllerTest  {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContaService contaService;
	@Test
	public void testarPegarContas () throws Exception {
		Conta conta = new Conta();
		
		conta = new Conta();
		conta.setId(null);
		conta.setBanco("1000 - Banco do povo");
		conta.setAgencia(1111);
		conta.setConta(55555);
		conta.setDigito(1);

		conta.setSaldoContaCorrente(100D);
		conta.setSaldoContaPoupanca(100D);
		
		List<Conta> contas = Arrays.asList(conta);
		
		given(contaService.findAll()).willReturn(contas);
		given(contaService.count()).willReturn(1L);
		
		this.mockMvc.perform(get("/api/conta"))
		.andExpect(status().isOk());
	}
	
}


















