package com.navigation.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.navigation.example.R;

/**
 * A HomeFragment {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Button viewProfile = view.findViewById(R.id.buttonViewProfile);
    viewProfile.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        // find navigation

        HomeFragmentDirections.NextAction nextAction = HomeFragmentDirections.nextAction("Kathiravan","mkathiravan@gmail.com","Bangalore");

          NavController navController = Navigation.findNavController(view);
          navController.navigate(nextAction);


      }
    });
  }
}
