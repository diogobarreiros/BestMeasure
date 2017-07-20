package com.bestmeasure.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bestmeasure.activity.HomeActivity;
import com.bestmeasure.activity.R;
import com.bestmeasure.adapter.ListaMenuAdapter;
import com.bestmeasure.domain.entity.Menu;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsável por carregar a lista de menu.
 * @author diogo.barreiros
 *
 */
public class ListaMenuFragment extends Fragment {

    private ListView listViewMenu;
    public HomeActivity homeActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_listamenu, container, false);

        this.listViewMenu = (ListView) layout.findViewById(R.id.listamenu);
        listViewMenu.setChoiceMode(2);

        ListaMenuAdapter adapter = new ListaMenuAdapter(getListaMenu(), homeActivity);
        listViewMenu.setAdapter(adapter);

        return layout;
    }

    public HomeActivity getHomeActivity() {
        return homeActivity;
    }

    public void setHomeActivity(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    public List<Menu> getListaMenu(){
        List<Menu> listamenu = new ArrayList<Menu>();

        Menu menuEst = new Menu();
        menuEst.setIdMenu("1");
        menuEst.setNome("Estética");
        menuEst.setDescricao("Aqui você utiliza o aplicativo como espelho para clientes de alta dioptria.");
        menuEst.setImagem("ESTETICA");
        listamenu.add(menuEst);

        Menu menuId = new Menu();
        menuId.setIdMenu("2");
        menuId.setNome("Id. FIT");
        menuId.setDescricao("Aqui você utiliza o aplicativo para medir DNP e altura de pupila.");
        menuId.setImagem("IDFIT");
        listamenu.add(menuId);

        return listamenu;
    }
}
