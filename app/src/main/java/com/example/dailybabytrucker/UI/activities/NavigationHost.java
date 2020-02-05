package com.example.dailybabytrucker.UI.activities;

import androidx.fragment.app.Fragment;

interface NavigationHost {

    void navigateTo (Fragment fragment, boolean addToBackstack);
}
