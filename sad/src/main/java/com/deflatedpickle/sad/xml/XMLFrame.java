package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("frame")
public class XMLFrame {
    @XStreamImplicit(itemFieldName = "bone-state")
    public List<XMLBoneState> boneStateList;

    public XMLFrame(XMLBoneState... boneStates) {
        this.boneStateList = Arrays.asList(boneStates);
    }
}
