package com.example.service;

public interface AgencyInterface {

    void addAgency(int id,String agencyName) throws InterruptedException;

    boolean readLogo(String logoFile) throws InterruptedException;

}
