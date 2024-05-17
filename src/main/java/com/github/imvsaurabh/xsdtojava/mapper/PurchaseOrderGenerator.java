package com.github.imvsaurabh.xsdtojava.mapper;

import com.github.imvsaurabh.purchaseorder.ObjectFactory;
import com.github.imvsaurabh.purchaseorder.PurchaseOrder;
import com.github.imvsaurabh.purchaseorder.PurchaseOrderType;
import com.github.imvsaurabh.purchaseorder.USAddress;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

public class PurchaseOrderGenerator {

    public static PurchaseOrder generatePurchaseOrderSample() {
        ObjectFactory factory = new ObjectFactory();
        PurchaseOrderType purchaseOrderType = null;
        try {
            USAddress usAddress = factory.createUSAddress()
                    .withCity("Aaronsburg")
                    .withCountry("United States")
                    .withName("Mr. John Edward Doe")
                    .withState("Pennsylvania")
                    .withZip(BigInteger.valueOf(16820))
                    .withStreet("118 West Aaron Square");

            purchaseOrderType = factory.createPurchaseOrderType()
                    .withBillTo(usAddress)
                    .withShipTo(List.of(usAddress))
                    .withOrderDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(Instant.now().toString()));
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        return factory.createPurchaseOrder().withPurchaseOrderType(purchaseOrderType);
    }
}
