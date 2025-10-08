package ar.edu.ifts18.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OnboardingStep2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onboarding_step2, container, false);

        Button btnStart = view.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(view1 -> {
            ((OnboardingActivity) requireActivity()).finalizarOnboarding();
        });

        return view;
    }
}
