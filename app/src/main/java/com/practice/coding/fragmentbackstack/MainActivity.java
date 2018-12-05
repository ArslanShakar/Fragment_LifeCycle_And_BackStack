package com.practice.coding.fragmentbackstack;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private TextView tv;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvData);

        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addA(View view) {
        FragmentA fragment = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment, "A");
        transaction.addToBackStack("addA");
        transaction.commit();
    }

    public void btAdd_B(View view) {
        FragmentB fragment = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment, "B");
        transaction.addToBackStack("addB");
        transaction.commit();
    }

    public void Remove_A(View view) {
        FragmentA fragment = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment != null) {
            transaction.remove(fragment);
            transaction.addToBackStack("removeA");
            transaction.commit();
        } else {
            message("A is not added ..");
        }
    }

    public void btRemove_B(View view) {
        FragmentB fragment = (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment != null) {
            transaction.remove(fragment);
            transaction.addToBackStack("removeB");
            transaction.commit();
        } else {
            message("B is not added before..");
        }
    }

    public void ReplaceAWithB(View view) {

        FragmentB fragment = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, "B");
        transaction.addToBackStack("replaceAwithB");
        transaction.commit();

    }

    public void ReplaceBWithA(View view) {
        FragmentA fragment = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, "A");
        transaction.addToBackStack("replaceBwithA");
        transaction.commit();

    }

    public void attach_A(View view) {
        FragmentA fragment = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment != null) {
            transaction.attach(fragment);
            transaction.addToBackStack("attachA");
            transaction.commit();
        } else {
            message("Add fragment A First");
        }
    }

    public void back(View view) {
        //show the working of back button pressed when fragments are added to BackStack
        manager.popBackStack();
        //it just navigate to the previous fragment means the most top fragment that is added in the back stack
    }

    public void PopAddAInclusive(View view) {
        /* here the fragment we added to the back stack we give that string or tag..it remove all the fragments that most top
        of fragment A and as well as it remove the fragmentA from the back stack...
        */
        manager.popBackStack("addA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void PopAddA(View view) {
        //it just take us and show the fragment A...and all the top most fragments are removec from the back stack
        manager.popBackStack("addA", 0);
    }

    public void detachA(View view) {
        FragmentA fragment = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment != null) {
            transaction.detach(fragment);
            transaction.addToBackStack("detachA");
            transaction.commit();
        } else {
            message("Add fragment A First");
        }
    }

    public void hideA(View view) {
        FragmentA fragment = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment.isVisible() && fragment != null) {
            transaction.hide(fragment);
            transaction.addToBackStack("hideA");
            transaction.commit();
        } else {
            message("fragment A not added yet! ");
        }

    }

    public void showA(View view) {
        FragmentA fragment = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment.isHidden() && fragment!=null) {
            transaction.show(fragment);
            transaction.addToBackStack("showA");
            transaction.commit();
        } else {
            message("Fragment is shown already");
        }
    }

    public void message(String mesg) {
        Toast.makeText(this, mesg, Toast.LENGTH_SHORT).show();
    }

    //Implement the interface Method
    @Override
    public void onBackStackChanged() {
        tv.setText(tv.getText() + "\n");
        tv.setText(tv.getText() + "The Current Status of Back Stack is : \n\n");

        int count = manager.getBackStackEntryCount();
        for (int i = count - 1; i >= 0; i--) {
            FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(i);
            tv.setText(tv.getText() + "" + entry.getName() + "\n");
        }
        tv.setText(tv.getText() + "");
    }
}
