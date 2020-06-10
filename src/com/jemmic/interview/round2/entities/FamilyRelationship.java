package com.jemmic.interview.round2.entities;

public enum FamilyRelationship {
    PARENT ("parent"),
    GRANDPARENT ("grandparent"),
    SONorDAUGHTER ("son/daughter"),
    AUNTorUNCLE ("aunt/uncle");

    public final String relationship;

    private FamilyRelationship(String s) {
        this.relationship = s;
    }
}
