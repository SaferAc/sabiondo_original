
package com.saferapps.sabiondo.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saferapps.sabiondo.R;

import java.util.Objects;


public class InstructionFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_instruction, container, false);

        RelativeLayout relativeLayout = view.findViewById(R.id.ok_layout);

        relativeLayout.setOnClickListener(v -> Objects.requireNonNull(getActivity()).onBackPressed());






        return view;
    }

}
