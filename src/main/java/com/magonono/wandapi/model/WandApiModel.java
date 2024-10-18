package com.magonono.wandapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created for the WandApi project.
 *
 * @author Cesar "Aran" Pasillas
 */
@Setter
@Getter
public class WandApiModel {

    private String bodyResponse;
    private String codeStatus;
    private Map<String, List<String>> headers;


}
