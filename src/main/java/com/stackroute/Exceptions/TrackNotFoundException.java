    package com.stackroute.Exceptions;

    public class TrackNotFoundException extends Exception{

        public String message;


        public TrackNotFoundException() {
        }

        public TrackNotFoundException(String message) {
            super(message);
            this.message = message;
        }
    }
