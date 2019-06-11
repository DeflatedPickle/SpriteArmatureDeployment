package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("bone")
public class XMLBone {
    @XStreamAlias("name")
    @XStreamAsAttribute
    public String name;

    @XStreamImplicit(itemFieldName = "bone")
    public List<XMLBone> children;

    public XMLBone(String name, XMLBone... children) {
        this.name = name;
        this.children = Arrays.asList(children);
    }
}
