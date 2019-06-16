package com.deflatedpickle.sad;

import com.deflatedpickle.sad.xml.*;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaticArmature {
    // Bone Name ("chest") -> Frame Index (0) -> Property ("x") -> Value (10)
    // Bone Name ("chest") -> Frame Index (0) -> Property ("parent") -> Value ("chest")
    public HashMap<String, HashMap<Integer, StaticBone>> bones = new HashMap<>();

    // Frame Index (0) -> Bone Name ("chest") -> Property ("x") -> Value (10)
    public List<HashMap<String, StaticBone>> frames = new ArrayList<>();

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

        iterateBones(null, xmlArmature.boneList, xmlArmature.animation.frameList, null);

        for (Integer frame = 0; frame < totalFrames; frame++) {
            frames.add(frame, iterateFrames(null, xmlArmature.boneList, xmlArmature.animation.frameList.get(frame).boneStateList));
        }
    }

    private HashMap<String, StaticBone> iterateBones(StaticBone parentBone, List<XMLBone> xmlBoneList, List<XMLFrame> xmlFrameList, List<XMLBoneState> xmlBoneStateList) {
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

                Integer x;
                Integer y;

                if (parentBone == null) {
                    x = xmlBoneState.x;
                    y = xmlBoneState.y;
                }
                else {
                    x = xmlBoneState.x + (int) parentBone.properties.get("x");
                    y = xmlBoneState.y + (int) parentBone.properties.get("y");
            }

                boneProperties.put("x", x);
                boneProperties.put("y", y);
                bone.properties = boneProperties;

                if (xmlBone.children != null) {
                    bone.children = iterateBones(bone, xmlBone.children, xmlFrameList, xmlBoneState.boneStateList);
                }

                frameMap.put(frame, bone);
            }
            
            bones.put(xmlBone.name, frameMap);
        }

        return boneList;
    }

    private HashMap<String, StaticBone> iterateFrames(StaticBone parentBone, List<XMLBone> xmlBoneList, List<XMLBoneState> xmlBoneStateList) {
        HashMap<String, StaticBone> boneList = new HashMap<>();

        for (int i = 0; i < xmlBoneList.size(); i++) {
            XMLBone xmlBone = xmlBoneList.get(i);
            XMLBoneState xmlBoneState = xmlBoneStateList.get(i);

            StaticBone bone = new StaticBone(xmlBone.name);

            HashMap<String, Object> boneProperties = new HashMap<>();

            Integer x;
            Integer y;

            if (parentBone == null) {
                x = xmlBoneState.x;
                y = xmlBoneState.y;
            }
            else {
                x = xmlBoneState.x + (int) parentBone.properties.get("x");
                y = xmlBoneState.y + (int) parentBone.properties.get("y");
            }

            boneProperties.put("x", x);
            boneProperties.put("y", y);
            bone.properties = boneProperties;

            if (xmlBone.children != null) {
                bone.children = iterateFrames(bone, xmlBone.children, xmlBoneState.boneStateList);
            }

            boneList.put(bone.name, bone);
        }

        return boneList;
    }
}
