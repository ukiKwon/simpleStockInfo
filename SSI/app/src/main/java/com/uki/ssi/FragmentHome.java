package com.uki.ssi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class FragmentHome extends Fragment {
    MainActivity mActivity;
    private FloatingActionButton mFloatingActionButton;
    private boolean shinkSwitch = TRUE;
    private RecyclerView mRecyclerView = null ;
    private StockAdapter mAdapter = null ;
    ArrayList<SimpleStock> mList = new ArrayList<SimpleStock>();
    //
    private static final int DATASET_COUNT = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity)getActivity();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
    @Nullable
    @Override
    //public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_recyclerview, container, false);
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        //Define recyclerView
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_stock);

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//아이템을 세로로 배정하기 위해, default가 vertical임
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);
        ((LinearLayoutManager) layoutManager).setReverseLayout(true);

        mRecyclerView.setLayoutManager(layoutManager);
        //Stick Adapter to RecyclerView
        mAdapter = new StockAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);//recyclerview에 어댑터 붙임

        mAdapter.notifyDataSetChanged();
        //Define view and button things
        mFloatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.floating_action_button);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable[] d3 = {mActivity.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp),
                        mActivity.getDrawable(R.drawable.ic_sentiment_satisfied_black_24dp),
                        mActivity.getDrawable(R.drawable.ic_sentiment_dissatisfied_black_24dp)};
                addItem("2", "sample", d3);
                mAdapter.notifyItemInserted(0);//어댑터에서 RecyclerView로 반영
            }
        });
        return rootView;
    }
    private void initDataset() {
        Drawable[] d3 = {mActivity.getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp),
                mActivity.getDrawable(R.drawable.ic_sentiment_satisfied_black_24dp),
                mActivity.getDrawable(R.drawable.ic_sentiment_dissatisfied_black_24dp)};
        for (int i = 0; i < DATASET_COUNT; i++) {
            addItem(i+"", i+"ele", d3);
        }
    }
    public void addItem(String rank, String name, Drawable[] imgs) {
        SimpleStock item = new SimpleStock();

        item.setRank(rank);
        item.setName(name);
        item.setImg1(imgs[0]);
        item.setImg2(imgs[1]);
        item.setImg3(imgs[2]);

        mList.add(item);
    }
}
