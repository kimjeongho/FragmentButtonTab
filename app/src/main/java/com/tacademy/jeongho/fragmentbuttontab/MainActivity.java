package com.tacademy.jeongho.fragmentbuttontab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View selectionButton; //button selector
    private static final String TAB1_TAG = "tab1";  //tab 이름
    private static final String TAB2_TAG = "tab2";  //tab 이름


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn_tab1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAB1_TAG);
                if (old == null){
                Fragment f = new Tab1Fragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container,f,TAB1_TAG);
                ft.commit();
                setSelectView(v);}
            }
        });

        if(savedInstanceState == null){     //처음 나오는 화면 설정
            Fragment f = new Tab1Fragment();
            FragmentTransaction ft  = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, f,TAB1_TAG);
            ft.commit();
            setSelectView(btn);
        }

        btn = (Button)findViewById(R.id.btn_tab2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAB2_TAG);//Tag를 찾기 위해
                if (old == null) {
                    Fragment f = new Tab2Fragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f,TAB2_TAG);
                    ft.commit();
                    setSelectView(v);
                }
            }
        });



    }

    public void setSelectView(View selectView) {
        if(selectionButton != selectView){
            if(selectionButton != null){
                selectionButton.setSelected(false);
            }
            selectionButton = selectView;
            selectionButton.setSelected(true);
        }   // Button Selector
    }
}
