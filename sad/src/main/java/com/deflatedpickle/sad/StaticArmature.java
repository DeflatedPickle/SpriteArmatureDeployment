package com.deflatedpickle.sad;

import com.deflatedpickle.sad.xml.*;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaticArmature {
    // Bone Name ("head") -> Frame Index (0) -> Property ("x") -> Value (10)
    // Bone Name ("head") -> Frame Index (0) -> Property ("parent") -> Value ("chest")
    public HashMap<String, HashMap<Integer, StaticBone>> bones = new HashMap<>();

    Integer totalFrames;

    public StaticArmature(URL xml) {
        XStream xStream = new XStream();
        xStream.processAnnotations(XMLAnimation.class);
        xStream.processAnnotations(XMLArmature.class);
        xStream.processAnnotations(XMLBone.class);
        xStream.processAnnotations(XMLBoneState.class);
        xStream.processAnnotations(XMLFrame.class);

        XMLArmature xmlArmature = (XMLArmature) xStream.fromXML(xml);
        totalFrames = xmlArmature.animation.frameList.size();

        iterateBones(xmlArmature.boneList, xmlArmature.animation.frameList, null);
    }

    private HashMap<String, StaticBone> iterateBones(List<XMLBone> xmlBoneList, List<XMLFrame> xmlFrameList, List<XMLBoneState> xmlBoneStateList) {
        HashMap<String, StaticBone> boneList = new HashMap<>();

        for (Integer xmlBoneIndex = 0; xmlBoneIndex < xmlBoneList.size(); xmlBoneIndex++) {
            XMLBone xmlBone = xmlBoneList.get(xmlBoneIndex);
            HashMap<Integer, StaticBone> frameMap = new HashMap<>();

            for (Integer frame = 0; frame < totalFrames; frame++) {
                XMLBoneState xmlBoneState;
                if (xmlBoneStateList != null) {
                    xmlBoneState = xmlBoneStateList.get(xmlBoneIndex);
                }
                else {
                    xmlBoneState = xmlFrameList.get(frame).boneStateList.get(xmlBoneIndex);
                }

                StaticBone bone = new StaticBone(xmlBone.name);
                boneList.put(bone.name, bone);

                HashMap<String, Object> boneProperties = new HashMap<>();
                boneProperties.put("x", xmlBoneState.x);
                boneProperties.put("y", xmlBoneState.y);
                bone.properties = boneProperties;

                if (xmlBone.children != null) {
                    bone.children = iterateBones(xmlBone.children, xmlFrameList, xmlBoneState.boneStateList);
                }

                frameMap.put(frame, bone);
            }

            bones.put(xmlBone.name, frameMap);
        }

        return boneList;
    }
}
