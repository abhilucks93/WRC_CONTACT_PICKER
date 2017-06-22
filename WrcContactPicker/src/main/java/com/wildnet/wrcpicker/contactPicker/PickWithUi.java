package com.wildnet.wrcpicker.contactPicker;

import java.util.ArrayList;

/**
 * Created by abhishekagarwal on 9/22/16.
 */
public class PickWithUi {

    private ArrayList<Enums.Fields> getFieldsArray;
WrcContactPicker contactPicker = WrcContactPicker.getInstance();
    public FetchType getFields(
            Enums.Fields NUMBER) {

        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL
            , Enums.Fields ADDRESS) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        getFieldsArray.add(ADDRESS);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL
            , Enums.Fields ADDRESS
            , Enums.Fields NOTE) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        getFieldsArray.add(ADDRESS);
        getFieldsArray.add(NOTE);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL
            , Enums.Fields ADDRESS
            , Enums.Fields NOTE
            , Enums.Fields MESSENGER) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        getFieldsArray.add(ADDRESS);
        getFieldsArray.add(NOTE);
        getFieldsArray.add(MESSENGER);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }

    public FetchType getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL
            , Enums.Fields ADDRESS
            , Enums.Fields NOTE
            , Enums.Fields MESSENGER
            , Enums.Fields ORGANIZATION) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        getFieldsArray.add(ADDRESS);
        getFieldsArray.add(NOTE);
        getFieldsArray.add(MESSENGER);
        getFieldsArray.add(ORGANIZATION);
        contactPicker.updateFields(getFieldsArray);
        return new FetchType();
    }


    public FetchType contains(Enums.Filter filter) {
        WrcContactPicker.filter = true;
        WrcContactPicker.filterValue = filter;
        return new FetchType();
    }

    public void build() {

    }

}
