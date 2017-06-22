package com.wildnet.wrcpicker.contactPicker.bean;

import java.util.ArrayList;

/**
 * Created by abhishekagarwal on 9/23/16.
 */

public class ContactDetailsBean {

    private String id = "";
    private String name = "";
    private String organiztion = "";
    private String organiztionTitle = "";
    private String messenger = "";
    private String messengerType = "";
    private String note = "";
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> emailTypes = new ArrayList<>();
    private ArrayList<String> address = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganiztion() {
        return organiztion;
    }

    public void setOrganiztion(String organiztion) {
        this.organiztion = organiztion;
    }

    public String getOrganiztionTitle() {
        return organiztionTitle;
    }

    public void setOrganiztionTitle(String organiztionTitle) {
        this.organiztionTitle = organiztionTitle;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getMessengerType() {
        return messengerType;
    }

    public void setMessengerType(String messengerType) {
        this.messengerType = messengerType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getEmailTypes() {
        return emailTypes;
    }

    public void setEmailTypes(ArrayList<String> emailTypes) {
        this.emailTypes = emailTypes;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }
}
