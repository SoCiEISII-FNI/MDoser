package com.soces_fni.mdoser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.soces_fni.mdoser.model.Brick;

/**
 * controller for tab of bricks.
 */
public class BrickTab extends Fragment {
    private static final String UNITY = " [ladrillo(s)/m2]";
    private EditText txtHeight;
    private EditText txtBase;
    private EditText txtSeparation;
    private Button btnCalculate;
    private TextView lblBricks;

    private static final String HEIGHT = "Altura: ";
    private static final String BASE = "Base: ";
    private static final String SEPARATION = "Junta: ";
    private static final String UNITY_INPUT = " [cm]";
    private TextView lblHeight;
    private TextView lblBase;
    private TextView lblSeparation;

    /**
     * method which receives data and send the answer.
     */
    private void Calculate(float height, float base, float separation) {
        Brick brick = new Brick(height, base, separation);
        StringBuffer builder = new StringBuffer();
        builder.append(brick.CalculateQuantity());
        builder.append(UNITY);
        lblBricks.setText(builder.toString());

        builder = new StringBuffer();
        builder.append(HEIGHT);
        builder.append(height);
        builder.append(UNITY_INPUT);
        lblHeight.setText(builder.toString());

        builder = new StringBuffer();
        builder.append(BASE);
        builder.append(base);
        builder.append(UNITY_INPUT);
        lblBase.setText(builder.toString());

        builder = new StringBuffer();
        builder.append(SEPARATION);
        builder.append(height);
        builder.append(UNITY_INPUT);
        lblSeparation.setText(builder.toString());
    }

    /**
     * creates the view of te fragement.
     * @param inflater .
     * @param container .
     * @param savedInstanceState .
     * @return view.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brick_tab_fragment, container, false);
        final float[] height = new float[1];
        final float[] base = new float[1];
        final float[] separation = new float[1];
        final boolean[] validationCounter = {false, false, false};
        txtHeight = view.findViewById(R.id.txtHeight);
        txtBase = view.findViewById(R.id.txtBase);
        txtSeparation = view.findViewById(R.id.txtSeparation);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        lblBricks = view.findViewById(R.id.lblBricks);
        lblHeight = view.findViewById(R.id.lblHeight);
        lblBase = view.findViewById(R.id.lblBase);
        lblSeparation = view.findViewById(R.id.lblSeparation);

        txtHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /**
             * validation when writting.
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if(txtHeight.getText().toString() != "") {
                        height[0] = Float.parseFloat(txtHeight.getText().toString());
                        validationCounter[0] = true;
                    }
                } catch (Exception ex) {
                    txtHeight.setError("Error en el dato ingresado");
                    validationCounter[0] = false;
                    btnCalculate.setEnabled(false);
                    txtHeight.requestFocus();
                }
            }

            /**
             * enable button calcular.
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {
                if(validationCounter[0] && validationCounter[1] && validationCounter[2])
                    btnCalculate.setEnabled(true);
            }
        });

        txtBase.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /**
             * validation when writting.
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if(txtBase.getText().toString() != "") {
                        base[0] = Float.parseFloat(txtBase.getText().toString());
                        validationCounter[1] = true;
                    }
                } catch (Exception ex) {
                    txtBase.setError("Error en el dato ingresado");
                    validationCounter[1] = false;
                    btnCalculate.setEnabled(false);
                    txtBase.requestFocus();
                }
            }

            /**
             * enable button calcular.
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {
                if(validationCounter[0] && validationCounter[1] && validationCounter[2])
                    btnCalculate.setEnabled(true);
            }
        });

        txtSeparation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /**
             * validation when writting.
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    if(txtSeparation.getText().toString() != "") {
                        separation[0] = Float.parseFloat(txtSeparation.getText().toString());
                        validationCounter[2] = true;
                    }
                } catch (Exception ex) {
                    txtSeparation.setError("Error en el dato ingresado");
                    validationCounter[2] = false;
                    btnCalculate.setEnabled(false);
                    txtSeparation.requestFocus();
                }
            }

            /**
             * enable button calcular.
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {
                if(validationCounter[0] && validationCounter[1] && validationCounter[2])
                    btnCalculate.setEnabled(true);
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            /**
             * Calculate action.
             * @param v
             */
            @Override
            public void onClick(View v) {
                Calculate(height[0], base[0], separation[0]);
                btnCalculate.setEnabled(false);
                validationCounter[0] = false;
                validationCounter[1] = false;
                validationCounter[2] = false;
                txtHeight.setText("");
                txtBase.setText("");
                txtSeparation.setText("");
            }
        });

        return view;
    }
}
