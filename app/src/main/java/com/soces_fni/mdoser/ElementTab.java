package com.soces_fni.mdoser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.soces_fni.mdoser.model.Concrete;
import com.soces_fni.mdoser.model.Sand;
import com.soces_fni.mdoser.model.Water;

import java.math.BigDecimal;

/**
 * controller for tab element.
 */
public class ElementTab extends Fragment {
    private static final String TAG = "ELEMENTS";
    private Spinner txtProportion;
    private EditText txtCoeficient;
    private Button btnCalculate;
    private TextView lblConcrete;
    private TextView lblSand;
    private TextView lblWater;
    private static final String CONCRETE = "Concreto: ";
    private static final String SAND = "Arena: ";
    private static final String WATER = "Agua: ";
    private static final String CONCRETE_UNITY = " [kg/m3 mortero]";
    private static final String SAND_UNITY = " [m3 arena/m3 mortero]";
    private static final String WATER_UNITY = " [l/m3 mortero]";

    /**
     * method which receives data and send the answer.
     */
    private void Calculate() {
        int proportion;
        int coeficient;
        proportion = Integer.parseInt(txtProportion.getSelectedItem().toString());
        coeficient = Integer.parseInt(txtCoeficient.getText().toString());
        Concrete concrete = new Concrete(proportion, coeficient);
        Sand sand = new Sand(proportion, coeficient);
        Water water = new Water(proportion, coeficient);

        StringBuffer builder = new StringBuffer();
        BigDecimal bigDecimal = new BigDecimal(concrete.CalculateQuantity());
        bigDecimal = bigDecimal.divide(new BigDecimal("1"), 3, BigDecimal.ROUND_HALF_UP);
        builder.append(CONCRETE);
        builder.append(bigDecimal.toPlainString());
        builder.append(CONCRETE_UNITY);
        lblConcrete.setText(builder.toString());

        builder = new StringBuffer();
        bigDecimal = new BigDecimal(sand.CalculateQuantity());
        bigDecimal = bigDecimal.divide(new BigDecimal("1"), 3, BigDecimal.ROUND_HALF_UP);
        builder.append(SAND);
        builder.append(bigDecimal.toPlainString());
        builder.append(SAND_UNITY);
        lblSand.setText(builder.toString());

        builder = new StringBuffer();
        bigDecimal = new BigDecimal(water.CalculateQuantity());
        bigDecimal = bigDecimal.divide(new BigDecimal("1"), 3, BigDecimal.ROUND_HALF_UP);
        builder.append(WATER);
        builder.append(bigDecimal.toPlainString());
        builder.append(WATER_UNITY);
        lblWater.setText(builder.toString());
    }

    /**
     * method which creates the fragment view.
     * @param inflater .
     * @param container .
     * @param savedInstanceState .
     * @return view.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.element_tab_fragment, container, false);
        String[] proportions = new String[] {"1", "2", "3", "4", "5"};
        txtProportion = view.findViewById(R.id.txtProportion);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, proportions);
        txtProportion.setAdapter(adapter);
        txtCoeficient = view.findViewById(R.id.txtCoeficient);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        lblConcrete = view.findViewById(R.id.lblConcrete);
        lblSand = view.findViewById(R.id.lblSand);
        lblWater = view.findViewById(R.id.lblWater);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });
        return view;
    }
}
