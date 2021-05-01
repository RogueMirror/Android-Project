package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Optional;

public class MainActivityNotes extends AppCompatActivity {
    ArrayList<String> titleList = new ArrayList<String>();

    public ArrayList<String> loadNote() {
        SQLiteDatabase myDB = this.openOrCreateDatabase("HelloWT", 0, null);
        ArrayList<String> titles = new ArrayList<>();
        Cursor notesCursor = myDB.rawQuery("SELECT * FROM Notes", null);
        notesCursor.moveToFirst();

        while(notesCursor.isAfterLast() == false) {
            int Note_title_idx = notesCursor.getColumnIndex("Note_title");
            String Note_title = notesCursor.getString(Note_title_idx);
            titles.add(Note_title);
            notesCursor.moveToNext();
        }
        return titles;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);

        ListView listView = findViewById(R.id.listNotes);
        titleList = loadNote();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivityNotes.this,android.R.layout.simple_list_item_1, titleList);
        listView.setAdapter(arrayAdapter);

        /*try {
            SQLiteDatabase myDB= this.openOrCreateDatabase("HelloWT", 0, null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS User (wtemail TEXT PRIMARY KEY, password TEXT);");
            myDB.execSQL("CREATE TABLE IF NOT EXISTS Notes (Note_IDINTEGER PRIMARY KEY AUTOINCREMENT, Note_titleTEXT, Note_contentTEXT);");

            myDB.execSQL("INSERT INTO User (wtemail, password) VALUES ('alice@wtamu.edu','password')");

            myDB.execSQL("INSERT INTO Notes (Note_title, Note_content) VALUES ('Note Title 1', 'Content of Note1')");
            myDB.execSQL("INSERT INTO Notes (Note_title, Note_content) VALUES ('Note Title 2', 'Content of Note2')");
            myDB.execSQL("INSERT INTO Notes (Note_title, Note_content) VALUES ('Note Title 3', 'Content of Note3')");
            myDB.execSQL("INSERT INTO Notes (Note_title, Note_content) VALUES ('Note Title 4', 'Content of Note4')");
            myDB.execSQL("INSERT INTO Notes (Note_title, Note_content) VALUES ('Note Title 5', 'Content of Note5')");

            myDB.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}