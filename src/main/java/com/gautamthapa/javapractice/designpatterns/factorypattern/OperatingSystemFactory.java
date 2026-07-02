package com.gautamthapa.javapractice.designpatterns.factorypattern;

public class OperatingSystemFactory {
    public OS getInstance(String osType) {
        if ("ANDROID".equalsIgnoreCase(osType)) {
            return new Android();
        } else if ("IOS".equalsIgnoreCase(osType)) {
            return new IOS();
        } else {
            return new Windows();
        }
    }
}
