package com.wildnet.wrcpicker.contactPicker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.wildnet.wrcpicker.R;
import com.wildnet.wrcpicker.contactPicker.bean.ContactDetailsBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Contacts {

    public static Contacts mInstance;
    public Activity activity;
    ContactDetailsBean mBean;
    ArrayList<ContactDetailsBean> mBeans;


    public boolean getPhoneNumberAndType = false,
            getPhoto = false,
            getEmailAndType = false,
            getNote = false,
            getPostalAddress = false,
            getInstantMessenger = false, getOrganization = false;
    String[] PROJECTION = new String[]{
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.HAS_PHONE_NUMBER};
    private ProgressDialog pDialog;

    Cursor cur = null, cur2 = null, cur3 = null, cur4 = null;


    public static Contacts getInstance() {
        if (mInstance == null) {
            synchronized (Contacts.class) {
                if (mInstance == null) {
                    mInstance = new Contacts();
                }
            }
        }
        return mInstance;
    }

    ContentResolver cr;

    public ArrayList<ContactDetailsBean> fetchData() {

        cr = activity.getContentResolver();
        ContentProviderClient mCProviderClient = cr.acquireContentProviderClient(ContactsContract.Contacts.CONTENT_URI);


        try {
            cur = mCProviderClient.query(ContactsContract.Contacts.CONTENT_URI,
                    PROJECTION, null, null, null);
            cur2 = mCProviderClient.query(ContactsContract.Contacts.CONTENT_URI,
                    PROJECTION, null, null, null);;
            cur3 = mCProviderClient.query(ContactsContract.Contacts.CONTENT_URI,
                    PROJECTION, null, null, null);;
            cur4 = mCProviderClient.query(ContactsContract.Contacts.CONTENT_URI,
                    PROJECTION, null, null, null);;


            if (cur.getCount() > 0) {

          /*  int x = cur.getCount() / 100;
            int y = cur.getCount() % 100;

            for (int i = 0; i < x; i++) {
                new LoadContact(cur, i*100, (i+1)*100).execute();
            }
            new LoadContact(cur, x*100, (x*100)+y).execute();*/

                System.out.println("Time1 : " + System.currentTimeMillis());


                Thread timerThread = new Thread() {
                    public void run() {
                        for (int i = 0; i < 200; i++) {
                            cur.moveToPosition(i);

                            String id = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                            String name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                            if (getPhoneNumberAndType) getPhoneNumberAndType(cr, id);
                            if (getPhoto) getPhoto(cr, id);
                            if (getEmailAndType) getEmailAndType(cr, id);
                            if (getNote) getNote(cr, id);
                            if (getPostalAddress) getPostalAddress(cr, id);
                            if (getInstantMessenger) getInstantMessenger(cr, id);
                            if (getOrganization) getOrganization(cr, id);

                        }
                        System.out.println("Time2 : " + System.currentTimeMillis());
                    }
                };



                Thread timerThread2 = new Thread() {
                    public void run() {
                        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                        for (int i = 200; i < 400; i++) {
                            cur2.moveToPosition(i);


                            String id = cur2.getString(cur2.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));

                            String name = cur2.getString(cur2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                            if (getPhoneNumberAndType) getPhoneNumberAndType(cr, id);
                            if (getPhoto) getPhoto(cr, id);
                            if (getEmailAndType) getEmailAndType(cr, id);
                            if (getNote) getNote(cr, id);
                            if (getPostalAddress) getPostalAddress(cr, id);
                            if (getInstantMessenger) getInstantMessenger(cr, id);
                            if (getOrganization) getOrganization(cr, id);

                        }
                        System.out.println("Time2 : " + System.currentTimeMillis());

                    }
                };



                Thread timerThread3 = new Thread() {
                    public void run() {
                        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                        for (int i = 400; i < 600; i++) {
                            cur3.moveToPosition(i);


                            String id = cur3.getString(cur3.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));

                            String name = cur3.getString(cur3.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                            if (getPhoneNumberAndType) getPhoneNumberAndType(cr, id);
                            if (getPhoto) getPhoto(cr, id);
                            if (getEmailAndType) getEmailAndType(cr, id);
                            if (getNote) getNote(cr, id);
                            if (getPostalAddress) getPostalAddress(cr, id);
                            if (getInstantMessenger) getInstantMessenger(cr, id);
                            if (getOrganization) getOrganization(cr, id);
                        }
                        System.out.println("Time2 : " + System.currentTimeMillis());

                    }
                };



                Thread timerThread4 = new Thread() {
                    public void run() {
                        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                        for (int i = 600; i < cur4.getCount(); i++) {
                            cur4.moveToPosition(i);


                            String id = cur4.getString(cur4.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                            String name = cur4.getString(cur4.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                            if (getPhoneNumberAndType) getPhoneNumberAndType(cr, id);
                            if (getPhoto) getPhoto(cr, id);
                            if (getEmailAndType) getEmailAndType(cr, id);
                            if (getNote) getNote(cr, id);
                            if (getPostalAddress) getPostalAddress(cr, id);
                            if (getInstantMessenger) getInstantMessenger(cr, id);
                            if (getOrganization) getOrganization(cr, id);
                        }
                        System.out.println("Time2 : " + System.currentTimeMillis());

                    }
                };
                timerThread.start();
                timerThread2.start();
                timerThread3.start();
                timerThread4.start();


              /*  new LoadContact(cur, 0, 100).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoadContact(cur, 100, 200).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoadContact(cur, 200, 300).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoadContact(cur, 300, 400).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoadContact(cur, 400, 500).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoadContact(cur, 500, 607).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);*/


            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return mBeans;
    }


    class LoadContact extends AsyncTask<Void, Void, Void> {
        Cursor curs;
        int start, end;

        public LoadContact(Cursor curs, int start, int end) {
            super();
            this.curs = curs;
            this.start = start;
            this.end = end;
            // do stuff
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           /* pDialog = new ProgressDialog(activity);
            pDialog.setMessage("Loading...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();*/
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mBeans = new ArrayList<>();
            for (int i = start; i < end; i++) {
                curs.moveToPosition(i);
                mBean = new ContactDetailsBean();

                String id = curs.getString(curs.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                mBean.setId(id);
                String name = curs.getString(curs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                mBean.setName(name);
                if (getPhoneNumberAndType) getPhoneNumberAndType(cr, id);
                if (getPhoto) getPhoto(cr, id);
                if (getEmailAndType) getEmailAndType(cr, id);
                if (getNote) getNote(cr, id);
                if (getPostalAddress) getPostalAddress(cr, id);
                if (getInstantMessenger) getInstantMessenger(cr, id);
                if (getOrganization) getOrganization(cr, id);
                mBeans.add(mBean);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            //  pDialog.dismiss();
            System.out.println("Time2 : " + System.currentTimeMillis());

        }


    }


    public void fetchDataPhoneNoFilter() {

        ContentResolver cr = activity.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            mBeans = new ArrayList<>();
            while (cur.moveToNext()) {

                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

                    // if (getPhoneNumberAndType)
                    getPhoneNumberAndType(cr, id);
                    //  if (getPhoto)
                    getPhoto(cr, id);
                    //  if (getEmailAndType)
                    getEmailAndType(cr, id);
                    //  if (getNote)
                    getNote(cr, id);
                    // if (getPostalAddress)
                    getPostalAddress(cr, id);
                    // if (getInstantMessenger)
                    getInstantMessenger(cr, id);
                    //  if (getOrganization)
                    getOrganization(cr, id);
                }
            }
        }
    }

    public void fetchDataEmailFilter() {

        ContentResolver cr = activity.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            mBeans = new ArrayList<>();
            while (cur.moveToNext()) {

                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (getEmailAndType(cr, id)) {
                    // if (getPhoneNumberAndType)
                    getPhoneNumberAndType(cr, id);
                    //  if (getPhoto)
                    getPhoto(cr, id);
                    //  if (getNote)
                    getNote(cr, id);
                    // if (getPostalAddress)
                    getPostalAddress(cr, id);
                    //  if (getInstantMessenger)
                    getInstantMessenger(cr, id);
                    // if (getOrganization)
                    getOrganization(cr, id);
                }
            }
        }
    }

    public void fetchDataAddressFilter() {

        ContentResolver cr = activity.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            mBeans = new ArrayList<>();
            while (cur.moveToNext()) {

                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (getPostalAddress(cr, id)) {
                    //  if (getPhoneNumberAndType)
                    getPhoneNumberAndType(cr, id);
                    //  if (getPhoto)
                    getPhoto(cr, id);
                    //   if (getEmailAndType)
                    getEmailAndType(cr, id);
                    //   if (getNote)
                    getNote(cr, id);
                    //  if (getInstantMessenger)
                    getInstantMessenger(cr, id);
                    // if (getOrganization)
                    getOrganization(cr, id);
                }
            }
        }
    }

    public void updateRequirements(boolean getPhoneNumberAndType,
                                   boolean getPhoto,
                                   boolean getEmailAndType,
                                   boolean getNote,
                                   boolean getPostalAddress,
                                   boolean getInstantMessenger,
                                   boolean getOrganization) {

        this.getPhoneNumberAndType = getPhoneNumberAndType;
        this.getPhoto = getPhoto;
        this.getEmailAndType = getEmailAndType;
        this.getNote = getNote;
        this.getPostalAddress = getPostalAddress;
        this.getInstantMessenger = getInstantMessenger;
        this.getOrganization = getOrganization;
    }

    public boolean getPhoneNumberAndType(ContentResolver cr,
                                         String id) {
        String Phone_Projection[] = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
        boolean mBoolean = false;
        // get the phone number
        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, Phone_Projection,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                new String[]{id}, null);
        final int numberIndex = pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        ArrayList<String> mList = new ArrayList<>();
        while (pCur.moveToNext()) {
            String phone = pCur.getString(numberIndex);
            mList.add(phone);
            //  System.out.println("phone" + phone);
            mBoolean = true;
        }
        pCur.close();
        // mBean.setNumbers(mList);
        return mBoolean;
    }

    public static boolean getPhoto(ContentResolver cr,
                                   String id) {

        boolean mBoolean = false;
        // get Photo
        Bitmap photo = null;
        try {
            InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(cr,
                    ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, new Long(id)));
            if (inputStream != null) {
                photo = BitmapFactory.decodeStream(inputStream);
                mBoolean = true;
            }
            assert inputStream != null;
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mBoolean;
    }

    public boolean getEmailAndType(ContentResolver cr,
                                   String id) {
        ArrayList<String> mList = new ArrayList<>();
        ArrayList<String> mList2 = new ArrayList<>();
        boolean mBoolean = false;
        // get email and type
        Cursor emailCur = cr.query(
                ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                new String[]{id}, null);

        while (emailCur.moveToNext()) {
            // This would allow you get several email addresses
            // if the email addresses were stored in an array
            String email = emailCur.getString(
                    emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
            mList.add(email);
            String emailType = emailCur.getString(
                    emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE));
            mList2.add(emailType);
            //System.out.println("Email " + email + " Email Type : " + emailType);
            mBoolean = true;
        }
        emailCur.close();
        mBean.setEmails(mList);
        mBean.setEmailTypes(mList2);
        return mBoolean;
    }

    public boolean getNote(ContentResolver cr,
                           String id) {

        boolean mBoolean = false;
        // GetFields note.......
        String noteWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] noteWhereParams = new String[]{id,
                ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE};
        Cursor noteCur = cr.query(ContactsContract.Data.CONTENT_URI, null, noteWhere, noteWhereParams, null);
        if (noteCur.moveToFirst()) {
            String note = noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE));
            mBean.setNote(note);
            //System.out.println("Note " + note);
            mBoolean = true;
        }
        noteCur.close();
        return mBoolean;
    }

    public boolean getPostalAddress(ContentResolver cr,
                                    String id) {

        boolean mBoolean = false;
        //GetFields Postal Address....
        String addrWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] addrWhereParams = new String[]{id,
                ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE};
        Cursor addrCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, addrWhere, addrWhereParams, null);
        ArrayList<String> mList = new ArrayList<>();
        while (addrCur.moveToNext()) {
            String poBox = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX));
            String street = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
            String city = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
            String state = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION));
            String postalCode = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE));
            String country = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));
            String type = addrCur.getString(
                    addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE));
            // Do something with these....
            // System.out.println("address");
            mList.add("poBox: " + "_street: " + "_city: " + "_state: " + "_postalCode: " + "_country: " + "_type: ");
            mBoolean = true;
        }
        addrCur.close();
        mBean.setAddress(mList);
        return mBoolean;
    }

    public boolean getInstantMessenger(ContentResolver cr,
                                       String id) {

        boolean mBoolean = false;
        // GetFields Instant Messenger.........
        String imWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] imWhereParams = new String[]{id,
                ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE};
        Cursor imCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, imWhere, imWhereParams, null);
        if (imCur.moveToFirst()) {
            String imName = imCur.getString(
                    imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.DATA));
            mBean.setMessenger(imName);
            String imType;
            imType = imCur.getString(
                    imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.TYPE));
            mBean.setMessengerType(imType);
            mBoolean = true;
        }
        imCur.close();
        return mBoolean;
    }

    public boolean getOrganization(ContentResolver cr,
                                   String id) {

        boolean mBoolean = false;
        // GetFields Organizations.........
        String orgWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
        String[] orgWhereParams = new String[]{id,
                ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE};
        Cursor orgCur = cr.query(ContactsContract.Data.CONTENT_URI,
                null, orgWhere, orgWhereParams, null);
        if (orgCur.moveToFirst()) {
            String orgName = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
            mBean.setOrganiztion(orgName);
            String title = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE));
            mBean.setOrganiztionTitle(title);
            mBoolean = true;
        }
        orgCur.close();
        return mBoolean;
    }


}