package com.ddg.catrina.dto;

import lombok.Data;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;
public enum Name
{ BY_SA_30, BY_SA_40, CC_BY_SA_30;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BY_SA_30: return "BY-SA 3.0";
            case BY_SA_40: return "BY-SA 4.0";
            case CC_BY_SA_30: return "CC BY-SA 3.0";
        }
        return null;
    }

    @JsonCreator
    public static Name forValue(String value) throws IOException {
        if (value.equals("BY-SA 3.0")) return BY_SA_30;
        if (value.equals("BY-SA 4.0")) return BY_SA_40;
        if (value.equals("CC BY-SA 3.0")) return CC_BY_SA_30;
        throw new IOException("Cannot deserialize Name");
    }
}
