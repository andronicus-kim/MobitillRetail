package ke.co.dataintegrated.mobitillretail.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by andronicus on 9/15/2017.
 */

public class ServicesPersistenceContract {

    //prevent instantiation
    private ServicesPersistenceContract(){}

    public static abstract class ServicesEntry implements BaseColumns{
        public static final String TABLE_NAME = "services";
        public static final String COLUMN_NAME_SERVICE_MENU_ID = "service_menu_id";
        public static final String COLUMN_NAME_LABEL_ID = "label_id";
        public static final String COLUMN_NAME_PRODUCT_ID = "product_id";
        public static final String COLUMN_NAME_ADD_ON = "addon";
        public static final String COLUMN_NAME_CHILD = "child";
        public static final String COLUMN_NAME_PARENT = "parent";
        public static final String COLUMN_NAME_SUB_CHILD = "subchild";
        public static final String COLUMN_NAME_LABEL= "label";
        public static final String COLUMN_NAME_LTYPE = "ltype";
        public static final String COLUMN_NAME_MAX = "max";
        public static final String COLUMN_NAME_MIN = "min";
        public static final String COLUMN_NAME_DATA_TYPE = "datatype";
        public static final String COLUMN_NAME_DEFAULT_VALUE = "default_value";
        public static final String COLUMN_NAME_QT_LABEL = "label";
        public static final String COLUMN_NAME_EXTRA = "extra";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
