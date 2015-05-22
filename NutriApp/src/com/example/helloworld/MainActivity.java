package com.example.helloworld;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //chama o adaptador do slider de imagens
        MyPagerAdapter adapter = new MyPagerAdapter();
        ViewPager myPager = (ViewPager) findViewById(R.id.pager);
        
        //seta o adaptador de imagem para que a cada swipe
        //acesse a funcao e mude a imagem
        myPager.setAdapter(adapter);
        
        myPager.setCurrentItem(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    //funcao que aciona o intent de ir para a prox pagina
    public void logar(View v) { 
    	Intent intent = new Intent(MenuActivity.ACAO_EXIBIR_SAUDACAO);
    
    	intent.addCategory(MenuActivity.CATEGORIA_SAUDACAO);
    	intent.putExtra(MenuActivity.EXTRA_NOME_USUARIO, "usuario");
    	startActivity(intent);	
    }
    
    
    //classe para adaptar imagens no slider
    //Abaixo o link de como fazer um swiper de imagem
    //http://stackoverflow.com/questions/11640327/swiping-images-not-layouts-with-viewpager
    class MyPagerAdapter extends PagerAdapter {

    	//retorna o numero de imagens que estao no sliderde imagens
        public int getCount() {
            return 3;
        }

        //instancia a imagem no viewer
        public Object instantiateItem(View collection, int position) {
        	//salva o contexto
            ImageView img = new ImageView(collection.getContext());
            
            //carrega a primeira imagem
            ((ViewPager) collection).addView(img, 0);

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.drawable.img1;
                    break;
                case 1:
                    resId = R.drawable.img2;
                    break;
                case 2:
                    resId = R.drawable.img3;
                    break;
            }

            //carrega o caso selecionado da imagem
            img.setImageResource(resId);
            
            //retorna a imagem atual
            return img;
        }
        
        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);

        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);

        }

    
    }
    
}
