package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("armature")
public class XMLArmature {
    public XMLAnimation animation;

    @XStreamImplicit(itemFieldName = "bone")
    public List<XMLBone> boneList;

    public XMLArmature(XMLAnimation animation, XMLBone... bones) {
        this.animation = animation;
        this.boneList = Arrays.asList(bones);
    }
}
