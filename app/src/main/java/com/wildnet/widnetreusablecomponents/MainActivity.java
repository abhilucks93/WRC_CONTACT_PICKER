package com.wildnet.widnetreusablecomponents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.codinguser.android.contactpicker.ContactsPickerActivity;
import com.wildnet.wrcpicker.contactPicker.Enums;
import com.wildnet.wrcpicker.contactPicker.WrcContactPicker;
import com.wildnet.wrcpicker.contactPicker.bean.ContactDetailsBean;
import com.wildnet.wrcpicker.imagePicker.bean.ImageItemBean;
import com.wildnet.wrcpicker.imagePicker.ui.WrcImagePicker;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
       /* new WrcContactPicker(this)
                .pickWithoutUi()
                .getFields(Enums.Fields.NUMBER)
                .fetch(new WrcContactPicker.OnContactsPickCompleteListener() {
                    @Override
                    public void onContactsPickComplete(ArrayList<ContactDetailsBean> items) {
                        Toast.makeText(getApplicationContext(), items.toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
        startActivityForResult(new Intent(this, ContactsPickerActivity.class), 3007);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // See which child activity is calling us back.
        switch (requestCode) {
            case 3007:
                // This is the standard resultCode that is sent back if the
                // activity crashed or didn't doesn't supply an explicit result.
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "No phone number found", Toast.LENGTH_SHORT).show();
                } else {
                    String phoneNumber = (String) data.getExtras().get(ContactsPickerActivity.KEY_PHONE_NUMBER);
                    //Do what you wish to do with phoneNumber e.g.
                    //Toast.makeText(this, "Phone number found: " + phoneNumber , Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }
}
