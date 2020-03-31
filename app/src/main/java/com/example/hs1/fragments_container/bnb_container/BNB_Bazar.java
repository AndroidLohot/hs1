package com.example.hs1.fragments_container.bnb_container;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hs1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BNB_Bazar extends Fragment {

    private Spinner firstChoice,secondeChoice;
    private ArrayList<String> firstList,secondeList;
    private ArrayAdapter<String> fAdapter,sAdapter;
    private int con;
    private Button btnSale,btnBay;


    public BNB_Bazar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_bnb__bazar, container, false);

        firstChoice=(Spinner) view.findViewById(R.id.firstChoice);
        secondeChoice=(Spinner) view.findViewById(R.id.secondChoice);
        btnSale=(Button)view.findViewById(R.id.btnSale);
        btnBay=(Button)view.findViewById(R.id.btnBay);
        firstList=new ArrayList<>();
        secondeList=new ArrayList<>();
        secondeChoice.setVisibility(View.GONE);

        firstList.add("kaddhany");
        firstList.add("palebhajay");
        firstList.add("phale");


        fAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,firstList);
        sAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,secondeList);

        firstChoice.setAdapter(fAdapter);
        secondeChoice.setAdapter(sAdapter);

        firstChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                con=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (con==0)
                {
                    Toast.makeText(getContext(), "Choice "+firstList.get(0), Toast.LENGTH_SHORT).show();
                    secondeChoice.setVisibility(View.VISIBLE);
                }
                if (con==1)
                {
                    Toast.makeText(getContext(), "Choice "+firstList.get(1), Toast.LENGTH_SHORT).show();
                    secondeChoice.setVisibility(View.VISIBLE);
                }
                if (con==2)
                {
                    Toast.makeText(getContext(), "Choice "+firstList.get(2), Toast.LENGTH_SHORT).show();
                    secondeChoice.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

}
