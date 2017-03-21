package com.example.mengsroinheng.practice1.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mengsroinheng.practice1.R;

/**
 * Created by mengsroinheng on 7/3/17.
 */

public class AssignmentFragment extends Fragment {

    private static String title= "Assignment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View contentView= inflater.inflate(R.layout.fragment_assignment, container,false);
        return contentView;
    }

}
