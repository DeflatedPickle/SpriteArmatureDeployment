package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("bone-state")
public class XMLBoneState {
    @XStreamAlias("name")
    @XStreamAsAttribute
    public String name;

    @XStreamAlias("x")
    @XStreamAsAttribute
    public Integer x;

    @XStreamAlias("y")
    @XStreamAsAttribute
    public Integer y;

    public XMLBoneState(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
