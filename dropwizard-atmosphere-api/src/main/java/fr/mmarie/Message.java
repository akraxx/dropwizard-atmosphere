package fr.mmarie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @see <a href="https://github.com/Atmosphere/atmosphere-samples/blob/master/samples/rest-chat/src/main/java/org/atmosphere/samples/chat/jersey/Message.java">Atmosphere documentation</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Message {
    private String author;

    private String message;
}
