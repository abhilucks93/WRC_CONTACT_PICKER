package com.wildnet.wrcpicker.contactPicker;

import java.util.ArrayList;

/**
 * Created by abhishekagarwal on 9/22/16.
 */
public class PickWithoutUi {
WrcContactPicker contactPicker = WrcContactPicker.getInstance();
    private ArrayList<Enums.Fields> getFieldsArray;

    public GetFields getFields(
            Enums.Fields NUMBER) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        contactPicker.updateFields(getFieldsArray);
        return new GetFields();
    }

    public GetFields getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        contactPicker.updateFields(getFieldsArray);
        return new GetFields();
    }

    public GetFields getFields(
            Enums.Fields NUMBER
            , Enums.Fields PICTURE
            , Enums.Fields EMAIL) {
        getFieldsArray = new ArrayList<>();
        getFieldsArray.add(NUMBER);
        getFieldsArray.add(PICTURE);
        getFieldsArray.add(EMAIL);
        contactPicker.updateFields(getFieldsArray);
        return new GetFields();
    }

    public GetFields getFields(
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
        return new GetFields();
    }

    public GetFields getFields(
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
        return new GetFields();
    }

    public GetFields getFields(
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
        return new GetFields();
    }

    public GetFields getFields(
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
        return new GetFields();
    }

    public ContainsField contains(Enums.Filter filter) {
        WrcContactPicker.filter = true;
        WrcContactPicker.filterValue = filter;
        return new ContainsField();
    }

    public KeyMatch where(Enums.MatchFilter matchFilter) {
        WrcContactPicker.matchFilterValue = matchFilter;
        return new KeyMatch();
    }

    public void build() {

    }
}
