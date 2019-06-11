package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

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

    @XStreamImplicit(itemFieldName = "bone-state")
    public List<XMLBoneState> boneStateList;

    public XMLBoneState(String name, Integer x, Integer y, XMLBoneState... boneStates) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.boneStateList = Arrays.asList(boneStates);
    }
}
