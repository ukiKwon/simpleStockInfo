package com.uki.ssi;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder> {
    private ArrayList<SimpleStock> mList = null;

    public class StockViewHolder extends RecyclerView.ViewHolder {
        protected TextView rankView;
        protected TextView nameView;
        protected ImageView img1, img2, img3;

        public StockViewHolder(View view) {
            super(view);
            this.rankView = (TextView)view.findViewById(R.id.item_rank);
            this.nameView = (TextView)view.findViewById(R.id.item_name);
            this.img1 = (ImageView) view.findViewById(R.id.item_growth);
            this.img2 = (ImageView) view.findViewById(R.id.item_stability);
            this.img3 = (ImageView) view.findViewById(R.id.item_interest);
        }
    }
    public StockAdapter(ArrayList <SimpleStock> list) {
        this.mList = list;
    }
    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_list, viewGroup, false);
        StockViewHolder viewHolder = new StockViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull StockViewHolder viewHolder, int position) {

        SimpleStock item = mList.get(position);

        viewHolder.rankView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewHolder.nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewHolder.rankView.setGravity(Gravity.CENTER);
        viewHolder.nameView.setGravity(Gravity.CENTER);

        viewHolder.rankView.setText("1");
        viewHolder.nameView.setText("샘플");
        viewHolder.img1.setImageDrawable(item.getImg1());
        viewHolder.img2.setImageDrawable(item.getImg2());
        viewHolder.img3.setImageDrawable(item.getImg3());
        //
//        if (position + 1 == getItemCount()) {
//            // set bottom margin to 72dp.
//            setBottomMargin(viewHolder.itemView, (int) (72 * Resources.getSystem().getDisplayMetrics().density));
//        } else {
//            // reset bottom margin back to zero. (your value may be different)
//            setBottomMargin(viewHolder.itemView, 0);
//        }
    }
//    public static void setBottomMargin(View view, int bottomMargin) {
//        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
//            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, bottomMargin);
//            view.requestLayout();
//        }
//    }
    @Override
    public int getItemCount() {
        return (null != mList? mList.size() : 0 );
    }
}
