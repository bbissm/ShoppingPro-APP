package com.example.martin.shoppingpro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
<<<<<<< HEAD
=======
import android.opengl.Visibility;
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
<<<<<<< HEAD
import android.widget.Toast;
=======
import android.widget.TextView;
import android.widget.Toast;

>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {
<<<<<<< HEAD
    ListView artikel;
    Button clearAllCheckBoxes;
    //listeID für den ID-Bezug aus der MainActivity
    String listeId;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyUserChoice" ;
    ArrayList<String> selectedItems = new ArrayList<String>();
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
=======

    //Test 
    ArrayList<String> selectedItems = new ArrayList<String>();
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView artikel = null;
    Button clearAll;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyUserChoice" ;
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        //Holt den Intent von MainActivity
        Intent intent = getIntent();

        listeId = intent.getStringExtra("name");
        String name = intent.getStringExtra("name");
        setTitle(name);
        shoppingList = getArrayVal(getApplicationContext());

        artikel = (ListView) findViewById(R.id.ShoppingList);
        //shoppingList wird mit den vorherigen Werten wieder ersichtlich
        //getChoice = (Button)findViewById(R.id.getchoice);
        clearAllCheckBoxes = (Button)findViewById(R.id.clearall);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, shoppingList);
=======
        artikel = (ListView) findViewById(R.id.ShoppingList);

        //shoppingList wird mit den vorherigen Werten wieder ersichtlich
        shoppingList = getArrayVal(getApplicationContext());

        //Clear Button setzt den Zustand der CheckBox in false
        clearAll = (Button)findViewById(R.id.clearall);


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, shoppingList);
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

        ArrayAdapter<String> adapterItem = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, shoppingList);
        artikel.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        artikel.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
<<<<<<< HEAD

=======
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
        if(sharedpreferences.contains(MyPREFERENCES)){
            LoadSelections();
        }

<<<<<<< HEAD
        //Bei Klick auf Auswahl speichern
        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selected = "";
                int cntChoice = artikel.getCount();

                SparseBooleanArray sparseBooleanArray = artikel.getCheckedItemPositions();
                for(int i = 0; i < cntChoice; i++){
                    if(sparseBooleanArray.get(i)) {
                        selected += artikel.getItemAtPosition(i).toString() + "\n";
                        System.out.println("Checking list while adding:" + artikel.getItemAtPosition(i).toString());
                        SaveSelections();

                    }
                }
                Toast.makeText(Main2Activity.this, selected, Toast.LENGTH_LONG).show();

            }
        };
        artikel.setOnItemClickListener(mListClickedHandler);

        //Bei Klick auf Wert in ListView
        AdapterView.OnItemClickListener mListClickedHandler2 = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View b = findViewById(R.id.del);

                SparseBooleanArray checkedItemPositions = artikel.getCheckedItemPositions();
                String selected = "";
                int itemCount = artikel.getCount();
                for (int i = 0; i < itemCount; i++) {
=======




        //----------------------------------Ergänzen 1.1----------------------------------

        //Die Artikel die erfasst wurden brauchen eine Beziehung zu dem jeweiligen ausgewählten Shop


        AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View b = findViewById(R.id.del);


                SparseBooleanArray checkedItemPositions = artikel.getCheckedItemPositions();
                String selected = "";
                int itemCount = artikel.getCount();


                for (int i = itemCount; i >= 0; i--) {
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

                    if (checkedItemPositions.get(i)) {
                        selected += artikel.getItemAtPosition(i).toString() + "\n";
                        System.out.println("Checking list while adding:" + artikel.getItemAtPosition(i).toString());
                        SaveSelections();
                        b.setVisibility(View.VISIBLE);
                        return;
                    }
                }
                b.setVisibility(View.INVISIBLE);

            }

        };
<<<<<<< HEAD
        artikel.setOnItemClickListener(mListClickedHandler2);

        clearAllCheckBoxes.setOnClickListener(new View.OnClickListener() {
=======

        artikel.setOnItemClickListener(mListClickedHandler);

        clearAll.setOnClickListener(new View.OnClickListener() {
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
            @Override
            public void onClick(View view) {

                ClearSelections();
            }
        });

<<<<<<< HEAD
        FloatingActionButton del = (FloatingActionButton) findViewById(R.id.del);
        del.setImageResource(R.drawable.ic_delete_white_48dp);

        //Bei Klick auf delete Button unten rechts.
        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                View b = findViewById(R.id.del);

                //Dialog zum Hinzufügen erzeugen
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);

                //Display the Title
                builder.setTitle("Are you sure, you want to delete?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        View b = findViewById(R.id.del);
                        Snackbar.make(view, "The Item('s) is deleted", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        remove();
                        b.setVisibility(View.INVISIBLE);


                    }
                });
                //Shows button "Cancel"
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View b = findViewById(R.id.del);

                        b.setVisibility(View.VISIBLE);

                        dialog.cancel();
                    }
                });
                builder.show();

=======


        FloatingActionButton del = (FloatingActionButton) findViewById(R.id.del);
        del.setImageResource(R.drawable.ic_delete_white_48dp);

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View b = findViewById(R.id.del);
                remove();
                Snackbar.make(view, "The Item('s) is deleted", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                b.setVisibility(View.INVISIBLE);

                //ClearSelections();
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
            }
        });

        artikel.setAdapter(adapter);
    };

<<<<<<< HEAD
    //Remove Funktion, die weiter unten verwendet wird.
=======
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
    public void remove() {

        SparseBooleanArray checkedItemPositions = artikel.getCheckedItemPositions();
        int itemCount = artikel.getCount();

        for (int i = itemCount - 1; i >= 0; i--) {
            if (checkedItemPositions.get(i)) {
<<<<<<< HEAD

=======
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
                adapter.remove((String) shoppingList.get(i));
            }
        }
        checkedItemPositions.clear();
        adapter.notifyDataSetChanged();

        //Werte werden mithilfe storeArrayVal in getApplicationContext gespeichert
        storeArrayVal(shoppingList, getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

<<<<<<< HEAD
        int id = item.getItemId();

        if(id == R.id.action_sort){

            //Sortiert aus der Klasse Collections die shoppingList automatisch
            Collections.sort(shoppingList);

            //Wird angepasst
            artikel.setAdapter(adapter);

            return true;
        }
        //If click on add
        if(id == R.id.action_add){
=======
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //If click on add
        if(id == R.id.action_add_shop){
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

            //Dialog zum Hinzufügen erzeugen
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //Display the Title
<<<<<<< HEAD
            builder.setTitle("Add Article");
=======
            builder.setTitle("Add Shop");
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

            final EditText input = new EditText(this);

            builder.setView(input);

            //Shows button "OK"
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //add Methode wird von shoppingList aufgerufen
                    shoppingList.add(preferredCase(input.getText().toString()));

                    //Werte werden mithilfe storeArrayVal in getApplicationContext gespeichert
                    storeArrayVal(shoppingList, getApplicationContext());

                    //listView updaten
                    artikel.setAdapter(adapter);

                }
            });
<<<<<<< HEAD

=======
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
            //Shows button "Cancel"
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });

            builder.show();

            return true;

        }

        if(id == R.id.action_clear){

            //Dialog zum Loeschen erzeugen
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Clear Entire List");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    shoppingList.clear();

                    //Werte werden mithilfe storeArrayVal in getApplicationContext gespeichert
                    storeArrayVal(shoppingList, getApplicationContext());

                    artikel.setAdapter(adapter);
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });

            builder.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Zeichen Ausgabe (Erster grosser Buchstabe)
    public static String preferredCase(String original)
    {

        if (original.isEmpty())
            return original;

        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();

    }

    //Jedes mal wenn jemand etwas erfasst wird das im Store gespeichert
<<<<<<< HEAD
    public void storeArrayVal(ArrayList<String> inArrayList, Context context)
=======
    public static void storeArrayVal(ArrayList<String> inArrayList, Context context)
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
    {

        //HashSet ist Subklasse von Set
        Set<String> WhatToWrite = new HashSet<String>(inArrayList);

        SharedPreferences WordSearchPutPrefs = context.getSharedPreferences("dbArrayValues", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = WordSearchPutPrefs.edit();

<<<<<<< HEAD
        prefEditor.putStringSet("myArray"+listeId, WhatToWrite);
        prefEditor.commit();
    }

    public ArrayList getArrayVal( Context dan)
=======
        prefEditor.putStringSet("myArray", WhatToWrite);
        prefEditor.commit();
    }

    public static ArrayList getArrayVal( Context dan)
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
    {

        SharedPreferences WordSearchGetPrefs = dan.getSharedPreferences("dbArrayValues",Activity.MODE_PRIVATE);

        Set<String> tempSet = new HashSet<String>();
<<<<<<< HEAD
        tempSet = WordSearchGetPrefs.getStringSet("myArray" +listeId, tempSet);
=======
        tempSet = WordSearchGetPrefs.getStringSet("myArray", tempSet);
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10

        return new ArrayList<String>(tempSet);
    }

    private void SaveSelections() {
// save the selections in the shared preference in private mode for the user

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
<<<<<<< HEAD
        prefEditor.putString("myArray", savedItems);
=======
        prefEditor.putString(MyPREFERENCES.toString(), savedItems);
>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
        prefEditor.commit();
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.artikel.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.artikel.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.artikel.getItemAtPosition(i);
                } else {
                    savedItems += this.artikel.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }

<<<<<<< HEAD
=======
    //----------------------------------Ergänzen 2.0----------------------------------//

    //Der Checkzustand wird erfolgreich gespeichert und wenn man die App neustartet wird auch die ausgewählte Checkbox
    //mithilfe Toast ausgegeben -> "Current Item: " + currentItem. Nur wird die Checkbox leider nicht
    //angeklickt angezeigt. Die soll aber angeklickt angezeigt werden.

>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
    private void LoadSelections() {
        // if the selections were previously saved load them

        if (sharedpreferences.contains(MyPREFERENCES.toString())) {

            String savedItems = sharedpreferences.getString(MyPREFERENCES.toString(), "");
            selectedItems.addAll(Arrays.asList(savedItems.split(",")));


            int count = this.artikel.getAdapter().getCount();

            for (int i = 0; i < count; i++) {
                String currentItem = (String) artikel.getAdapter()
                        .getItem(i);
                if (selectedItems.contains(currentItem)) {
<<<<<<< HEAD

                    artikel.setItemChecked(i, true);
                } else {
                    artikel.setItemChecked(i, false);
                }
=======
                    artikel.setItemChecked(i, true);
                    Toast.makeText(getApplicationContext(),
                            "Current Item: " + currentItem,
                            Toast.LENGTH_LONG).show();
                } else {
                    artikel.setItemChecked(i, false);


                }

>>>>>>> f05d3ea2d951769a893f7df343eda9a433c96a10
            }
        }
    }

    //Clear all checkboxes at once
    private void ClearSelections() {
        // user has clicked clear button so uncheck all the items
        int count = this.artikel.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            this.artikel.setItemChecked(i, false);
        }
        // also clear the saved selections
        SaveSelections();
    }

}
