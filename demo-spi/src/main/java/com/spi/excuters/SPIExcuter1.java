package com.spi.excuters;

import com.spi.interfaces.SPIServiceInface;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhouj
 * @date 2020/4/25 20:12
 */
public class SPIExcuter1 {
    public static void main(String[] args) {
        Iterator<SPIServiceInface> providers = Service.providers(SPIServiceInface.class);
        while (providers.hasNext()) {
            SPIServiceInface next = providers.next();
            next.spiDo();
        }
        ServiceLoader<SPIServiceInface> load = ServiceLoader.load(SPIServiceInface.class);
        Iterator<SPIServiceInface> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPIServiceInface next = iterator.next();
            next.spiDo();
        }
    }
}
