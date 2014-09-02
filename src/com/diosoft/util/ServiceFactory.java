package com.diosoft.util;


import com.diosoft.impl.ArrayHelper;
import com.diosoft.impl.CollectionHelper;
import com.diosoft.service.ArrayService;
import com.diosoft.service.CollectionService;

public class ServiceFactory {

    public static class ArrayServiceFactory{
        public static ArrayService create() {
            ArrayHelper ah = new ArrayHelper();
            return new ArrayService(ah);
        }
    }
    public static class CollectionServiceFactory{
        public static CollectionService create() {
            CollectionHelper ch = new CollectionHelper();
            return new CollectionService(ch);
        }
    }

}
