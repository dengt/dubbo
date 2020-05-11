package com.alibaba.dubbo.demo.provider.spi;


import com.alibaba.dubbo.common.URL;

public class ReceMarker implements WheelMaker {
    @Override
    public void make(URL url) {
        System.out.println("ReceMarker marker");
    }
}
