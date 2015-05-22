package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MenuActivity extends Activity{
	public static final String EXTRA_NOME_USUARIO = "helloworld.EXTRA_NOME_USUARIO";
	public static final String ACAO_EXIBIR_SAUDACAO = "helloworld.MOSTRAR_MENU";
	public static final String CATEGORIA_SAUDACAO = "helloworld.MENU_SAUDACAO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		TextView saudacaoTextView = (TextView) findViewById(R.id.menuTextView);
		
		
		//Mensagem de que estamos na calculadora do imc
		//posteriormente deve-se acessar uma pagina inicial antes, para depois irmos para calculadora
		saudacaoTextView.setText("Selecione a Funcionalidade\n");
		
	
	}
	
	
	  
    //funcao que aciona o intent de ir para a calculadora de IMX
    public void calculadoraIMC(View v) { 
    	Intent intent = new Intent(IMCActivity.ACAO_EXIBIR_SAUDACAO);
    
    	intent.addCategory(IMCActivity.CATEGORIA_SAUDACAO);
    	intent.putExtra(IMCActivity.EXTRA_NOME_USUARIO, "usuario");
    	startActivity(intent);	
    }
	
}
