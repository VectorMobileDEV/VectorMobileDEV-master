package com.example.tibi.whatsinmycity;

import android.support.annotation.FloatRange;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Tibi on 24.11.2018.
 */

public class Info_User {

        private String Id;
        private String AspNetUserId;
        private String FullName;
        private float Latitude;
        private float Longitude;
        private int Radius;
        private int Age;
        private int Gender;
        private String ProfilePicture;
        Collection<String> Issues;
        private Boolean Succes;
        private Integer StatusCode;

        public Collection<String> getIssues() {
                return Issues;
        }

        public void setIssues(Collection<String> issues) {
                Issues = issues;
        }

        public Boolean getSucces() {
                return Succes;
        }

        public void setSucces(Boolean succes) {
                Succes = succes;
        }

        public Integer getStatusCode() {
                return StatusCode;
        }

        public void setStatusCode(Integer statusCode) {
                StatusCode = statusCode;
        }

        public String getId() {
                return Id;
        }

        public void setId(String Id) {
                this.Id = Id;
        }

        public String getAspNetUserId() {
                return AspNetUserId;
        }

        public void setAspNetUserId(String aspNetUserId) {
                AspNetUserId = aspNetUserId;
        }

        public String getFullName() {
                return FullName;
        }

        public void setFullName(String fullName) {
                FullName = fullName;
        }

        public float getLatitude() {
                return Latitude;
        }

        public void setLatitude(float latitude) {
                Latitude = latitude;
        }

        public float getLongitude() {
                return Longitude;
        }

        public void setLongitude(float longitude) {
                Longitude = longitude;
        }

        public int getRadius() {
                return Radius;
        }

        public void setRadius(int radius) {
                Radius = radius;
        }

        public int getAge() {
                return Age;
        }

        public void setAge(int age) {
                Age = age;
        }

        public int getGender() {
                return Gender;
        }

        public void setGender(int gender) {
                Gender = gender;
        }

        public String getProfilePicture() {
                return ProfilePicture;
        }

        public void setProfilePicture(String profilePicture) {
                ProfilePicture = profilePicture;
        }
        Info_User(){

        }
}
