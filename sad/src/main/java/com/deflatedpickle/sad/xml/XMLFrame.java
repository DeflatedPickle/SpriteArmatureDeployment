package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("frame")
public class XMLFrame {
    public Integer index;

    @XStreamImplicit(itemFieldName = "bone-state")
    public List<XMLBoneState> boneStateList;

    public XMLFrame(Integer index, XMLBoneState... boneStates) {
        this.index = index;
        this.boneStateList = Arrays.asList(boneStates);
    }
}
