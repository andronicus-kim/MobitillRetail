package ke.co.dataintegrated.mobitillretail.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by andronicus on 9/5/2017.
 */

public class ActivityUtils {

    public static void addFragmentToActivity(@NonNull FragmentManager manager,
                                             @NonNull int frameId,
                                             @NonNull Fragment fragment){
        manager.beginTransaction()
                .replace(frameId,fragment)
                .commit();
    }
}
