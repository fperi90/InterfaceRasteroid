package com.example.intefacerasteroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;


public class SpaceCraftSelection extends Fragment {
    private EditText editText;
    private Button sendButton;
    private LiveData<String> IpNumber;
    private MyViewModel viewModel;

    public SpaceCraftSelection() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        View view = inflater.inflate(R.layout.fragment_space_craft_selection, container, false);
        IpNumber = viewModel.getIpNumber();
        editText = (EditText) view.findViewById(R.id.editTextIp);
        sendButton = (Button) view.findViewById(R.id.loginButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IpNumber.getValue().toString().equals(editText.getText().toString())) {
                    Toast.makeText(getActivity().getBaseContext(), "Valid ip",
                            Toast.LENGTH_SHORT).show();
                    viewModel.getUser().observe(getViewLifecycleOwner(), user -> {
                        user.setIpNumber(Integer.parseInt(editText.getText().toString()));
                    });
                } else {
                    Toast.makeText(getActivity().getBaseContext(), "Not Valid" +
                                    " ip",
                            Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getActivity().getBaseContext(), "Pulsado " +
                                "boton" + " send",
                        Toast.LENGTH_SHORT).
                        show();
            }
        });
        return view;
    }
}