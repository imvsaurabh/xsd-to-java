package com.github.imvsaurabh.xsdtojava.utility;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;

public class XMLGregorianCalendarAdapter extends TypeAdapter<XMLGregorianCalendar> {

    @Override
    public void write(JsonWriter out, XMLGregorianCalendar value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toXMLFormat());
    }

    @Override
    public XMLGregorianCalendar read(JsonReader in) throws IOException {
        String value = in.nextString();
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}