package ke.co.dataintegrated.mobitillretail.items;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ke.co.dataintegrated.mobitillretail.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyItemsFragment extends Fragment {


    public EmptyItemsFragment() {
        // Required empty public constructor
    }

    public static EmptyItemsFragment newInstance() {

        Bundle args = new Bundle();

        EmptyItemsFragment fragment = new EmptyItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.empty_items_fragment,parent,false);
        return view;
    }

}
