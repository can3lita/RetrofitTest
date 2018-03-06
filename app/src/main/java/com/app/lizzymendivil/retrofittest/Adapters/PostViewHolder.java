package com.app.lizzymendivil.retrofittest.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com .app.lizzymendivil.retrofittest.R;
import com.app.lizzymendivil.retrofittest.Models.Post;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    LinearLayout linearLayout;
    TextView userId;
    TextView id;
    TextView title;
    TextView body;

    public PostViewHolder(View itemView){
        super(itemView);
        userId = itemView.findViewById(R.id.txt_userId);
        id = itemView.findViewById(R.id.txt_id);
        title = itemView.findViewById(R.id.txt_title);
        body = itemView.findViewById(R.id.txt_body);
        linearLayout = itemView.findViewById(R.id.ln_general);
    }

    public void bind(Post post){
        userId.setText(post.getUserId());
        id.setText(post.getId());
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}
