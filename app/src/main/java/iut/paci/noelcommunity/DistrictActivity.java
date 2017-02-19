package iut.paci.noelcommunity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class DistrictActivity extends AppCompatActivity {

    private static final ArrayList<District> districts = getDistricts();
    private static final ArrayList<District> districtsAffiches = new ArrayList<District>(districts);

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        ActionBar aBar = getSupportActionBar();
        aBar.setCustomView(R.layout.head_district);
        aBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                | ActionBar.DISPLAY_SHOW_HOME);

        GridView grid = (GridView) findViewById(R.id.grid);
        adapter = new MyAdapter(this, districtsAffiches);
        grid.setAdapter(adapter);

        EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new MyTextWatcher());
    }

    public void search(String str_searched) {

        districtsAffiches.clear();
        if(str_searched.isEmpty()) {
            districtsAffiches.addAll(districts);
        } else {
            str_searched = str_searched.toLowerCase();
            String a;
            for (District d : districts) {
                a = d.getNom();
                if (a.toLowerCase().contains(str_searched)) {
                    districtsAffiches.add(d);
                }
            }
        }

        adapter.clear();
        adapter.addAll(districtsAffiches);
        adapter.notifyDataSetChanged();
    }

    private static ArrayList<District> getDistricts() {
        return new ArrayList<District>(Arrays.asList(new District[] {
                new District(1, "Louvre", "desc...", -1, -1, R.drawable.img_district1),
                new District(2, "Bourse", "desc...", -1, -1, R.drawable.img_district2),
                new District(3, "Temple", "desc...", -1, -1, R.drawable.img_district3),
                new District(4, "Hôtel-de-Ville", "desc...", -1, -1, R.drawable.img_district4),
                new District(5, "Panthéon", "desc...", -1, -1, R.drawable.img_district5),
                new District(6, "Luxembourg", "desc...", -1, -1, R.drawable.img_district6),
                new District(7, "Palais-Bourbon", "desc...", -1, -1, R.drawable.img_district7),
                new District(8, "Élysée", "desc...", -1, -1, R.drawable.img_district8),
                new District(9, "Opéra", "desc...", -1, -1, R.drawable.img_district9),
                new District(10, "Entrepôt", "desc...", -1, -1, R.drawable.img_district10),
                new District(11, "Popincourt", "desc...", -1, -1, R.drawable.img_district11),
                new District(12, "Reuilly", "desc...", -1, -1, R.drawable.img_district12),
                new District(13, "Gobelins", "desc...", -1, -1, R.drawable.img_district13),
                new District(14, "Observatoire", "desc...", -1, -1, R.drawable.img_district14),
                new District(15, "Vaugirard", "desc...", -1, -1, R.drawable.img_district15),
                new District(16, "Passy", "desc...", -1, -1, R.drawable.img_district16),
                new District(17, "Batignolles-Monceau", "desc...", -1, -1, R.drawable.img_district17),
                new District(18, "Buttes-Montmartre", "desc...", -1, -1, R.drawable.img_district18),
                new District(19, "Buttes-Chaumont", "desc...", -1, -1, R.drawable.img_district19),
                new District(20, "Ménilmontant", "desc...", -1, -1, R.drawable.img_district20)
        }));
    }

    class MyTextWatcher implements TextWatcher {
        @Override
        public void afterTextChanged(Editable editable) {
            String str_searched = editable.toString();
            search(str_searched);
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
    }
}
