package com.tacademy.jeongho.fragmentbuttontab;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {


    public Tab2Fragment() {
        // Required empty public constructor
    }

    private static final int REQUEST_CODE_OTHER = 0 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        Button btn = (Button)v.findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),OtherActivity.class);
                intent.putExtra(OtherActivity.EXTRA_MESSAGE,"fragment_message");
                startActivityForResult(intent, REQUEST_CODE_OTHER);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_OTHER && resultCode == Activity.RESULT_OK){
            String message = data.getStringExtra(OtherActivity.RESULT_MESSAGE);
            Toast.makeText(getContext(),"message :" + message,Toast.LENGTH_SHORT).show();
        }
    }
}
