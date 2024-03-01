package com.example.online_pharmcy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
//    This Adapter class is used to bind data to a RecyclerView in Android.
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

   Context context;
   ArrayList<String> list;

   public Adapter(Context context, ArrayList<String> list) {
      this.context = context;
      this.list = list;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_names,parent,false);

      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      String name = list.get(position);

      holder.txt_name.setText(name);

   }

   @Override
   public int getItemCount() {
      return list.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {

      TextView txt_name;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         txt_name = itemView.findViewById(R.id.txt_name);

      }
   }
}
