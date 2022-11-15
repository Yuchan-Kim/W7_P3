package com.example.w7_p3;

import android.media.Image;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

public class ItemList {
    private ImageView imageView;
    private String title;
    private String episode;

    public ItemList(ImageView imageView, String title, String episode) {
        this.imageView = imageView;
        this.title = title;
        this.episode = episode;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ItemList(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}
