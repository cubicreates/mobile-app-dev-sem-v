package com.example.sem5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ReceiverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        TextView tvOutput = view.findViewById(R.id.tvFragOutput);

        if (getArguments() != null) {
            String msg = getArguments().getString("msg", "");
            tvOutput.setText("Received: " + msg);
        }

        return view;
    }
}

