package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("bone")
public class XMLBone {
    @XStreamAlias("name")
    @XStreamAsAttribute
    public String name;

    @XStreamAlias("parent")
    @XStreamAsAttribute
    public String parent;

    @XStreamAlias("children")
    @XStreamAsAttribute
    public String children;

    public XMLBone(String name, String parent, String children) {
        this.name = name;
        this.parent = parent;
        this.children = children;
    }
}
