package com.example.w7_p3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemList> dataSets = new ArrayList<>();
    private RecyclerViewAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView movie = findViewById(R.id.recycler);
        RecyclerView.LayoutManager movieLayoutManager = new LinearLayoutManager(this);

        movieAdapter = new RecyclerViewAdapter(dataSets);
        movie.setLayoutManager(movieLayoutManager);
        movie.setAdapter(movieAdapter);

        getData();

    }

    @SuppressLint({"NotifyDataSetChanged", "UseCompatLoadingForDrawables"})
    private void getData(){

        List<String> movieTitle = Arrays.asList("Spock's Brain",
                "Arena",
                "This Side of Paradise",
                "Mirror,Mirror",
                "Plato's Step Children",
                "The Naked Time",
                "The Trouble with Tribbles");
        List<String> movieDescription = Arrays.asList("Some people in swinsuits steal Spock's Brain. Hmm...",
                "Captain Kirk fights a plastic 3D Molded lizard",
                "A flower explodes in Spock's face and makes him happy",
                "Alternative Universe",
                "Captain Kirk and Spock play dress up",
                "Sulu goes nuts",
                "So cute!");
        int[] moviePoster = {R.drawable.spocks_brain,R.drawable.st_arena__kirk_gorn,R.drawable.st_this_side_of_paradise__spock_in_love,R.drawable.st_platos_stepchildren__kirk_spock, R.drawable.st_the_naked_time__sulu_sword,R.drawable.st_the_trouble_with_tribbles__kirk_tribbles};


        for (int i = 0; i < movieTitle.size(); i++){
            ImageView imageView = (ImageView) findViewById(R.id.imgEpisode);
//            imageView.setImageResource(moviePoster[i]);
            ItemList addnewData = new ItemList(imageView,movieTitle.get(i),movieDescription.get(i));


            movieAdapter.addItem(addnewData);
        }
        movieAdapter.notifyDataSetChanged();

    }


}