package com.hhp.design.staticcreate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huanghaopeng on 16/11/11.
 */
public class Services {
    private Services(){

    }

    private static final Map<String,Provider> providers
                = new ConcurrentHashMap<String,Provider>();

    public static final String  DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name , Provider provider){
        providers.put(name, provider);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if(p == null)
            throw  new IllegalArgumentException(
                    "No provider registed with name : " + name
            );
        return p.newService();
    }
}
