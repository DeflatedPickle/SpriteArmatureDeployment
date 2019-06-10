package com.deflatedpickle.sad;

import com.deflatedpickle.sad.xml.*;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.HashMap;

public class Armature {
    // Bone Name ("head") -> Frame Index (0) -> Property ("x") -> Value (10)
    // Bone Name ("head") -> Frame Index (0) -> Property ("parent") -> Value ("chest")
    public HashMap<String, HashMap<Integer, HashMap<String, Object>>> bones = new HashMap<>();

    public Armature(URL xml) {
        XStream xStream = new XStream();
        xStream.processAnnotations(XMLAnimation.class);
        xStream.processAnnotations(XMLArmature.class);
        xStream.processAnnotations(XMLBone.class);
        xStream.processAnnotations(XMLBoneState.class);
        xStream.processAnnotations(XMLFrame.class);

        XMLArmature xmlArmature = (XMLArmature) xStream.fromXML(xml);

        Integer totalFrames = xmlArmature.animation.frameList.size();

        for (Integer i = 0; i < xmlArmature.boneList.size(); i++) {
            XMLBone xmlBone = xmlArmature.boneList.get(i);
            HashMap<Integer, HashMap<String, Object>> frameMap = new HashMap<>();

            for (Integer j = 0; j < totalFrames; j++) {
                HashMap<String, Object> propertyMap = new HashMap<>();
                propertyMap.put("parent", xmlBone.parent);
                propertyMap.put("children", xmlBone.children);
                propertyMap.put("x", xmlArmature.animation.frameList.get(j).boneStateList.get(i).x);
                propertyMap.put("y", xmlArmature.animation.frameList.get(j).boneStateList.get(i).y);

                frameMap.put(j, propertyMap);

                bones.put(xmlBone.name, frameMap);
            }
        }
    }
}
