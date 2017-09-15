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
import android.widget.TextView;

import ke.co.dataintegrated.mobitillretail.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFix extends DialogFragment {

    private static final String LABEL = "LABEL";
    private static final String DEF_VALUE = "DEF_VALUE";

    private String mLabel;
    private String mDefaultValue;

    private TextView mTextViewFixLabel;
    private TextView mTextViewFixDefValue;

    public FragmentFix() {
        // Required empty public constructor
    }

    public static FragmentFix newInstance(String label,String defaultValue) {

        Bundle args = new Bundle();
        args.putString(LABEL,label);
        args.putString(DEF_VALUE,defaultValue);

        FragmentFix fragment = new FragmentFix();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mLabel = getArguments().getString(LABEL);
        mDefaultValue = getArguments().getString(DEF_VALUE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_fix,null);
        mTextViewFixLabel = (TextView) view.findViewById(R.id.tv_fix_label);
        mTextViewFixDefValue = (TextView) view.findViewById(R.id.tv_fix_def_value);
        mTextViewFixLabel.setText(mLabel);
        mTextViewFixDefValue.setText("Kshs. " + mDefaultValue);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
    }
}
