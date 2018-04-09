package com.example.adrian.music;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final int sound1 = R.raw.piano_a;
    public static final int sound2 = R.raw.piano_b;
    public static final int sound3 = R.raw.piano_c;
    public static final int sound4 = R.raw.piano_d;
    public static final int sound5 = R.raw.piano_e;
    public static final int sound6 = R.raw.piano_f;
    public static final int sound7 = R.raw.piano_g;

    Button dzwiek1;
    Button dzwiek2;
    Button dzwiek3;
    Button dzwiek4;
    Button dzwiek5;
    Button dzwiek6;
    Button dzwiek7;

    static final int READ_BLOCK_SIZE = 1000;

    public void playSound(Context context, int soundID) {
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dzwiek1 = (Button) findViewById(R.id.buttonSound1);
        dzwiek2 = (Button) findViewById(R.id.buttonSound2);
        dzwiek3 = (Button) findViewById(R.id.buttonSound3);
        dzwiek4 = (Button) findViewById(R.id.buttonSound4);
        dzwiek5 = (Button) findViewById(R.id.buttonSound5);
        dzwiek6 = (Button) findViewById(R.id.buttonSound6);
        dzwiek7 = (Button) findViewById(R.id.buttonSound7);
    }

    public void PlaySound_1(View v) {
        int sound = 0;
        if (dzwiek1.getId() == v.getId()) {
            sound = sound1;
            WriteBtn(v," A");
            dzwiek1.setBackgroundColor(Color.GREEN);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.RED);
        } else if (dzwiek2.getId() == v.getId()) {
            sound = sound2;
            WriteBtn(v," B");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.GREEN);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.RED);
        }   else if (dzwiek3.getId() == v.getId()) {
            sound = sound3;
            WriteBtn(v," C");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.GREEN);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.RED);
        }   else if (dzwiek4.getId() == v.getId()) {
            sound = sound4;
            WriteBtn(v," D");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.GREEN);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.RED);
       }    else if (dzwiek5.getId() == v.getId()) {
            sound = sound5;
            WriteBtn(v," E");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.GREEN);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.RED);
        }
            else if (dzwiek6.getId() == v.getId()) {
            sound = sound6;
            WriteBtn(v," F");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.GREEN);
            dzwiek7.setBackgroundColor(Color.RED);
        }
            else if (dzwiek7.getId() == v.getId()) {
            sound = sound7;
            WriteBtn(v," G");
            dzwiek1.setBackgroundColor(Color.RED);
            dzwiek2.setBackgroundColor(Color.RED);
            dzwiek3.setBackgroundColor(Color.RED);
            dzwiek4.setBackgroundColor(Color.RED);
            dzwiek5.setBackgroundColor(Color.RED);
            dzwiek6.setBackgroundColor(Color.RED);
            dzwiek7.setBackgroundColor(Color.GREEN);
        }
        playSound(this, sound);
    }

    public void WriteBtn(View v, String text)
    {
    try
    {
    FileOutputStream fileout = openFileOutput("datafile.txt",MODE_APPEND);
    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
    outputWriter.write(text);
    outputWriter.close();
        fileout.close();

//    Toast.makeText(getBaseContext(),"Zapisane",Toast.LENGTH_SHORT).show();
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }

    public void WriteBtn(View v)
    {
        try
        {
            FileOutputStream fileout = openFileOutput("datafile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write("Twoje nutki:");
            outputWriter.close();

            Toast.makeText(getBaseContext(),"Zapisane",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ReadBtb(View v)
    {
    try
    {
        FileInputStream fileIn = openFileInput("datafile.txt");
        InputStreamReader InputRead = new InputStreamReader(fileIn);

        char[] inputBuffer = new char[READ_BLOCK_SIZE];
        String s ="";
        int charRead;
        while ((charRead = InputRead.read(inputBuffer))>0){
            String readstring = String.copyValueOf(inputBuffer,0,charRead);
            s += readstring;
        }
        InputRead.close();
        Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();
    }
    catch ( Exception e){
        e.printStackTrace();
    }
    }

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)

//    {

//    }
//        else

//    {
//        Toast.makeText(this, "Wersja oprogramowania za stara", Toast.LENGTH_SHORT).show();
//    }
//}
    }

