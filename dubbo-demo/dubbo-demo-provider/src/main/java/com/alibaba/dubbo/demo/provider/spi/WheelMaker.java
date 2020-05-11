package com.alibaba.dubbo.demo.provider.spi;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("car")
public interface WheelMaker {

    @Adaptive("marker")
    void make(URL url);

}
