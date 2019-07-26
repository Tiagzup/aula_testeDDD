package com.br.zup.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(min = 10, message = "A identificacao do banco precisa ter no mínimo dez dígitos")
	private String banco;
	@Min(value = 4, message = "A agência do banco precisa ter no mínimo quatro dígitos")
	private int agencia;
	@Min(value = 4, message = "A conte precisa ter no mínimo cinco dígitos")
	private int conta;
	@Min(value = 1, message = "O dígito da conta precisa ter um número")
	private int digito;
	
	private double saldoContaCorrente;
	private double saldoContaPoupanca;
	
	public Conta() {
		
	}

	public Conta(Integer id,
			@NotBlank @Size(min = 10, message = "A identificacao do banco precisa ter no mínimo dez dígitos") String banco,
			@Min(value = 4, message = "A agência do banco precisa ter no mínimo quatro dígitos") int agencia,
			@Min(value = 4, message = "A conte precisa ter no mínimo cinco dígitos") int conta,
			@Min(value = 1, message = "O dígito da conta precisa ter um número") int digito, double saldoContaCorrente,
			double saldoContaPoupanca) {
		
		this.id = id;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.digito = digito;
		this.saldoContaCorrente = saldoContaCorrente;
		this.saldoContaPoupanca = saldoContaPoupanca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public double getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(double saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

	public double getSaldoContaPoupanca() {
		return saldoContaPoupanca;
	}

	public void setSaldoContaPoupanca(double saldoContaPoupanca) {
		this.saldoContaPoupanca = saldoContaPoupanca;
	}
	
	
	public double sacarContaCorrente(double valor) {
//		this.saldoContaCorrente = this.saldoContaCorrente - valor;
		this.saldoContaCorrente -= valor;
		return valor;
	}
	public void depositarContaCorrente(double valor) {
		this.saldoContaCorrente += valor;
	}
	
	public double sacarContaPoupanca(double valor) {
		this.saldoContaPoupanca -= valor;
		return valor;
	}
	public void depositarContaPoupanca (double valor) {
		this.saldoContaPoupanca += valor;
		
	}
	public void transferirPoupancaParaCorrente(double valor) {
		this.saldoContaPoupanca -= valor;
		this.saldoContaCorrente += valor;
	}
	public void transferirCorrenteParaPoupanca(double valor) {
		this.saldoContaPoupanca += valor;
		this.saldoContaCorrente -= valor;
	}
}





















