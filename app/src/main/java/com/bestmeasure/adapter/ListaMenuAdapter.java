package com.bestmeasure.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bestmeasure.activity.HomeActivity;
import com.bestmeasure.activity.R;
import com.bestmeasure.domain.entity.Menu;
import com.bestmeasure.sharedkernel.helper.Util;

import java.util.List;

/**
 * Classe responsável por carregar os itens da lista de menu.
 * @author diogo.barreiros
 *
 */
public class ListaMenuAdapter extends BaseAdapter {

    private final List<Menu> menus;
    private final Activity activity;

    public ListaMenuAdapter(List<Menu> menus, Activity activity) {
        this.menus = menus;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int posicao) {
        return menus.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return Util.getIndex(menus.get(posicao).getIdMenu());
    }

    @Override
    public View getView(final int posicao, View convertView, ViewGroup parent) {
        int indexMesa = -1;
        View view = activity.getLayoutInflater().inflate(R.layout.item_listamenu, null);

        Menu menu = menus.get(posicao);

        ViewGroup fundo = (ViewGroup) view.findViewById(R.id.fundo);

        if (posicao % 2 == 0) {
            fundo.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
        } else {
            fundo.setBackgroundColor(activity.getResources().getColor(R.color.linha_impar));
        }

        TextView nomemenu = (TextView) view.findViewById(R.id.nomemenu);
        nomemenu.setText(menu.getNome());

        ImageView imgMenu = (ImageView) view.findViewById(R.id.imgitemlistamenu);

        switch (menu.getImagem()){
            case "ESTETICA":
                imgMenu.setImageResource(R.drawable.logo);
            case "IDFIT":
                imgMenu.setImageResource(R.drawable.logo);
            default:
                imgMenu.setImageResource(R.drawable.logo);
        }

        fundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity homeActivity = (HomeActivity) activity;
                homeActivity.selecionaMenu(menus.get(posicao));
            }
        });

        return view;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
