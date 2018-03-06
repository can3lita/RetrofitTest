package com.app.lizzymendivil.retrofittest.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.lizzymendivil.retrofittest.Adapters.PostRecyclerViewAdapter;
import com.app.lizzymendivil.retrofittest.Models.Post;
import com.app.lizzymendivil.retrofittest.WebServices.RetrofitClient;
import com.app.lizzymendivil.retrofittest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lizzy Mendivil on 3/4/2018.
 */

public class PostFragment extends BaseFragment {

    private static final String TAG = "PostFragment";
    @BindView(R.id.recycler_retrofit)
    RecyclerView recyclerPost;
    Unbinder unbinder;
    PostRecyclerViewAdapter postRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_recycler_view, container, false);
        unbinder = ButterKnife.bind(this,view);
        showLoadingDialog();
        getPosts();
        return view;
    }

    private void getPosts() {
        Call<List<Post>> call = RetrofitClient.getClient().getListPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                List<Post> postList = response.body();
                if (postList.size() > 0) {
                    postRecyclerViewAdapter = new PostRecyclerViewAdapter(postList, getActivity());
                    recyclerPost.setAdapter(postRecyclerViewAdapter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                            LinearLayoutManager.VERTICAL, false);
                    recyclerPost.setLayoutManager(linearLayoutManager);
                    recyclerPost.getAdapter().notifyDataSetChanged();
                } else {
                    showToast("No Existe Usuarios");
                }
                closeLoadingDialog();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_photosr)
    public void onBtnPhotosrClicked() {
        showLoadingDialog();

    }

    @OnClick(R.id.btn_userr)
    public void onBtnUserrClicked() {
        showLoadingDialog();
        getPosts();
    }
}