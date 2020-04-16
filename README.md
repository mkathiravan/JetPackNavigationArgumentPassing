# JetPackNavigationArgumentPassing

Navigation Graph:

This is a resource that contains all navigation-related information in one centralized location. This includes all the places in your app, known as destinations, and possible paths a user could take through your app.

In the nav_graph.xml file we have to configure the arguments like this

     <fragment
      android:id="@+id/profile_destination"
      android:name="com.navigation.example.fragments.ProfileFragment"
      android:label="Home"
      tools:layout="@layout/fragment_profile">

    <argument
        android:name="profile_name"
        app:argType="string"
        app:nullable="true" />
    <argument
        android:name="profile_email"
        app:argType="string"
        app:nullable="true" />
    <argument
        android:name="profile_city"
        app:argType="string"
        app:nullable="true" />


  </fragment>




While passing the arguments between fragment to fragment we can use the following snippet in the HomeFragment

        Button viewProfile = view.findViewById(R.id.buttonViewProfile);
        viewProfile.setOnClickListener(new View.OnClickListener() {
         @Override public void onClick(View view) {
        // find navigation

        HomeFragmentDirections.NextAction nextAction = HomeFragmentDirections.nextAction("Kathiravan","mkathiravan@gmail.com","Bangalore");

          NavController navController = Navigation.findNavController(view);
          navController.navigate(nextAction);


      }
    });
    
In the ProfileArgument while receiving the arguments from HomeFragment we have to use the following snippet:

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
