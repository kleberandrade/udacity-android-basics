package com.udacity.project.tourguide.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.project.tourguide.R;
import com.udacity.project.tourguide.adapters.NewsAdapter;
import com.udacity.project.tourguide.models.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("WeakerAccess")
public class NewsFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public NewsFragment() {

    }

    private List<News> generateNewsList(){
        List<News> newsList = new ArrayList<>();
        newsList.add(new News(getString(R.string.news_title_1), getString(R.string.news_date_1)));
        newsList.add(new News(getString(R.string.news_title_2), getString(R.string.news_date_2)));
        return newsList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, view);

        List<News> newsList = generateNewsList();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        NewsAdapter adapter = new NewsAdapter(view.getContext(), newsList);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
