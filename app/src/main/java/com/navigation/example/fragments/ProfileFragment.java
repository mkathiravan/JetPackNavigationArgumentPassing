package com.navigation.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.navigation.example.R;

/**
 * A ProfileFragment {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_profile, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    TextView profile_info = view.findViewById(R.id.tv_profile_info);

    ProfileFragmentArgs args = ProfileFragmentArgs.fromBundle(getArguments());

    profile_info.setText(getString(R.string.profile_info)
            + args.getProfileName()
            + "\n" +
            " Email : "
            + args.getProfileEmail()
            + "\n" +
            " City :  "
            + args.getProfileCity());
  }
}
