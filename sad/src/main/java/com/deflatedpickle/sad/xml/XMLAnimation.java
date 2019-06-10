package com.deflatedpickle.sad.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

@XStreamAlias("animation")
public class XMLAnimation {
    @XStreamAlias("fps")
    @XStreamAsAttribute
    public Integer fps;

    @XStreamImplicit(itemFieldName = "frame")
    public List<XMLFrame> frameList;

    public XMLAnimation(Integer fps, XMLFrame... frames) {
        this.fps = fps;
        this.frameList = Arrays.asList(frames);
    }
}
