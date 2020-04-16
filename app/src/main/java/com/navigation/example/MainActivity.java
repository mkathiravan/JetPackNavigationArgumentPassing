package com.navigation.example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  private BottomNavigationView bottomNavigationView;
  private NavController navController;
  private DrawerLayout drawerLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    bottomNavigationView = findViewById(R.id.bottom_nav);
    drawerLayout = findViewById(R.id.drawer_layout);

    setUpBottomNav(navController);
    setUpSideNav(navController);
    setUpActionBar(navController);
  }

  private void setUpBottomNav(NavController navController) {
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
  }

  private void setUpSideNav(NavController navController) {
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
  }

  private void setUpActionBar(NavController navController) {
    NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean navigated = NavigationUI.onNavDestinationSelected(item, navController);
    return navigated || super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onSupportNavigateUp() {
    return NavigationUI.navigateUp(
        Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
  }
}
