package sg.edu.rp.c346.p11_ps;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnniversaryFragment extends Fragment {
    Button btn;
    TextView tv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.anniversaryfragment, container, false);
        final View view2 = inflater.inflate(R.layout.input, container,false);


        btn = view.findViewById(R.id.btnEdit);
        tv = view.findViewById(R.id.tv);
        final AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBuilder.setView(view2);

                final EditText et = (EditText) view2
                        .findViewById(R.id.editTextResult);
                myBuilder.setTitle("Edit Bio").setView(view2)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String editText = et.getText().toString();
                                tv.setText(editText);
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("input",editText);
                                editor.commit();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        return view;


    }



}
