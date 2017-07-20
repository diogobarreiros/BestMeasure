package com.bestmeasure.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bestmeasure.activity.R;
import com.bestmeasure.domain.entity.Menu;
import com.bestmeasure.fragment.DetalhesMenuFragment;
import com.bestmeasure.fragment.ListaMenuFragment;

/**
 * Classe responsável por carregar a página home.
 * @author diogo.barreiros
 *
 */
public class HomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListaMenuFragment listaMenuFrag = new ListaMenuFragment();
        listaMenuFrag.setHomeActivity(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.menulista, listaMenuFrag, ListaMenuFragment.class.getCanonicalName())
                .replace(R.id.menudetalhes, new DetalhesMenuFragment(), DetalhesMenuFragment.class.getCanonicalName());

        transaction.commit();
    }

    /**
     * Metodo chamado quando o usuario clica em um item do menu e ele preenche a tela de detalhes do menu.
     * @param menu
     */
    public void selecionaMenu(Menu menu) {
        DetalhesMenuFragment detalhesMenu = (DetalhesMenuFragment) getSupportFragmentManager().findFragmentByTag(DetalhesMenuFragment.class.getCanonicalName());
        detalhesMenu.populaCamposComDados(menu);
    }
}
