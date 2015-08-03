package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.AsyncJokeDownloader;
import com.udacity.gradle.builditbigger.IDownloadListener;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity {
    ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
        new AsyncJokeDownloader(new IDownloadListener() {
            @Override
            public void downloadCompleted(String j) {
                Intent in = new Intent("android.intent.joke.Display");
                in.putExtra("Joke", j);
                startActivity(in);
            }
        }).downloadJoke();

        //startActivity(in);
        //Toast.makeText(this, Jokes.getJoke(), Toast.LENGTH_SHORT).show();
    }

}
