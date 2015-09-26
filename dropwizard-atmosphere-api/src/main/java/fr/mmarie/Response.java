package fr.mmarie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @see <a href="https://github.com/Atmosphere/atmosphere-samples/blob/master/samples/rest-chat/src/main/java/org/atmosphere/samples/chat/jersey/Response.java">Atmosphere documentation</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Response {
    private String text;

    private String author;

    private long time;

    public Response(String text, String author) {
        this.text = text;
        this.author = author;
        this.time = new Date().getTime();
    }
}
