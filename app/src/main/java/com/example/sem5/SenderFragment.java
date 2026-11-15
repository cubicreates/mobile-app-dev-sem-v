package com.example.sem5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SenderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sender, container, false);

        EditText etInput = view.findViewById(R.id.etFragInput);
        Button btnSend = view.findViewById(R.id.btnFragSend);

        btnSend.setOnClickListener(v -> {
            String msg = etInput.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("msg", msg);

            ReceiverFragment receiver = new ReceiverFragment();
            receiver.setArguments(bundle);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.receiverContainer, receiver)
                    .commit();
        });

        return view;
    }
}

