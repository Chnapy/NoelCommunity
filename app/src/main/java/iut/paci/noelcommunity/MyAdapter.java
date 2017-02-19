package iut.paci.noelcommunity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haddad1 on 10/02/2017.
 */
public class MyAdapter extends ArrayAdapter<District> {

    private static final int viewRessourceId = R.layout.item_district;

    private final List<District> districts;

    public MyAdapter(DistrictActivity activity, List<District> districts) {
        super(activity, viewRessourceId, new ArrayList(districts));
        this.districts = districts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if(convertView == null) {
            LayoutInflater inflater = ((DistrictActivity) getContext()).getLayoutInflater();
            layout = inflater.inflate(viewRessourceId, parent, false);
        }

        ImageView img = (ImageView) layout.findViewById(R.id.img);

        LinearLayout lin_lay = (LinearLayout) layout.findViewById(R.id.lin_lay);
        TextView tv1 = (TextView) lin_lay.findViewById(R.id.nbr);
        TextView tv2 = (TextView) lin_lay.findViewById(R.id.nom_d);

        final District d = districts.get(position);

        img.setImageResource(d.getIdImageRessource());
        tv1.setText(d.getId() + "");
        tv2.setText(d.getNom());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_district);
                dialog.setTitle(d.getNom());

                Button d_but = (Button) dialog.findViewById(R.id.d_but);

                TextView d_content = (TextView) dialog.findViewById(R.id.d_content);
                d_content.setText(d.toDialog());

                d_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return layout;
    }
}
