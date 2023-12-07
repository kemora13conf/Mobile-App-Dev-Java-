package com.example.javaapp.ListViewsAndAdapters;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.example.javaapp.R;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView maListViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_views_and_adapters);
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap <String, String>>();

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("titre", "Word");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Power Point");
        map.put("description", "Logiciel de présentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier électronique");
        map.put("img", String.valueOf(R.drawable.outlook));
        Log.d("image", String.valueOf(R.drawable.outlook));
        listItem.add(map);

        String from[] = {"img", "titre", "description"};
        int to[] = {R.id.img, R.id.titre, R.id.description};
        SimpleAdapter aa = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.affichageitem, from, to );

        maListViewPerso.setAdapter(aa);

        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // on récupère la HashMap contenant les infos du item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                // on crée une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

                adb.setTitle("Sélection Item");
                // on insère un message à notre boite de dialogue, ici le titre de l'item cliqué
                adb.setMessage("Votre choix : " + map.get("titre"));

                adb.setPositiveButton("Ok", null);

                adb.show();
            }
        });

    }
    public void changeText(View v){
        Button btn = ( Button ) findViewById(v.getId());
        String text = (String) btn.getText();
        Integer count = new Integer(text.substring(8));
        count = count + 1;
        if(count == 13){
            btn.setEnabled(false);
        }
        btn.setText("Clicked "+count);
        Log.d("success", "Button clicked successfully!");
    }
}