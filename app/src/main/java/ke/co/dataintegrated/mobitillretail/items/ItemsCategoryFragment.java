package ke.co.dataintegrated.mobitillretail.items;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.data.Repository;
import ke.co.dataintegrated.mobitillretail.data.Servicemenus;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsCategoryFragment extends Fragment {


    private List<Servicemenus> mServices = new ArrayList<>();
    private List<Servicemenus> mBuyMoreThanOne = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ServicesAdapter mAdapter;

    public ItemsCategoryFragment() {
        // Required empty public constructor
    }

    public static ItemsCategoryFragment newInstance() {

        Bundle args = new Bundle();

        ItemsCategoryFragment fragment = new ItemsCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.items_category_fragment, container, false);
        for (Servicemenus servicemenus: new Repository().getServices()){
            if (servicemenus.getParent() == 1){
                mServices.add(servicemenus);
            }
            if (servicemenus.getParent() == 5){
                mBuyMoreThanOne.add(servicemenus);
            }
        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_services);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ServicesAdapter(mServices);
        mRecyclerView.setAdapter(mAdapter);
//        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
//        List<String> labels = new ArrayList<>();
//        mServices = new Repository().getServices();
//        for (Servicemenus menu: mServices){
//            if (menu.getParent() == 1){
//                labels.add(menu.getLabel());
//            }
//
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity()
//                ,android.R.layout.simple_spinner_item,
//               labels);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.services,
//                android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setPrompt(getResources().getString(R.string.merchant_services));
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Servicemenus menuItem = mServices.get(position);
//                if(menuItem.getChild() == 2){
//                    FragmentOpenInput fragmentDialog = FragmentOpenInput.newInstance(menuItem.getQtLabel());
//                    fragmentDialog.show(getFragmentManager(),null);
//                    fragmentDialog.setCancelable(false);
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        return view;
    }

    private class ServicesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTextViewServices;

        public ServicesHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextViewServices = (TextView) itemView.findViewById(R.id.tv_services);
        }
        private void bindServices(Servicemenus menu){
                mTextViewServices.setText(menu.getLabel());
        }

        @Override
        public void onClick(View v) {
            Servicemenus menuItem = mServices.get(getAdapterPosition());
            switch (menuItem.getLType().intValue()){
                case 1:
                    break;
                case 2:
                    FragmentFix fragmentFix = FragmentFix.newInstance(menuItem.getLabel(),menuItem.getDefaultValue());
                    fragmentFix.show(getFragmentManager(),null);
                    fragmentFix.setCancelable(false);
                    break;
                case 3:
                    FragmentOpenInput fragmentDialog = FragmentOpenInput.newInstance(menuItem.getQtLabel());
                    fragmentDialog.show(getFragmentManager(), null);
                    fragmentDialog.setCancelable(false);
                    break;
                case 4:

                    break;
                case 5:
                    getActivity().startActivity(ActivityMultiple.newIntent(getActivity(), (ArrayList<Servicemenus>) mBuyMoreThanOne));
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;

            }
            if (menuItem.getLType() == 3) {

            }
        }
    }
    private class ServicesAdapter extends RecyclerView.Adapter<ServicesHolder>{

        private List<Servicemenus> mServicemenus;

        public ServicesAdapter(List<Servicemenus> servicemenus) {
            mServicemenus = servicemenus;
        }

        @Override
        public ServicesHolder onCreateViewHolder(ViewGroup parent, int position) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.merchant_services_item,parent,false);
            return new ServicesHolder(view);
        }

        @Override
        public void onBindViewHolder(ServicesHolder holder, int position) {

            holder.bindServices(mServicemenus.get(position));

        }

        @Override
        public int getItemCount() {
            return mServicemenus.size();
        }
    }

}
