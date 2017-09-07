package ke.co.dataintegrated.mobitillretail.cart;


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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.data.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    public static final String SELECTED_ITEMS = "SELECTED_ITEMS";
    private RecyclerView mRecyclerView;
    private ArrayList<Parcelable> mItems = new ArrayList<>();


    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance(List<Item> items) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(SELECTED_ITEMS, (ArrayList<? extends Parcelable>) items);

        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mItems = bundle.getParcelableArrayList(SELECTED_ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_selected_items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new CartFragment.ItemAdapter(mItems));
        return view;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageViewIcon;
        private TextView mTextViewTitle;
        private TextView mTextViewDesc;
        private CheckBox mCheckBoxSelected;

        public ItemViewHolder(View view) {
            super(view);
            mImageViewIcon = (ImageView) view.findViewById(R.id.iv_icon);
            mTextViewTitle = (TextView) view.findViewById(R.id.tv_title);
            mTextViewDesc = (TextView) view.findViewById(R.id.tv_desc);
            mCheckBoxSelected = (CheckBox) view.findViewById(R.id.cb_selected);
        }
        public void bind(Item item){
            mImageViewIcon.setImageResource(item.getImageResId());
            mTextViewTitle.setText(item.getTitle());
            mTextViewDesc.setText(item.getDescription());
            mCheckBoxSelected.setChecked(item.isSelected());
        }
    }
    private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

        private ArrayList<Parcelable> mItems;

        public ItemAdapter(ArrayList<Parcelable> items) {
            mItems = items;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_item,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = (Item) mItems.get(position);
            holder.bind(item);

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}
