package com.jeddah.invitationcards.utils;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.fragments.AddStickerFragment;
import com.jeddah.invitationcards.fragments.ElementsFragment;
import com.jeddah.invitationcards.fragments.GreetingCardTemplatesFragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static String readRawTextFile(Context context, int i) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
            return byteArrayOutputStream.toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public static GreetingCardTemplatesFragment getGreetingCardTemplatesFragment(FragmentActivity fragmentActivity) {
        return (GreetingCardTemplatesFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag("myFragmentTag_1");
    }

    public static GreetingCardTemplatesFragment addGreetingCardTemplatesFragment(FragmentActivity fragmentActivity, int i, boolean z, View view) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        GreetingCardTemplatesFragment greetingCardTemplatesFragment = (GreetingCardTemplatesFragment) supportFragmentManager.findFragmentByTag("myFragmentTag_1");
        if (greetingCardTemplatesFragment == null) {
            GreetingCardTemplatesFragment greetingCardTemplatesFragment2 = new GreetingCardTemplatesFragment();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(i, greetingCardTemplatesFragment2, "myFragmentTag_1");
            beginTransaction.commitAllowingStateLoss();
            fragmentActivity.findViewById(i).bringToFront();
            return greetingCardTemplatesFragment2;
        }
        fragmentActivity.getSupportFragmentManager().beginTransaction().show(greetingCardTemplatesFragment).commitAllowingStateLoss();
        return greetingCardTemplatesFragment;
    }

    public static ElementsFragment getElementsFragment(FragmentActivity fragmentActivity) {
        return (ElementsFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag("myFragmentTag_2");
    }

    public static ElementsFragment addElementsFragment(FragmentActivity fragmentActivity, int i, boolean z, View view) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        ElementsFragment elementsFragment = (ElementsFragment) supportFragmentManager.findFragmentByTag("myFragmentTag_2");
        if (elementsFragment == null) {
            ElementsFragment elementsFragment2 = new ElementsFragment();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(i, elementsFragment2, "myFragmentTag_2");
            beginTransaction.commitAllowingStateLoss();
            fragmentActivity.findViewById(i).bringToFront();
            return elementsFragment2;
        }
        fragmentActivity.getSupportFragmentManager().beginTransaction().show(elementsFragment).commitAllowingStateLoss();
        return elementsFragment;
    }

    public static AddStickerFragment getAddStickerFragment(FragmentActivity fragmentActivity) {
        return (AddStickerFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag("myFragmentTag_3");
    }

    public static AddStickerFragment addAddStickerFragment(FragmentActivity fragmentActivity, int i, boolean z, View view) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        AddStickerFragment addStickerFragment = (AddStickerFragment) supportFragmentManager.findFragmentByTag("myFragmentTag_3");
        if (addStickerFragment == null) {
            AddStickerFragment addStickerFragment2 = new AddStickerFragment();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.add(i, addStickerFragment2, "myFragmentTag_3");
            beginTransaction.commitAllowingStateLoss();
            fragmentActivity.findViewById(i).bringToFront();
            return addStickerFragment2;
        }
        fragmentActivity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).show(addStickerFragment).commitAllowingStateLoss();
        return addStickerFragment;
    }
}
