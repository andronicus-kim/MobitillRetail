package ke.co.dataintegrated.mobitillretail.items;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.data.Servicemenus;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private static final String SERVICE_MENUS = "SERVICE_MENUS";

    private RecyclerView mRecyclerView;
    private List<Servicemenus> mItems = new ArrayList<>();
    private ArrayList<Servicemenus> selectedItems = new ArrayList<>();
    public ItemsFragment() {
        // Required empty public constructor
    }

    public static ItemsFragment newInstance(ArrayList<? extends Parcelable> servicemenus) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(SERVICE_MENUS,servicemenus);

        ItemsFragment fragment = new ItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = getArguments().getParcelableArrayList(SERVICE_MENUS);
        boolean selected;
//        Random random = new Random();
//        String[] services = new String[]{"ARMREST","VISOR","SIDE WINDOW","Distributor","Distributor Cap",
//                "Spark Plug", "Splig Rings"};
//        for (int i = 0; i<7;i++){
//            if (random.nextBoolean()){
//                selected = true;
//            }else {
//                selected = false;
//            }
//            Item item = new Item(R.drawable.cake,
//                    services[i],
//                    "A little description about the service",
//                    false);
//            mItems.add(item);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.items_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new ItemAdapter(mItems));
        return view;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayoutItems;
        private ImageView mImageViewIcon;
        private TextView mTextViewTitle;
        private TextView mTextViewDesc;
        private CheckBox mCheckBoxSelected;

        public ItemViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            mLinearLayoutItems = (LinearLayout) view.findViewById(R.id.ll_items);
            mImageViewIcon = (ImageView) view.findViewById(R.id.iv_icon);
            mTextViewTitle = (TextView) view.findViewById(R.id.tv_title);
            mTextViewDesc = (TextView) view.findViewById(R.id.tv_desc);
            mCheckBoxSelected = (CheckBox) view.findViewById(R.id.cb_selected);
        }
        public void bind(Servicemenus menuItem){
            mImageViewIcon.setImageResource(R.drawable.cake);
            mTextViewTitle.setText(menuItem.getLabel());
//            mTextViewDesc.setText(item.getDescription());
        }

        @Override
        public void onClick(View v) {
            Servicemenus menuItem = mItems.get(getAdapterPosition());
            if (!mCheckBoxSelected.isChecked()){
                mCheckBoxSelected.setChecked(true);
                mLinearLayoutItems.setBackgroundColor(getResources().getColor(R.color.state_pressed));
                selectedItems.add(menuItem);
            }else {
                mCheckBoxSelected.setChecked(false);
                mLinearLayoutItems.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
    }
    private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

        private List<Servicemenus> mItems;

        public ItemAdapter(List<Servicemenus> items) {
            mItems = items;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_item,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Servicemenus menuItem = mItems.get(position);
            holder.bind(menuItem);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
    public ArrayList<Servicemenus> getSelectedItems(){
        return selectedItems;
    }
}
