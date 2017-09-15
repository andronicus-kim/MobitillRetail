package ke.co.dataintegrated.mobitillretail.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static ke.co.dataintegrated.mobitillretail.data.source.local.ServicesPersistenceContract.*;

/**
 * Created by andronicus on 9/15/2017.
 */

public class ServicesDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "services.db";

    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT_TYPE";
    private static final String INTEGER_TYPE = " INTEGER_TYPE";
    private static final String COMMA_SEP = " ,";

    private static final String SQL_CREATE_SERVICES_ENTRIES =
            "CREATE TABLE " + ServicesEntry.TABLE_NAME + " ("+
                    ServicesEntry._ID + INTEGER_TYPE + " PRIMARY_KEY AUTOINCREMENT,"+
                    ServicesEntry.COLUMN_NAME_SERVICE_MENU_ID + INTEGER_TYPE + COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_LABEL_ID + INTEGER_TYPE + COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_PRODUCT_ID + TEXT_TYPE +COMMA_SEP+
                    ServicesEntry.COLUMN_NAME_ADD_ON + INTEGER_TYPE + COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_CHILD + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_PARENT + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_SUB_CHILD + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_LABEL + TEXT_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_LTYPE + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_MAX + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_MIN + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_DATA_TYPE + INTEGER_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_DEFAULT_VALUE+ TEXT_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_QT_LABEL + TEXT_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_EXTRA + TEXT_TYPE +COMMA_SEP +
                    ServicesEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE +
                    " )";



    public ServicesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_SERVICES_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
