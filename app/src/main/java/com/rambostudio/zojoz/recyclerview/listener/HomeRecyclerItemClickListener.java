package com.rambostudio.zojoz.recyclerview.listener;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rambo on 30/3/2560.
 */

public interface HomeRecyclerItemClickListener {
    void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent);

}
