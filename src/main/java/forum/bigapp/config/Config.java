package forum.bigapp.config;

import org.springframework.context.annotation.Configuration;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {
    public static final DateTimeFormatter format
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final String PATTERN_OF_EMAIL
            = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)"
            + "*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
}
