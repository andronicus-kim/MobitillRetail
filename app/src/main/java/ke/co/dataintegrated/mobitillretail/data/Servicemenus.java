
package ke.co.dataintegrated.mobitillretail.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Servicemenus implements Parcelable{

    private Long mAddon;
    private Long mChild;
    private Long mDataType;
    private String mDefaultValue;
    private String mDescription;
    private String mExtra;
    private Long mLType;
    private String mLabel;
    private Long mLabelId;
    private Double mMax;
    private Double mMin;
    private Long mParent;
    private String mProductId;
    private String mQtLabel;
    private Long mServicemenuId;
    private Long mSubchild;

    public Servicemenus() {
    }

    protected Servicemenus(Parcel in) {
        if (in.readByte() == 0) {
            mAddon = null;
        } else {
            mAddon = in.readLong();
        }
        if (in.readByte() == 0) {
            mChild = null;
        } else {
            mChild = in.readLong();
        }
        if (in.readByte() == 0) {
            mDataType = null;
        } else {
            mDataType = in.readLong();
        }
        mDefaultValue = in.readString();
        mDescription = in.readString();
        mExtra = in.readString();
        if (in.readByte() == 0) {
            mLType = null;
        } else {
            mLType = in.readLong();
        }
        mLabel = in.readString();
        if (in.readByte() == 0) {
            mLabelId = null;
        } else {
            mLabelId = in.readLong();
        }
        if (in.readByte() == 0) {
            mMax = null;
        } else {
            mMax = in.readDouble();
        }
        if (in.readByte() == 0) {
            mMin = null;
        } else {
            mMin = in.readDouble();
        }
        if (in.readByte() == 0) {
            mParent = null;
        } else {
            mParent = in.readLong();
        }
        mProductId = in.readString();
        mQtLabel = in.readString();
        if (in.readByte() == 0) {
            mServicemenuId = null;
        } else {
            mServicemenuId = in.readLong();
        }
        if (in.readByte() == 0) {
            mSubchild = null;
        } else {
            mSubchild = in.readLong();
        }
    }

    public static final Creator<Servicemenus> CREATOR = new Creator<Servicemenus>() {
        @Override
        public Servicemenus createFromParcel(Parcel in) {
            return new Servicemenus(in);
        }

        @Override
        public Servicemenus[] newArray(int size) {
            return new Servicemenus[size];
        }
    };

    public Long getAddon() {
        return mAddon;
    }

    public void setAddon(Long addon) {
        mAddon = addon;
    }

    public Long getChild() {
        return mChild;
    }

    public void setChild(Long child) {
        mChild = child;
    }

    public Long getDataType() {
        return mDataType;
    }

    public void setDataType(Long dataType) {
        mDataType = dataType;
    }

    public String getDefaultValue() {
        return mDefaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        mDefaultValue = defaultValue;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getExtra() {
        return mExtra;
    }

    public void setExtra(String extra) {
        mExtra = extra;
    }

    public Long getLType() {
        return mLType;
    }

    public void setLType(Long lType) {
        mLType = lType;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public Long getLabelId() {
        return mLabelId;
    }

    public void setLabelId(Long labelId) {
        mLabelId = labelId;
    }

    public Double getMax() {
        return mMax;
    }

    public void setMax(Double max) {
        mMax = max;
    }

    public Double getMin() {
        return mMin;
    }

    public void setMin(Double min) {
        mMin = min;
    }

    public Long getParent() {
        return mParent;
    }

    public void setParent(Long parent) {
        mParent = parent;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }

    public String getQtLabel() {
        return mQtLabel;
    }

    public void setQtLabel(String qtLabel) {
        mQtLabel = qtLabel;
    }

    public Long getServicemenuId() {
        return mServicemenuId;
    }

    public void setServicemenuId(Long servicemenuId) {
        mServicemenuId = servicemenuId;
    }

    public Long getSubchild() {
        return mSubchild;
    }

    public void setSubchild(Long subchild) {
        mSubchild = subchild;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mAddon == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mAddon);
        }
        if (mChild == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mChild);
        }
        if (mDataType == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mDataType);
        }
        dest.writeString(mDefaultValue);
        dest.writeString(mDescription);
        dest.writeString(mExtra);
        if (mLType == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mLType);
        }
        dest.writeString(mLabel);
        if (mLabelId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mLabelId);
        }
        if (mMax == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mMax);
        }
        if (mMin == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mMin);
        }
        if (mParent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mParent);
        }
        dest.writeString(mProductId);
        dest.writeString(mQtLabel);
        if (mServicemenuId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mServicemenuId);
        }
        if (mSubchild == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mSubchild);
        }
    }
}
