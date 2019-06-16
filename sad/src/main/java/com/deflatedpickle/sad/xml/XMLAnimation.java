package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("animation")
public class XMLAnimation {
    @XStreamImplicit(itemFieldName = "frame")
    public List<XMLFrame> frameList;

    public XMLAnimation(XMLFrame... frames) {
        this.frameList = Arrays.asList(frames);
    }
}
