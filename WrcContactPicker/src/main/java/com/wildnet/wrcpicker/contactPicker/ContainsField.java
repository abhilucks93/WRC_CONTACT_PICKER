package com.wildnet.wrcpicker.contactPicker;

/**
 * Created by abhishekagarwal on 9/22/16.
 */
public class ContainsField {
    WrcContactPicker contactPicker = WrcContactPicker.getInstance();

    public void fetch(WrcContactPicker.OnContactsPickCompleteListener l) {
        contactPicker.fetchContacts(l);
    }
}
