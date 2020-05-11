package org.test.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.demo.provider.spi.WheelMaker;

/**
 * package com.alibaba.dubbo.demo.provider.spi;
 * import com.alibaba.dubbo.common.extension.ExtensionLoader;
 * public class WheelMaker$Adaptive implements com.alibaba.dubbo.demo.provider.spi.WheelMaker {
 * public void make(com.alibaba.dubbo.common.URL arg0) {
 * if (arg0 == null) throw new IllegalArgumentException("url == null");
 * com.alibaba.dubbo.common.URL url = arg0;
 * String extName = url.getParameter("marker", "car");
 * if(extName == null) throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.demo.provider.spi.WheelMaker) name from url(" + url.toString() + ") use keys([marker])");
 * com.alibaba.dubbo.demo.provider.spi.WheelMaker extension = (com.alibaba.dubbo.demo.provider.spi.WheelMaker)ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.demo.provider.spi.WheelMaker.class).getExtension(extName);extension.make(arg0);
 * }
 */
public class TestMarker {

    public static void main(String[] args) {
        URL url = new URL("tom", "", 2222);
        WheelMaker wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getDefaultExtension();
        wheelMaker.make(url);

        System.out.println("=====");
        wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getExtension("rece");
        wheelMaker.make(url);


        System.out.println("=====");
        url = url.addParameter("marker", "rece");
        wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getAdaptiveExtension();
        System.out.println(url.getParameter("marker", "car"));
        wheelMaker.make(url);
    }

}
