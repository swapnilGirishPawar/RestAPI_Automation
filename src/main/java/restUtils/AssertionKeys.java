package restUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssertionKeys {
    private String jsonPath;
    private Object expectedValue;
    private Object actualValue;
    private String result;


    public AssertionKeys(String jsonPath, Object o, Object value, String matched) {
    }
}
