package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class IMCActivity extends Activity{
	public static final String EXTRA_NOME_USUARIO = "helloworld.EXTRA_NOME_USUARIO";
	public static final String ACAO_EXIBIR_SAUDACAO = "helloworld.ACAO_EXIBIR_SAUDACAO";
	public static final String CATEGORIA_SAUDACAO = "helloworld.CATEGORIA_SAUDACAO";
	private EditText AlturaEditText;
	private EditText PesoEditText;
	private TextView IMCTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.saudacao);
		
		TextView saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);
		
		//relaciona os campos da calculadora de imc
		this.AlturaEditText = (EditText) findViewById(R.id.AlturaEditText);
		this.PesoEditText = (EditText) findViewById(R.id.PesoEditText);
		this.IMCTextView = (TextView)findViewById(R.id.IMCTextView);
		
		//qndo implementarmos nome e senha para login pegamos aqui
		Intent intent = getIntent();
		if (intent.hasExtra(EXTRA_NOME_USUARIO)) {
			//String saudacao = getResources().getString(R.string.saudacao);
			//saudacaoTextView.setText(saudacao + " " + intent.getStringExtra(EXTRA_NOME_USUARIO));
		} else {
			//saudacaoTextView.setText("O nome do usuário " + " não foi informado");
		}
		
		
		//Mensagem de que estamos na calculadora do imc
		//posteriormente deve-se acessar uma pagina inicial antes, para depois irmos para calculadora
		saudacaoTextView.setText("Bem vindo a calculadora de IMC\n");
		
	
	}
	
	public void calcularIMC(View v) { 
		Editable altura = this.AlturaEditText.getText();
		Editable peso = this.PesoEditText.getText();
		float pesoIMC, alturaIMC, IMC;
		String msg;
		
		pesoIMC =  Float.parseFloat(peso.toString());
		alturaIMC =  Float.parseFloat(altura.toString());
		IMC = (float) (pesoIMC / Math.pow(alturaIMC,2));
		
		//retorna o IMC para display
		msg = "Seu IMC: " + Float.toString(IMC) + ".";
		
		//categoria que user se encaixa de acordo com o imc
		if(IMC < 17)
			msg += " Muito abaixo do peso.";
		else if(IMC >= 17 && IMC < 18.5)
			msg += " Abaixo do peso.";
		else if(IMC >= 18.5 && IMC < 25)
			msg += " Peso normal.";
		else if(IMC >= 25 && IMC < 30)
			msg += " Acima do Peso.";
		else if(IMC >= 30 && IMC < 35)
			msg += " Obesidade 1.";
		else if(IMC >= 35 && IMC < 40)
			msg += " Obesidade severa.";
		else if(IMC >= 40)
			msg += " Obesidade morbida.";
		
		
		//output da mensagem
		this.IMCTextView.setText(msg);
	}
	
	
	
	
}
