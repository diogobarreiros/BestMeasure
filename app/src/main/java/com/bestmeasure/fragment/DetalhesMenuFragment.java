package com.bestmeasure.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.bestmeasure.activity.R;
import com.bestmeasure.domain.entity.Menu;

/**
 * Classe responsável por carregar detalhes do menu.
 * @author diogo.barreiros
 *
 */
public class DetalhesMenuFragment extends Fragment {

    private TextView selecao;
    private TextView descricaomenu;
    private ImageView imgMenu;
    private ImageButton imgBtnIniciar;
    private TableRow tbrDescricao;
    private TableRow tbrSelecao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_detalhemenu, container, false);

        Menu menu = null;

        if (getArguments() != null) {
            menu = (Menu) getArguments().getSerializable("menu");
        }

        buscaComponentes(layout);
        populaCamposComDados(menu);

        return layout;
    }

    /**
     * Preenche os campos da tela de detalhes com os valores do item clicado.
     * @param menu - Menu selecionado pelo usuario
     */
    public void populaCamposComDados(Menu menu) {
        if (menu != null) {
            this.tbrSelecao.setVisibility(View.VISIBLE);
            this.tbrDescricao.setVisibility(View.VISIBLE);
            this.imgBtnIniciar.setVisibility(View.VISIBLE);

            this.imgBtnIniciar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    /* TODO - tela para iniciar item selecionado
                    NumberPickerDialog dialog = new NumberPickerDialog(AdicionarContaProdutoTask.getContext(), -1, 1, true);
                    dialog.setOnNumberSetListener(AdicionarContaProdutoTask.getActivity());
                    dialog.show();*/
                }
            });

            this.selecao.setText(menu.getNome());
            this.descricaomenu.setText(menu.getDescricao());

            if(menu.getImagem().equals("ESTETICA"))
                imgMenu.setImageResource(R.drawable.icon_estetic);
            else if(menu.getImagem().equals("IDFIT"))
                imgMenu.setImageResource(R.drawable.icon_idfit);
        }
    }

    /**
     * Aponta os atributos aos componentes da tela criados no arquivo XML.
     * @param layout - layout da tela de detalhes
     */
    private void buscaComponentes(View layout) {
        this.selecao = (TextView) layout.findViewById(R.id.selecao);
        this.descricaomenu = (TextView) layout.findViewById(R.id.descricaomenu);
        this.imgMenu = (ImageView) layout.findViewById(R.id.imgMenu);
        this.imgBtnIniciar = (ImageButton) layout.findViewById(R.id.imgBtnIniciar);
        this.tbrSelecao = (TableRow) layout.findViewById(R.id.tbrSelecao);
        this.tbrDescricao = (TableRow) layout.findViewById(R.id.tbrDescricao);
    }
}
