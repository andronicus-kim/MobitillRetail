package ke.co.dataintegrated.mobitillretail.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andronicus on 9/6/2017.
 */

public class Item implements Parcelable{

    private int mImageResId;
    private String mTitle;
    private String mDescription;
    private boolean selected;

    public Item(int imageResId, String title, String description, boolean selected) {
        mImageResId = imageResId;
        mTitle = title;
        mDescription = description;
        this.selected = selected;
    }

    protected Item(Parcel in) {
        mImageResId = in.readInt();
        mTitle = in.readString();
        mDescription = in.readString();
        selected = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getImageResId() {
        return mImageResId;
    }

    public void setImageResId(int imageResId) {
        mImageResId = imageResId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResId);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeByte((byte) (selected ? 1 : 0));
    }
}
