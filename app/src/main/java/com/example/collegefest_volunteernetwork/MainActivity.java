package com.example.collegefest_volunteernetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.collegefest_volunteernetwork.ui.CollegeinformationFragment;
import com.example.collegefest_volunteernetwork.ui.CollegeListFragment;
import com.example.collegefest_volunteernetwork.ui.StartPageFragment;
import com.example.collegefest_volunteernetwork.ui.VolunteerRegistrationFragment;
import com.example.collegefest_volunteernetwork.ui.VoluteerLogin;
import com.example.collegefest_volunteernetwork.ui.WelcomeFragment;

public class MainActivity extends AppCompatActivity implements
        StartPageFragment.collegeVlounteerTransactionListener,
        CollegeinformationFragment.collegeCompleteListener,
        VoluteerLogin.VolunteerLoginSuccessfulListener,
        VolunteerRegistrationFragment.RegistrationSuccessfulListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        StartPageFragment startPageFragment = new StartPageFragment();
        ft.add(R.id.fragmentContainer, startPageFragment);
        ft.commit();
    }

    @Override
    public void goToCollegeInfoPage() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        CollegeinformationFragment informationFragment = new CollegeinformationFragment();
        ft.replace(R.id.fragmentContainer, informationFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void goToVolunterLogin() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        VoluteerLogin voluteerLogin = new VoluteerLogin();
        ft.replace(R.id.fragmentContainer, voluteerLogin);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void collegeComplete() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        ft.replace(R.id.fragmentContainer, welcomeFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void loginSuccessful() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        CollegeListFragment listFragment = new CollegeListFragment();
        ft.replace(R.id.fragmentContainer, listFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void goToRegistration() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        VolunteerRegistrationFragment registrationFragment = new VolunteerRegistrationFragment();
        ft.replace(R.id.fragmentContainer, registrationFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void registrationSuccess() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        VoluteerLogin voluteerLogin = new VoluteerLogin();
        ft.replace(R.id.fragmentContainer, voluteerLogin);
        ft.addToBackStack(null);
        ft.commit();
    }
}
