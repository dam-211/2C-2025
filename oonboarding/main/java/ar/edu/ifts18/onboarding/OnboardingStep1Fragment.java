package ar.edu.ifts18.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OnboardingStep1Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_onboarding_setp1, container, false);

        Button btnSkip = view.findViewById(R.id.btnSkip);
        Button btnNext = view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v->{

            ((OnboardingActivity) requireActivity()).onBoardingPaso2();

        });


        btnSkip.setOnClickListener(v->{
            ((OnboardingActivity) requireActivity()).finalizarOnboarding();

        });
        return view;
    }
}
