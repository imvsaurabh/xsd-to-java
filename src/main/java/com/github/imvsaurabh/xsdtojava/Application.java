package com.github.imvsaurabh.xsdtojava;

import com.github.imvsaurabh.purchaseorder.PurchaseOrder;
import com.github.imvsaurabh.xsdtojava.mapper.PurchaseOrderGenerator;
import com.github.imvsaurabh.xsdtojava.utility.XMLGregorianCalendarAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.XMLGregorianCalendar;

public class Application {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarAdapter())
                .setPrettyPrinting()
                .create();

        PurchaseOrder purchaseOrder = PurchaseOrderGenerator.generatePurchaseOrderSample();
        String purchaseOrderJson = gson.toJsonTree(purchaseOrder).toString();
        System.out.println("\n********** PurchaseOrder Object **********\n" + purchaseOrder);
        System.out.println("\n********** PurchaseOrder Json String **********\n" + purchaseOrderJson);
    }
}
