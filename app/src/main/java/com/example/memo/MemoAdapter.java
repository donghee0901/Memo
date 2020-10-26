package com.example.memo;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    private List<MemoEntity> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    MemoAdapter(List<MemoEntity> list) {
        mData = list ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memobar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(mData.get(position).title);
        holder.content.setText(mData.get(position).content);
        holder.ID.setText(Integer.toString(mData.get(position).id));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title = itemView.findViewById(R.id.title);
        TextView content = itemView.findViewById(R.id.content);
        TextView ID = itemView.findViewById(R.id.ID);


        ViewHolder(View itemView) {
            super(itemView) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), MemoViewActivity.class);
                    i.putExtra("title",title.getText().toString());
                    i.putExtra("content",content.getText().toString());
                    i.putExtra("id",ID.getText().toString());
                    itemView.getContext().startActivity(i); //새 액티비티 띄우기
                }
            });

        }

    }




}

