package ke.co.dataintegrated.mobitillretail.items;


import android.content.Context;
import android.os.Bundle;
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
import java.util.Random;

import ke.co.dataintegrated.mobitillretail.R;
import ke.co.dataintegrated.mobitillretail.data.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Item> mItems = new ArrayList<>();
    private CommnicationHandler mHandler;
    public ItemsFragment() {
        // Required empty public constructor
    }

    public static ItemsFragment newInstance() {

        Bundle args = new Bundle();

        ItemsFragment fragment = new ItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean selected;
        Random random = new Random();
        for (int i = 0; i<15;i++){
            if (random.nextBoolean()){
                selected = true;
            }else {
                selected = false;
            }
            Item item = new Item(R.drawable.cake,
                    "Cake",
                    "black forest",
                    selected);
            mItems.add(item);
        }
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

        private List<Item> mItems;

        public ItemAdapter(List<Item> items) {
            mItems = items;
            List<Item> selectedItems = new ArrayList<>();
            for (Item item:mItems){
                if (item.isSelected()){
                    selectedItems.add(item);
                }
            }
            mHandler.sendItems(selectedItems);
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_item,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = mItems.get(position);
            holder.bind(item);

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    public interface CommnicationHandler{
        void sendItems(List<Item> items);
    }

    @Override
    public void onAttach(Context context) {
        try {
            mHandler = (CommnicationHandler) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onAttach(context);
    }
}
