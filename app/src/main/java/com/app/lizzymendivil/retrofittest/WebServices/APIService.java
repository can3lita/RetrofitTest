package com.app.lizzymendivil.retrofittest.WebServices;

import com.app.lizzymendivil.retrofittest.Models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public interface APIService {

    @GET("/posts")
    Call<List<Post>> getListPosts();
}
