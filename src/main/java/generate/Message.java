package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * message
 * @author 
 */
@Data
public class Message implements Serializable {
    private Integer msgId;

    private String msgText;

    private String msgSummary;

    private static final long serialVersionUID = 1L;
}