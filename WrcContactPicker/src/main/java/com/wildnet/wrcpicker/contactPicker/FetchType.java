package com.wildnet.wrcpicker.contactPicker;

/**
 * Created by abhishekagarwal on 9/22/16.
 */
public class FetchType {

    public FetchSingleContact fetchSingleContact() {
        WrcContactPicker.fetchSingleContact = true;
        return new FetchSingleContact();
    }

    public FetchMultipleContact fetchMultipleContacts() {
        WrcContactPicker.fetchMultipleleContact = true;
        return new FetchMultipleContact();
    }

    public void build() {

    }


}
