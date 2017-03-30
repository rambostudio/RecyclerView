package com.rambostudio.zojoz.recyclerview;

import java.util.Collection;
import java.util.List;

/**
 * Created by SoftBaked on 3/30/2017 AD.
 */

public class CollectionIndexUtils {

    //prevent arrayindexoutofbounds exception
    public static boolean isAvailableData(Collection<?> list, int holderAdapterPosition) {
        return null != list && !list.isEmpty() && holderAdapterPosition >= 0 && list.size() > holderAdapterPosition;
    }

    public static int getSize(List<?> list){
        int size = 0;
        if(null != list && !list.isEmpty()){
            size = list.size();
        }
        return size;
    }
}
