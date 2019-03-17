package com.soces_fni.mdoser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.soces_fni.mdoser.model.Brick;

public class BrickTab extends Fragment {
    private static final String TAG = "Tab1";
    EditText txtHeight;
    private EditText txtBase;
    private EditText txtSeparation;
    private Button btnCalculate;
    private TextView lblBricks;
    private static final String UNITY = " [ladrillo(s)/m2]";

    private void Calculate() {
        float height;
        float base;
        float separation;
        height = Float.parseFloat(txtHeight.getText().toString());
        base = Float.parseFloat(txtBase.getText().toString());
        separation = Float.parseFloat(txtSeparation.getText().toString());

        Brick brick = new Brick(height, base, separation);
        StringBuffer builder = new StringBuffer();
        builder.append(brick.CalculateQuantity());
        builder.append(UNITY);
        lblBricks.setText(builder.toString());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brick_tab_fragment, container, false);
        txtHeight = view.findViewById(R.id.txtHeight);
        txtBase = view.findViewById(R.id.txtBase);
        txtSeparation = view.findViewById(R.id.txtSeparation);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        lblBricks = view.findViewById(R.id.lblBricks);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
        return view;
    }
}
