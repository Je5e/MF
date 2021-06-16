package com.kodigo.managmentflights.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public interface ISubMenu {
    List<Options> subOptions= unmodifiableList(new ArrayList<>());
     List<Options> getSubOptions();
    void setSubOptions(List<Options> subOptions);
}
