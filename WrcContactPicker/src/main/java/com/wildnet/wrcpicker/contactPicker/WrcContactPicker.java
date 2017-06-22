package com.wildnet.wrcpicker.contactPicker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.wildnet.wrcpicker.contactPicker.bean.ContactDetailsBean;

import java.util.ArrayList;

/**
 * Created by abhishekagarwal on 9/22/16.
 */

public class WrcContactPicker {

    public static WrcContactPicker mInstancePicker;
    protected Activity mActivity;
    protected static Contacts mContacts;
    protected static boolean showUi = true;
    protected static boolean getFields = true;
    protected static boolean filter = false;
    protected static Enums.Filter filterValue;
    protected static Enums.MatchFilter matchFilterValue;
    protected static boolean fetchSingleContact = true;
    protected static boolean fetchMultipleleContact = false;
    private ProgressDialog pDialog;

    WrcContactPicker contactPicker;

    private WrcContactPicker() {

    }

    public WrcContactPicker(Activity mActivity) {
        contactPicker = getInstance();
        contactPicker.mActivity = mActivity;
        mContacts = Contacts.getInstance();
        mContacts.activity = mActivity;
    }

    public static WrcContactPicker getInstance() {
        if (mInstancePicker == null) {
            synchronized (WrcContactPicker.class) {
                if (mInstancePicker == null) {
                    mInstancePicker = new WrcContactPicker();
                }
            }
        }
        return mInstancePicker;
    }

    public void updateFields(ArrayList<Enums.Fields> mArrayList) {
        getFields = true;
        for (Enums.Fields field : mArrayList) {
            switch (field) {
                case NUMBER:
                    mContacts.getPhoneNumberAndType = true;
                    break;
                case EMAIL:
                    mContacts.getEmailAndType = true;
                    break;
                case ADDRESS:
                    mContacts.getPostalAddress = true;
                    break;
                case PICTURE:
                    mContacts.getPhoto = true;
                    break;
                case NOTE:
                    mContacts.getNote = true;
                    break;
                case MESSENGER:
                    mContacts.getInstantMessenger = true;
                    break;
                case ORGANIZATION:
                    mContacts.getOrganization = true;
                    break;
            }
        }
    }

    public void fetchContacts(OnContactsPickCompleteListener l) {
        setOnContactsPickCompleteListener(l);

        if (getFields) {

            mContacts.fetchData();

        } else if (filter) {
            switch (filterValue) {
                case EMAIL:
                    mContacts.fetchDataEmailFilter();
                    break;
                case ADDRESS:
                    mContacts.fetchDataAddressFilter();
                    break;
                case NUMBER:
                    mContacts.fetchDataPhoneNoFilter();
                    break;
            }
        }

    }



    public OnContactsPickCompleteListener mOnContactsPickCompleteListener;

    protected void setOnContactsPickCompleteListener(OnContactsPickCompleteListener l) {
        if (l != null) {
            this.mOnContactsPickCompleteListener = l;
            //  Log.i(TAG, "=====setOnImagePickCompleteListener:" + l.getClass().toString());
        }
    }

    protected void notifyOnImagePickComplete(ArrayList<ContactDetailsBean> list) {
        if (mOnContactsPickCompleteListener != null) {
            // List<ImageItemBean> list = getSelectedImages();
            //  Log.i(TAG, "=====notify mOnImagePickCompleteListener:selected size=" + list.size());
            mOnContactsPickCompleteListener.onContactsPickComplete(list);
        }
    }

    public interface OnContactsPickCompleteListener {
        void onContactsPickComplete(ArrayList<ContactDetailsBean> items);
    }

    public PickWithUi pickWithUi() {
        showUi = true;
        return new PickWithUi();
    }

    public PickWithoutUi pickWithoutUi() {
        showUi = false;
        return new PickWithoutUi();
    }
}
