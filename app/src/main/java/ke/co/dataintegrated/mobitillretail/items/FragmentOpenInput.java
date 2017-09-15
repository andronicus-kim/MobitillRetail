package ke.co.dataintegrated.mobitillretail.items;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ke.co.dataintegrated.mobitillretail.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOpenInput extends DialogFragment {

    private static final String LABEL = "LABEL";

    private String mLabel;


    public FragmentOpenInput() {
        // Required empty public constructor
    }

    public static FragmentOpenInput newInstance(String label) {

        Bundle args = new Bundle();
        args.putString(LABEL,label);

        FragmentOpenInput fragment = new FragmentOpenInput();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mLabel = getArguments().getString(LABEL);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_open_input,null);
        EditText editText = (EditText) view.findViewById(R.id.et_dialog);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(mLabel)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getActivity(), "Proceed...", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                })
                .create();
    }
}
