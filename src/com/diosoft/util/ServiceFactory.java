package com.diosoft.util;

import com.diosoft.helper.ArrayHelperImpl;
import com.diosoft.helper.CollectionHelperImpl;
import com.diosoft.service.ArrayServiceImpl;
import com.diosoft.service.CollectionServiceImpl;

public class ServiceFactory {

    public static class ArrayServiceFactory{
        public static ArrayServiceImpl create() {
            ArrayHelperImpl ah = new ArrayHelperImpl();
            return new ArrayServiceImpl(ah);
        }
    }
    public static class CollectionServiceFactory{
        public static CollectionServiceImpl create() {
            CollectionHelperImpl ch = new CollectionHelperImpl();
            return new CollectionServiceImpl(ch);
        }
    }

}
