package com.example.a1405003.chatte.adapter;
//concerned part
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1405003.chatte.R;
import com.example.a1405003.chatte.model.ChatMessage;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by 1405003 on 22-02-2017.
 */


public class RecyclerViewAdapters extends RecyclerView.Adapter<RecyclerViewAdapters.Holder> {

    private TextView MESSAGE_OTHER;
    private TextView MESSAGE_ME;
    private ArrayList<ChatMessage> ListData;
    private LayoutInflater inflater;
    private Context Main;
    public static String Sender=null;
    private FirebaseAuth mAuth;


    public RecyclerViewAdapters(ArrayList<ChatMessage> listData, Context c,FirebaseAuth auth) {
        this.ListData = listData;
        this.inflater=LayoutInflater.from(c);
        Main=c;
        mAuth=auth;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.layout_recipient_message,parent,false);



        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        ChatMessage list_item=ListData.get(position);
        String UID=list_item.Uid;


       if(mAuth.getCurrentUser().getUid().equals(UID))
       {
           holder.MESSAGE_ME.setText(list_item.Message);
           holder.MESSAGE_OTHER.setVisibility(View.INVISIBLE);
       }
        else
       {
           holder.MESSAGE_OTHER.setText(list_item.Message);
           holder.MESSAGE_ME.setVisibility(View.INVISIBLE);
       }



    }

    @Override
    public int getItemCount() {
        return ListData.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        private TextView MESSAGE_OTHER;
        private TextView MESSAGE_ME;


        public Holder(View itemView) {
            super(itemView);




            MESSAGE_OTHER=(TextView) itemView.findViewById(R.id.OTHER_ID) ;
            MESSAGE_ME=(TextView) itemView.findViewById(R.id.MY_ID);



        }



    }


}