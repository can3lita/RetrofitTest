package com.app.lizzymendivil.retrofittest.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.lizzymendivil.retrofittest.Models.Post;
import com.app.lizzymendivil.retrofittest.R;

import java.util.List;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

    List<Post> postList;

    public PostRecyclerViewAdapter(List<Post> postList, Activity activity){
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
